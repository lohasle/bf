package org.lohas.bf.services.impl;

import org.junit.Test;
import org.lohas.bf.services.SpringTransactionalTestCase;
import org.lohas.bf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fule https:github.com/lohasle on 2016/1/13 0013.
 */
public class UserServiceImplTest extends SpringTransactionalTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        userService.getUser();
    }
}