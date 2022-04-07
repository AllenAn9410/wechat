package cn.anx.serve.controller;

import cn.anx.serve.entity.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP控制层.
 * @author 安鑫(anx @ microvideo.cn)
 * @since 2022/03/08 09:56
 */
@Slf4j
@RestController
@RequestMapping("/ip")
public class IpController {

    @GetMapping
    public ServerResponse<String> obtainIp(HttpServletRequest request) {
        String ip;
        try {
            InetAddress address = InetAddress.getLocalHost();
            log.info("server address IP :[{}]", address.getHostAddress());
            ip = getIpAddress(request);
        } catch (UnknownHostException e) {
            log.error("获取IP异常:[{}]", e.getMessage());
            return ServerResponse.fail("获取IP异常");
        }
        return ServerResponse.success("获取IP成功", ip);
    }

    /**
     * 获取调用端IP地址.
     * @param request 请求实体
     * @return String
     */
    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        log.info("x-forwarded-for ip: [{}]", ip);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if(ip.contains(",")){
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info("Proxy-Client-IP ip: [{}]", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info("WL-Proxy-Client-IP ip: [{}]", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info("HTTP_CLIENT_IP ip: [{}]", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info("HTTP_X_FORWARDED_FOR ip: [{}]", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            log.info("X-Real-IP ip: [{}]", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            log.info("getRemoteAddr ip: [{}]", ip);
        }
        log.info("获取客户端ip: [{}]", ip);
        return ip;
    }
}
