package org.lohas.bf.web.view.DataTable;

import org.lohas.bf.pojo.PageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lohas on 2015/8/18.
 * https://github.com/lohasle
 * dataTables 返回数据格式
 */
public class DataTables<T> {
    private int draw;
    private int recordsFiltered;
    private int recordsTotal;
    private String error;
    private List<T> data = new ArrayList<>();

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private DataTables() {
    }

    public static DataTables Create() {
        return new DataTables();
    }

    /**
     * pageBean  转为DataTables
     *
     * @param pageBean
     * @param draw
     * @return
     */
    public DataTables<T> format(PageBean<T> pageBean, int draw) {
        DataTables<T> dataTables = new DataTables();
        dataTables.setData(pageBean.getRows());
        dataTables.setDraw(draw);
        dataTables.setRecordsTotal(pageBean.getRowCount().intValue());
        dataTables.setRecordsFiltered(dataTables.getRecordsTotal());
        return dataTables;
    }

    /**
     * pageBean  转为DataTables
     *
     * @param pageBean
     * @param dataTablesReqPar
     * @return
     */
    public DataTables<T> format(PageBean<T> pageBean, DataTablesReqPar dataTablesReqPar) {
        DataTables<T> dataTables = new DataTables();
        dataTables.setData(pageBean.getRows());
        dataTables.setDraw(dataTablesReqPar.getDraw());
        dataTables.setRecordsTotal(pageBean.getRowCount().intValue());
        dataTables.setRecordsFiltered(dataTables.getRecordsTotal());
        return dataTables;
    }
}
