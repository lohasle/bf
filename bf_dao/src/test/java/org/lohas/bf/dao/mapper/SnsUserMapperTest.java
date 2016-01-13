package org.lohas.bf.dao.mapper;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.lohas.bf.dao.entities.SnsUser;
import org.lohas.bf.dao.entities.SnsUserExample;
import org.lohas.bf.dao.mapper.base.SpringTransactionalTestCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by fule https:github.com/lohasle on 2016/1/13 0013.
 */
public class SnsUserMapperTest extends SpringTransactionalTestCase {

    @Autowired
    private SnsUserMapper snsUserMapper;

    @Test
    public void testSelectByExample() throws Exception {
        SnsUserExample snsUserExample = new SnsUserExample();
        snsUserExample.setLimitStart(0);
        snsUserExample.setLimitEnd(10);
        List<SnsUser> snsUsers = snsUserMapper.selectByExample(snsUserExample);
        System.out.println(JSON.toJSONString(snsUsers));
    }
}