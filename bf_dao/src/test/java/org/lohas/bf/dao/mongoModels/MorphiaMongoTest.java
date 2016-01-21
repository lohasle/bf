package org.lohas.bf.dao.mongomodels;

import org.junit.Test;
import org.lohas.bf.dao.mapper.base.SpringTransactionalTestCase;
import org.lohas.bf.dao.mongomodels.morphia.UserMo;
import org.lohas.bf.dao.mongomodels.morphia.UserMoLogs;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lohas on 2015/11/5.
 * https://github.com/lohasle
 */
public class MorphiaMongoTest extends SpringTransactionalTestCase {

    @Autowired
    private Datastore datastore;


    @Test
    public void test1() {
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            UserMo user = new UserMo();
            user.setCreateTime(new Date());


            List<Object> objects = new ArrayList<>();
            HashMap<Object, Object> map = new HashMap<>();
            map.put("a", "a");
            objects.add(map);
            user.setInner(objects);


            UserMoLogs hh = new UserMoLogs("hh");
            datastore.save(hh);

            ArrayList<UserMoLogs> userLogses = new ArrayList<>();
            userLogses.add(hh);

            user.setUserLogses(userLogses);


            Key<UserMo> save = datastore.save(user);
            System.out.println(save);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - beginTime);
    }

    @Rollback(false)
    @Test
    public void test2() {
        long beginTime = System.currentTimeMillis();

        datastore.delete(datastore.createQuery(UserMoLogs.class));
        for (int i = 0; i < 100; i++) {


            UserMoLogs hh = new UserMoLogs("hh");
            datastore.save(hh);
            System.out.println(hh);

        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - beginTime);
    }


}
