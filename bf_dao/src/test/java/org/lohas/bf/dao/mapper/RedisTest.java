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

    @Test
    public void test2() {
        List testList = new ArrayList();
        testList.add(1);
        testList.add(2);
        listRedisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        listRedisTemplate.opsForValue().set("userList", testList);
        List list = listRedisTemplate.opsForValue().get("userList");
        System.out.println(list);
    }


    public static Jedis getJedis(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("lohas");
        return jedis;
    }

    public static void main(String[] args) {
        for(int j=0;j<10;j++){
            final int k = j;
            final long a = System.currentTimeMillis();
            ThreadPollExecutor.exeThread(new Runnable() {
                final Jedis jedis = getJedis();

                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
//                        jedis.set(k + ":test:" + i, "test" + i);
                        jedis.del(k + ":test:" + i);
                    }
                    System.out.println(Thread.currentThread().toString() +k+"耗时 " + (System.currentTimeMillis() - a));
                }
            });
        }
    }
}
