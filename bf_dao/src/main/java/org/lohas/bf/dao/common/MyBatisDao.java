package org.lohas.bf.dao.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lohas on 2015/3/18.
 * 0901
 * 通用DAO 建议使用mapper 不推荐使用这种方式
 */
@Deprecated
public class MyBatisDao {
    //    @Autowired
    private SqlSession sqlSession;

    /**
     * 查询一个对象
     *
     * @param statementId
     * @param params
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId, Object params) {
        return sqlSession.selectOne(statementId, params);
    }
}
