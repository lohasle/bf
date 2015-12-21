package org.lohas.bf.web.controller.backstage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fule https:github.com/lohasle on 2015/12/11 0011.
 */
@Controller
@RequestMapping("/backstage/")
public class BackstageIndexController {

    @RequestMapping(value = {"index", ""})
    public String indexPage() {
        return "backstage/index";
    }

    @RequestMapping("login")
    public String loginPage() {
        return "backstage/login";
    }
}
