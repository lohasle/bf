package org.lohas.bf.dao.mapper;

import org.junit.Test;
import org.lohas.bf.dao.mapper.base.SpringTransactionalTestCase;
import org.lohas.bf.utils.ThreadPollExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lohas on 2015/9/24.
 * https://github.com/lohasle
 */
public class RedisTest extends SpringTransactionalTestCase {
    @Autowired
    private RedisTemplate<String, String> template;

    @Autowired
    private RedisTemplate<String, List> listRedisTemplate;


    @Test
    public void test1() {
        String stirng = template.opsForValue().get("test");
        System.out.println(stirng);

        ValueOperations<String, String> operations = template.opsForValue();

        operations.set("test2", "测试");

        System.out.println(operations.get("test2"));

        operations.set("test2", "测试2");

        System.out.println(operations.get("test2"));

        operations.append("test2", "ahahah");

        System.out.println(operations.get("test2"));

//        template.delete("test2");


        System.out.println(operations.get("test2"));

    }


    public static Jedis getJedis(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("lohas");
        return jedis;
    }

}
