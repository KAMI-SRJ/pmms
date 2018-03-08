package com.dugstudio.pmms.dto;



public class ArticleQueryDto {

    //数据获取类型（如全部、已审核等）
    private String type;

    //标题
    private String title;

    //发布者
    private String publisher;

    //开始时间
    private String startDate;

    //结束时间
    private String endDate;

    //前N条数据
    private Integer top;

    //按发布日期排序样式：up为升序，down为降序
    private String createDateSortCss;

    private int currentPage;
    private  int pageSize;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreateDateSortCss() {
        return createDateSortCss;
    }

    public void setCreateDateSortCss(String createDateSortCss) {
        this.createDateSortCss = createDateSortCss;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

}


