package demo.controller;

import demo.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @RequestMapping(value = "/add")
    public void add(@RequestParam("username") String username) {
        try {
            demoService.serviceTest(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
