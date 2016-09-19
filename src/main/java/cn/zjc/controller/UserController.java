package cn.zjc.controller;

import cn.zjc.entity.User;
import cn.zjc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhangjinci
 * @version 2016/9/19 11:52
 * @function
 */
@Controller
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/query/{id}", method = RequestMethod.GET)
    public String query(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("users", userService.queryUserById(id));
        log.debug("users size---> " + userService.queryUserById(id).size());
        return "index";
    }
}
