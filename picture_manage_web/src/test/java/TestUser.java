import com.qinguangfeng.dao.entity.User;
import com.qinguangfeng.web.Start;

import com.qinguangfeng.web.service.impl.TypeImpl;
import com.qinguangfeng.web.service.impl.UserImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by dengjicheng on 2016/10/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value = Start.class)

public class TestUser {

    @Autowired
    private UserImpl userImpl;


    /**
     * 测试查詢全部的方法
     */
    @Test
    public void findUserAll() {
        User user = new User();
        user.setPassword("asas");
        user.setUsername("asas");
        boolean a = userImpl.registerUser(user);

        System.out.println(a);
    }
}