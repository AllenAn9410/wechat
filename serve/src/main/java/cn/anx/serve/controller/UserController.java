package cn.anx.serve.controller;

import cn.anx.serve.entity.ServeResponse;
import cn.anx.serve.entity.UserInfo;
import cn.anx.serve.service.IUserInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author anxin
 * @since 2022/02/16 10:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserInfoService userInfoService;

    @GetMapping("/list")
    public ServeResponse<List<UserInfo>> listUsers() {
        List<UserInfo> userInfos = userInfoService.listUsers();
        return ServeResponse.success(userInfos);
    }

    @GetMapping("/page")
    public ServeResponse<List<UserInfo>> pageUsers(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        PageInfo<UserInfo> pageUser = userInfoService.pageUsers(pageSize, pageNo);
        List<UserInfo> list = pageUser.getList();
        return ServeResponse.success(list);
    }

}
