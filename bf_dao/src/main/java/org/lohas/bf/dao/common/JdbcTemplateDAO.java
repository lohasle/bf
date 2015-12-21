package org.lohas.bf.dao.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by lohas on 2015/3/18.
 */
public class JdbcTemplateDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * 添加或者修改
     *
     * @param sql
     * @param params
     * @return
     */
    public long merge(String sql, Object[] params) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, params);
        Number number = generatedKeyHolder.getKey();
        return number.longValue();
    }

    /**
     * 删除
     *
     * @param sql
     * @param params
     */
    public void delete(String sql, Object[] params) {
        jdbcTemplate.update(sql, params);
    }

    /**
     * 取得单个对象
     *
     * @return
     */
    public <T> T get(String sql, RowMapper<T> rowMapper, Object... params) {
        return jdbcTemplate.queryForObject(sql, rowMapper, params);
    }
}
