package org.lohas.bf.spring.bean;


/**
 * Created by fule on 14-6-7.
 */

/**
 * 分页查询通用模型
 * pageSize 页面大小
 * pageNum 页码
 * qryParams 查询条件对象
 * super：jsonObject  存放了一个描述查询条件字符串的jsonObject
 * @param <T>
 */
public class PageParam<T> extends JSONObjectWrapper {
    private int pageSize = 10;
    private int pageNum =1;
    private T qryParams;

    public T getQryParams() {
        return qryParams;
    }

    public void setQryParams(T qryParams) {
        this.qryParams = qryParams;
    }

    public PageParam() {
    }

    public PageParam(int pageSize, int pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public PageParam(int pageSize, int pageNum,T qryParams) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.qryParams = qryParams;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

}
