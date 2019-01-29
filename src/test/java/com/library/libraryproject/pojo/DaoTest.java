package com.library.libraryproject.pojo;

import com.library.libraryproject.dao.OrderDao;
import com.library.libraryproject.entity.Order;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void findBySeatIdsTest(){
        List<Order> bySeatIds = orderDao.findBySeatIds(Lists.newArrayList("1", "2", "523", "123"));
        System.out.println(bySeatIds);
    }
}
