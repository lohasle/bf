package org.lohas.bf.dao.common;

import org.junit.Test;
import org.lohas.bf.dao.mapper.base.SpringTransactionalTestCase;
import org.springframework.beans.factory.annotation.Autowired;
@Deprecated
public class MybatisDaoTest extends SpringTransactionalTestCase {

    @Autowired
    private MyBatisDao myBatisDao;

    @Autowired

    @Test
    public void testMerge() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }


    @Test
    public void testSELECT(){
        for (int i=0;i<50;i++){
            _testtest();
        }
    }

    private void _testtest(){long s1 = System.currentTimeMillis();
//        int count = 5000;
//        for (int i=0;i<count;i++){
//            int userId = new Random().nextInt(count/100);
//            SnsUser snsUser = myBatisDao.selectOne("SnsUserMapper.selectByPrimaryKey", userId);
////            System.out.println(snsUser);
//        }
//        long s2 =  System.currentTimeMillis();
//        System.out.println("DAO:-->"+(s2-s1));
//        System.out.println("---------->");
//
//        long sa1 = System.currentTimeMillis();
//        for (int i=0;i<count;i++){
//            int userId = new Random().nextInt(count/100);
//            SnsUser snsUser = userMapper.selectByPrimaryKey(count);
////            System.out.println(snsUser);
//        }
//        long sa2 =  System.currentTimeMillis();
//        System.out.println("DAO:-->"+(sa2-sa1));

    }



}