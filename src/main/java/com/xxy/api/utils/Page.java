package com.xxy.api.utils;

public class Page {

    private Integer currentPage=1; //当前页
    private Long count=0L; //总行数
    private Long total=0L; //总行数
    private Integer pageSize=10; //页大小
    private Integer totalPage=0; //总页数
    private  Integer pageOffset=0;//当前页起始记录
    private Integer pageTail=0; //当前页到达记录
    private Object object; //数据

    public Object getObject(){
        return object;
    }

    public void setObject(Object object){
        this.object=object;
    }

    public Integer getCurrentPage(){
        return currentPage;
    }

    public  void setCurrentPage(Integer currentPage)
    {
        this.currentPage=currentPage;
    }

    public  Long getCount(){
        return count;
    }

    public void setCount(Long count){
        this.count=count;
    }

    public Integer getPageSize(){
        return pageSize;
    }

    public void setPageSize(Integer pageSize){
        this.pageSize=pageSize;
    }

    public  Integer getTotalPage(){
        return totalPage;
    }

    public void setTotalPage(Integer totalPage)
    {
        this.totalPage=totalPage;
    }

    public Integer getPageOffset(){
        return pageOffset;
    }

    public void setPageOffset(Integer pageOffset){
        this.pageOffset=pageOffset;
    }

    public Integer getPageTail()
    {
        return pageTail;
    }

    public void setPageTail(Integer pageTail){
        this.pageTail=pageTail;
    }

    public Long getTotal(){
        return total;
    }

    public  void setTotal(Long total){
        this.total=total;
    }

}
