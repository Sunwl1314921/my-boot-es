package com.boot.es.mybootes;

import com.boot.es.mybootes.clone.Child;
import org.springframework.web.bind.annotation.*;

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
    public void tes(@RequestParam String name) {

        String names = name;

        System.out.println("123456");
    }


}
