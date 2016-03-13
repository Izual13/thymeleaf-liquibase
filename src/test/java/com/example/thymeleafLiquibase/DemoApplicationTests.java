package com.example.thymeleafLiquibase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    FilesDAO filesDAO;


    @Test
    public void test() {
        byte[] bytes = {1, 2, 3};
        String test = filesDAO.save(new FileDTO("test", bytes));
        System.out.println(test);
        byte[] byId = filesDAO.findById(test);
        Assert.assertArrayEquals(bytes, byId);
        System.out.println(Arrays.toString(byId));

    }
}
