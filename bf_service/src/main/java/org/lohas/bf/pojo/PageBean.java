package org.lohas.bf.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lohas on 2015/2/6.
 * pagebean 对象
 */
public class PageBean<T> implements Serializable {


    /**
     * 当前页
     */
    private int pageNo;

    /**
     * 分页大小
     */
    private int pageSize;


    /**
     * 总页数
     */
    private Long pageTotal;

    /**
     * 总记录数
     */
    private Long rowCount;

    /**
     * 数据
     */
    private List<T> rows;


    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Long pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Long getRowCount() {
        return rowCount;
    }

    public void setRowCount(Long rowCount) {
        this.rowCount = rowCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageBean(){}


    //得到总页数
    public static Long getPageTotalByCount(int pageSize,Long rowCount){
        if(rowCount%pageSize==0){
            return rowCount/pageSize;
        }else{
            return (rowCount/pageSize)+1;
        }
    }


    /**
     * 创建 pagebean
     * @param rows
     * @param rowCount
     * @param pageNo
     * @param pageSize
     * @return
     */
    public static PageBean buildPageBean(List rows,Long rowCount,int pageNo,int pageSize){
        PageBean pageBean = new PageBean<>();
        pageBean.setRowCount(rowCount);
        pageBean.setPageTotal(getPageTotalByCount(pageSize,rowCount));
        pageBean.setPageNo(pageNo);
        pageBean.setRows(rows);
        pageBean.setPageSize(pageSize);
        return pageBean;
    }

}
