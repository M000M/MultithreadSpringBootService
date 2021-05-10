import demo.MainApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = MainApplication.class)
@RunWith(SpringRunner.class)
public class MQTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend("address", "49.232.78.91");
        }
    }
}
