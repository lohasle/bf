package org.lohas.bf.web.controller.rest;

import org.lohas.bf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fule https:github.com/lohasle on 2016/1/13 0013.
 * restful  use interface
 */
@RestController
@RequestMapping("/rest/user")
public class RestUserController {


    @Autowired
    private UserService userService;


    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity login() {
        return null;
    }


    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "loginOut", method = RequestMethod.GET)
    public ResponseEntity loginOut() {
        return null;
    }


    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register() {
        return null;
    }


    /**
     * 修改
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity update(@PathVariable String id) {
        return null;
    }

    /**
     * 取得用户信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable String id) {
        return null;
    }


    /**
     * 头像修改
     */
    @RequestMapping(value = "/{id}/avatar", method = RequestMethod.POST)
    public ResponseEntity updateAvatar() {
        return null;
    }


    /**
     * 找回密码
     *
     * @return
     */
    @RequestMapping(value = "/{id}/password", method = RequestMethod.POST)
    public ResponseEntity findPwd(@PathVariable String id) {
        return null;
    }


    /**
     * 刷新token
     */
    @RequestMapping(value = "/{id}/token", method = RequestMethod.GET)
    public ResponseEntity refreshToken(@PathVariable String id) {
        return null;
    }


}
