package org.lohas.bf.web.controller;


import org.lohas.bf.pojo.Message;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserControllerTest  {


    @Test
    public void testLogin() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity =    restTemplate.getForEntity("http://127.0.0.1:8090/server/login?phone=15279113046&password=123456", Message.class);
        Object sn = responseEntity.getBody();
    }

    @Test
    public void testRegister() throws Exception {

    }
}