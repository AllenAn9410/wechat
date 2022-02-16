package cn.anx.serve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author anxin
 * @since 2022/02/16 10:51
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/ping")
    public String testPing(HttpServletRequest request) {
        return "ping successfully";
    }
}
