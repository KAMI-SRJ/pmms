package com.dugstudio.pmms.controller;

import com.dugstudio.pmms.annotation.Before;
import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.DocumentQueryDto;
import com.dugstudio.pmms.entity.Document;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.User;
import com.dugstudio.pmms.interceptor.AdminInterceptor;
import com.dugstudio.pmms.service.DocumentService;
import com.dugstudio.pmms.service.UserService;
import com.dugstudio.pmms.util.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
@Controller("upload")
@RequestMapping(value = {"/upload","document"})
@Before(AdminInterceptor.class)
public class UploadController extends BaseController{

	public final static String ATTACH_SAVE_PATH = "attach";
	@Autowired
    private DocumentService documentService;
	@Autowired
	private UserService userService;
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mav=new ModelAndView();
		mav.addObject("half_path","../public");
		mav.addObject("jsp_name","document/upload");
		String type=request.getParameter("type");
        System.out.println(type+"-------------------------------");
        if(StringUtils.isNotBlank(type.trim())){
			mav.addObject("type",type);
		}else{
			type="心得体会";
			mav.addObject("type",type);
		}
		mav.setViewName("manager/index");
		return mav;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult ajaxUploadFile(HttpServletRequest re) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) re;
		System.out.println("ajaxUploadFile");
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setSuccess(false);
		try {
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			MultipartFile multipartFile = null;
			String fileName = null;
			for (Map.Entry<String, MultipartFile> set : fileMap.entrySet()) {
				multipartFile = set.getValue();// 文件名
			}
			fileName = this.storeIOc(multipartRequest, multipartFile);
			System.out.println("ajaxUploadFile"+fileName);
			ajaxResult.setData(fileName);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ajaxResult;
	}
	
	// 接受图片，返回文件地址
	private String storeIOc(HttpServletRequest request, MultipartFile file) {
		String result ="";
		String fileName ="";
		StringBuffer logImageName = new StringBuffer();
		try {
			request.setCharacterEncoding("utf-8");

		String realPath = request.getSession().getServletContext().getRealPath("uploads");
		String id =request.getParameter("id");
		System.out.println(id);
		String type= request.getParameter("type");
		String description=request.getParameter("description");
		if(StringUtils.isNotBlank(id)){
		if (file == null) {
			return null;
		}

		if (file.isEmpty()) {
			result="文件未上传";
		} else {
			String _fileName = file.getOriginalFilename();
			String suffix = _fileName.substring(_fileName.lastIndexOf("."));
			if(StringUtils.isNotBlank(suffix)){
				if(suffix.equalsIgnoreCase(".txt") || suffix.equalsIgnoreCase(".xls") || suffix.equalsIgnoreCase(".xlsx") || suffix.equalsIgnoreCase(".txt")|| suffix.equalsIgnoreCase(".png")
						  || suffix.equalsIgnoreCase(".doc") || suffix.equalsIgnoreCase(".docx") || suffix.equalsIgnoreCase(".pdf") 
						  || suffix.equalsIgnoreCase(".ppt") || suffix.equalsIgnoreCase(".pptx")|| suffix.equalsIgnoreCase(".gif")
						  || suffix.equalsIgnoreCase(".jpg")|| suffix.equalsIgnoreCase(".jpeg")|| suffix.equalsIgnoreCase(".bmp")){
					// /**使用UUID生成文件名称**/
					if(null!=documentService.findDocumentByName(logImageName.toString())){
                    	logImageName.append(UUID.randomUUID()+suffix);
                    }else
                    	logImageName.append(_fileName);
					fileName = realPath + File.separator + ATTACH_SAVE_PATH + File.separator + logImageName;
					File restore = new File(fileName);//创建一个不存在内容的文件
					System.out.println(restore.exists()+"   "+restore.mkdirs()+" 真实的上传地址： "+restore.getPath());
					try {
						file.transferTo(restore);
						Document doc=new Document();
						doc.setCreateDate(new Date());
						doc.setName(logImageName.toString());
						doc.setPath(restore.getPath());
						User publisher=userService.findUserById(id);
						if(publisher!=null){
							doc.setPublisher(publisher);
							if(StringUtils.isNotBlank(type)){
								if("心得体会".equals(type.trim())){
									doc.setType(0);
								}
								if("思想汇报".equals(type.trim())){
									doc.setType(1);
								}
								if("学习资料".equals(type.trim())){
									doc.setType(2);
								}
								if(StringUtils.isNotBlank(description)) {
									doc.setDescription(description);
								}

							}else{
								result="上传类型不正确";
								return result;
							}

						}else {
							result = "登陆之后才能上传文件，请先登录";
							return result;
						}
						if(documentService.saveDocument(doc)){
							result="保存成功 ";
						}
						
						result = "/uploads/attach/" + logImageName;
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}else{
					result = "文件格式不对，只能上传txt、ppt、ptx、doc、docx、xls、xlsx、pdf、png、jpg、jpeg、gif、bmp格式";
				}
			}
		}
		}else{
			result="登陆之后才能上传文件，请先登录";
		}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
    //通过期数，年级，专业，查询心得，思想汇报
    @RequestMapping("/documentAllPage")
	public ModelAndView getAllByType(){
        DocumentQueryDto documentQueryDto=new DocumentQueryDto();
	    ModelAndView mav=new ModelAndView();
	    try {
	    	request.setCharacterEncoding("utf-8");
            String queryType = request.getParameter("query_type");
            String type = request.getParameter("type");
            String name = request.getParameter("name");
            String clazz = request.getParameter("clazz");
            String publisher = request.getParameter("publisher");
            String profession = request.getParameter("profession");
            String teacher = request.getParameter("teacher");
            String currentPage = request.getParameter("currentPage");
            String pageSize = request.getParameter("pageSize");
            String queryWord = request.getParameter("keyword");
            String createDate=request.getParameter("createDate");
            String endDate =request.getParameter("endDate");
            System.out.println("queryType:" + queryType + "queryWord:" + queryWord);
            if (StringUtils.isNotBlank(createDate)){
            	documentQueryDto.setCreateDate(createDate);
			}
			if (StringUtils.isNotBlank(endDate)){
            	documentQueryDto.setEndDate(endDate);
			}
            if (StringUtils.isNotBlank(currentPage)) {
                documentQueryDto.setCurrentPage(Integer.parseInt(currentPage));
            } else {
                documentQueryDto.setCurrentPage(1);
            }
            if (StringUtils.isNotBlank(pageSize)) {
                documentQueryDto.setPageSize(Integer.parseInt(pageSize));
            } else {
                documentQueryDto.setPageSize(10);
            }
            documentQueryDto.setName(name);
            documentQueryDto.setPublisher(publisher);
            documentQueryDto.setTeacher(teacher);
            documentQueryDto.setType(type);
            documentQueryDto.setClazz(clazz);
            documentQueryDto.setProfession(profession);
			documentQueryDto.setCreateDate(createDate);
			documentQueryDto.setEndDate(endDate);
            if (StringUtils.isNotBlank(queryType) && StringUtils.isNotBlank(queryWord)) {
                if ("name".equals(queryType)) {
                    documentQueryDto.setName(queryWord);
                }
                if ("publisher".equals(queryType)) {
					System.out.println("set  query   publisher ");
					documentQueryDto.setPublisher(queryWord);
					System.out.println("documentQueryDto.setPublisher(queryWord);"+documentQueryDto.getPublisher());
				}
                if ("type".equals(queryType)) {
					documentQueryDto.setType(queryWord);
				}
				if ("createDate".equals(queryType)) {
					documentQueryDto.setCreateDate(queryWord);
				}
				if ("endDate".equals(queryType)) {
					documentQueryDto.setEndDate(queryWord);
				}
            }
			System.out.println("查询 dto："+documentQueryDto);
			System.out.println(queryType + "------" + name);
            Page<Document> docs = documentService.findDocumentByPage(documentQueryDto);
            if (docs != null) {
                mav.addObject("doc_name", type);
                mav.addObject("page", docs);
                mav.addObject("half_path", "../public");
                mav.addObject("jsp_name", "document/page");
                mav.setViewName("manager/index");
            }
        }catch(Exception e){
	        e.printStackTrace();
            mav.addObject("half_path", "./common");
            mav.addObject("jsp_name", "fail");
	        mav.setViewName("/manager/index");
	        return mav;
        }
	    return mav;
    }
    @RequestMapping("/pagai")
    public  ModelAndView piGai(){
	    ModelAndView mav=new ModelAndView();
	    try {
	        request.setCharacterEncoding("utf-8");
	        String score=request.getParameter("score");
	        String comment=request.getParameter("comment");
            String docId = request.getParameter("docId");
            User teacher = (User) request.getAttribute("user");
            if (teacher != null && StringUtils.isNotBlank(docId)) {
                Document doc = documentService.findDocumentById(docId);
                if (doc != null) {
                    if(StringUtils.isNotBlank(score)){
                        doc.setScore(Double.parseDouble(score));
                    }
                    if(StringUtils.isNotBlank(comment)){
                        doc.setComment(comment);
                    }
                    doc.setAuditDate(new Date());
                    doc.setTeacher(teacher.getUsername());
                    boolean b = documentService.saveDocument(doc);
                    if (b){
                        mav.addObject("msg","添加成功");
                        mav.setViewName("redirect:/document/documentAllPage.do");
                    }else{
                        mav.addObject("half_path", "./common");
                        mav.addObject("jsp_name", "fail");
                        mav.setViewName("/manager/index");
                    }
                }
            }
        }catch(Exception e){
	        e.printStackTrace();
            mav.setViewName("/manager/index");
	        return mav;
        }
            return mav;
    }
    @RequestMapping("/delete")
    public ModelAndView delete(){
	ModelAndView mav =new ModelAndView();
	String id=request.getParameter("id");
	if (StringUtils.isNotBlank(id)){
		Document doc=documentService.findDocumentById(id);
		if (doc!=null){
			documentService.delete(doc);
			System.out.println("document "+doc.getName()+":delete");
			mav.setViewName("redirect:/document/documentAllPage.do");
			return mav;
		}
	}
		mav.addObject("half_path", "./common");
		mav.addObject("jsp_name", "fail");
		mav.setViewName("/manager/index");
	return mav;

	}
}
