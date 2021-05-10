package demo.service.impl;

import demo.dao.DemoDao;
import demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoDao demoDao;

    @Override
    @Async("asyncServiceExecutor")
    public void serviceTest(String username) {
        log.info("开启执行一个Service, 这个Service执行时间为30s, threadId:{}", Thread.currentThread().getId());
        demoDao.add(username, Integer.parseInt(Thread.currentThread().getId() + ""), "started");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("执行完成一个Service, threadId:{}", Thread.currentThread().getId());
        demoDao.update(username, Integer.parseInt(Thread.currentThread().getId() + ""), "ended");
    }
}
