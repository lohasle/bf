package org.lohas.bf.pojo;

import java.util.List;

/**
 * Created by lohas on 2015/2/7.
 */
public interface Page<T> {

    void setTotal(int count);

    void setRows(List<T> rows);

    void setParams(int pageNo, int pageSize);
}
