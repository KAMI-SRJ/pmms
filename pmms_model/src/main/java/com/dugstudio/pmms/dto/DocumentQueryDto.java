package com.dugstudio.pmms.dto;

public class DocumentQueryDto {
    private String name;
    private String publisher;
    private String teacher;
    private String type;
    private int currentPage;
    private int pageSize;
    private String createDate;
    private String endDate;
    private String clazz;
    private String profession;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DocumentQueryDto{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", teacher='" + teacher + '\'' +
                ", type='" + type + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", createDate='" + createDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", clazz='" + clazz + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
