package org.lohas.bf.web.view.DataTable;

import org.lohas.bf.dao.common.PageBeanParams;

import java.util.List;

/**
 * Created by lohas on 2015/8/18.
 * https://github.com/lohasle
 * dataTables 请求数据格式
 */
public class DataTablesReqPar {

    /**
     * 搜索参数
     */
    private Search search;

    /**
     * 列参数
     */
    private List<Columns> columns;
    /**
     * 开始行数
     */
    private int start;
    /**
     * 行大小
     */
    private int length;
    /**
     * 请求次数
     */
    private int draw;
    /**
     * 排序参数
     */
    private List<Order> order;

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public List<Columns> getColumns() {
        return columns;
    }

    public void setColumns(List<Columns> columns) {
        this.columns = columns;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public static class Search {
        private boolean regex;
        private String value;

        public boolean getRegex() {
            return regex;
        }

        public void setRegex(boolean regex) {
            this.regex = regex;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Search{" +
                    "regex=" + regex +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static class Columns {
        private Search search;
        private String data;
        private boolean orderable;
        private String name;
        private boolean searchable;

        public Search getSearch() {
            return search;
        }

        public void setSearch(Search search) {
            this.search = search;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public boolean getOrderable() {
            return orderable;
        }

        public void setOrderable(boolean orderable) {
            this.orderable = orderable;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean getSearchable() {
            return searchable;
        }

        public void setSearchable(boolean searchable) {
            this.searchable = searchable;
        }

        @Override
        public String toString() {
            return "Columns{" +
                    "search=" + search +
                    ", data='" + data + '\'' +
                    ", orderable=" + orderable +
                    ", name='" + name + '\'' +
                    ", searchable=" + searchable +
                    '}';
        }
    }

    public static class Order {
        private int column;
        private String dir;
        private String cloumnName;

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getCloumnName() {
            return cloumnName;
        }

        public void setCloumnName(String cloumnName) {
            this.cloumnName = cloumnName;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "column=" + column +
                    ", dir='" + dir + '\'' +
                    ", cloumnName='" + cloumnName + '\'' +
                    '}';
        }
    }


    /**
     * 取得分页参数
     *
     * @return
     */
    public PageBeanParams getPageBeanParams() {
        return new PageBeanParams(this.start, this.length);
    }


    /**
     * 取得排序值
     * 如  modify_time asc
     *
     * @return
     */
    public String getOrderString() {
        String orderStr = "";
        if (order != null && order.size() > 0) {
            Order order1 = order.get(0);

            int orderColumnIndex = order1.getColumn();
            String dir = order1.getDir();
            String cloumnName = columns.get(orderColumnIndex).getName();

            order1.setCloumnName(cloumnName);

            orderStr = " " + cloumnName + " " + dir;
        }
        return orderStr;
    }

    /**
     * 取得排序值
     * 如  modify_time asc
     *
     * @return
     */
    public Order getOrderPar() {
        if (order != null && order.size() > 0) {
            Order order1 = order.get(0);

            int orderColumnIndex = order1.getColumn();

            String cloumnName = columns.get(orderColumnIndex).getName();

            order1.setCloumnName(cloumnName);
        }
        return order.get(0);
    }


    @Override
    public String toString() {
        return "DataTablesReqPar{" +
                "search=" + search +
                ", columns=" + columns +
                ", start=" + start +
                ", length=" + length +
                ", draw=" + draw +
                ", order=" + order +
                '}';
    }
}
