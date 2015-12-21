package org.lohas.bf.dao.common;

/**
 * Created by lohas on 2015/2/5.
 * dao层 page 参数
 */
public class PageBeanParams {

    private Integer limitStart;
    private Integer limitEnd;
    private String order;

    // 页码
    private Integer pageNo;

    // 页面大小
    private Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart = limitStart;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd = limitEnd;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


    public PageBeanParams() {
    }

    public PageBeanParams(Integer limitStart, Integer limitEnd) {
        this.limitStart = limitStart;
        this.limitEnd = limitEnd;
        this.pageSize =limitEnd;
        this.pageNo =(limitStart/limitEnd)+1;
    }

    public PageBeanParams(Integer limitStart, Integer limitEnd, String order) {
        this.limitStart = limitStart;
        this.limitEnd = limitEnd;
        this.order = order;
    }

    public PageBeanParams( Integer limitStart, Integer limitEnd,Integer pageNo,Integer pageSize) {
        this.pageSize = pageSize;
        this.limitStart = limitStart;
        this.limitEnd = limitEnd;
        this.pageNo = pageNo;
    }
    public PageBeanParams( Integer limitStart, Integer limitEnd,String order,Integer pageNo,Integer pageSize) {
        this.pageSize = pageSize;
        this.limitStart = limitStart;
        this.limitEnd = limitEnd;
        this.pageNo = pageNo;
        this.order = order;
    }


    public static PageBeanParams getPageBeanParams(Integer pageIndex,Integer pageSize){
        Integer limitStart = (pageIndex-1)*pageSize;
        Integer limitEnd = pageSize;
        return  new PageBeanParams(limitStart,limitEnd,pageIndex,pageSize);
    }


    public static PageBeanParams getPageBeanParams(Integer pageIndex,Integer pageSize,String order){
        Integer limitStart = (pageIndex-1)*pageSize;
        Integer limitEnd = pageSize;
        return  new PageBeanParams(limitStart,limitEnd,order,pageIndex,pageSize);
    }
}
