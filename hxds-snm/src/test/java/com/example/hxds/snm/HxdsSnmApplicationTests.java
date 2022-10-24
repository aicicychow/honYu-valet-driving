package com.example.hxds.snm;

import com.example.hxds.snm.entity.NewOrderMessage;
import com.example.hxds.snm.task.NewOrderMassageTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HxdsSnmApplicationTests {

    @Resource
    private NewOrderMassageTask newOrderMassageTask;

    @Test
    public void send() {
        NewOrderMessage message = new NewOrderMessage();
        message.setUserId("9527");
        message.setFrom("沈阳北站");
        message.setTo("北京西站");
        message.setDistance("100");
        message.setExpectsFee("45.5");
        message.setFavourFee("0");
        message.setMileage("18.6");
        message.setMinute("10");
        ArrayList list = new ArrayList(){{
            add(message);
        }};
        newOrderMassageTask.sendNewOrderMessageAsync(list);
    }


    @Test
    public void recieve() {
        List<NewOrderMessage> list = newOrderMassageTask.receiveNewOrderMessage(9527);
        list.forEach(one->{
            System.err.println(one.getFrom());
            System.err.println(one.getTo());
        });
    }
}
