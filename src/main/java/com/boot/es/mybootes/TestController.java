package com.boot.es.mybootes;

import com.boot.es.mybootes.IP.IPUtils;
import com.boot.es.mybootes.clone.Child;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rt")
public class TestController {

    @RequestMapping(value = "/pay/{name}")
    public void transferPay(@RequestBody Child child,@PathVariable int name) {
        int id = child.getIds();
        String name222 = child.getName();

        int names = name;

        System.out.println("123456");
    }

    @RequestMapping(value = "/p", method = RequestMethod.GET)
    public void tes(@RequestParam String name, HttpServletRequest request) {

        String names = name;

        System.out.println("123456");

        String ip1= IPUtils.getIpAddr(request);
        System.out.println("ip1----"+ip1);
        String ip2= IPUtils.getClientIp(request);
        System.out.println("ip2----"+ip2);
    }




}
