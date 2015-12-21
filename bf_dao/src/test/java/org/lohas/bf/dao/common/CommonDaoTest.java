package org.lohas.bf.dao.common;

import org.junit.Test;
import org.lohas.bf.dao.mapper.base.SpringTransactionalTestCase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lohas on 2015/9/1.
 * https://github.com/lohasle
 */
public class CommonDaoTest extends SpringTransactionalTestCase {
    @Autowired
    private JdbcTemplateDAO commonDao;


    @Test
    public void testGet() throws Exception {
        //测试取出单个对象
//        RowMapper<SnsUser> rowMapper = new RowMapper<SnsUser>() {
//            @Override
//            public SnsUser mapRow(ResultSet rs, int rowNum) throws SQLException {
//                SnsUser snsUser = new SnsUser();
//                snsUser.setId(rs.getObject("id", Integer.class));
//                snsUser.setUserName(rs.getObject("userName", String.class));
//                return snsUser;
//            }
//        };
//        SnsUser snsUser = commonDao.get("select id,user_name from sns_user where id=?", rowMapper,442);
//        System.out.println(snsUser);

    }

}
