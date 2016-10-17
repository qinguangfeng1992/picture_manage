import com.qinguangfeng.dao.entity.Pictype;
import com.qinguangfeng.web.Start;
import com.qinguangfeng.web.service.TypeServ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by dengjicheng on 2016/10/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value = Start.class)
public class TestType {
    @Autowired

    private TypeServ TypeImpl;

    /**
     * 测试查詢全部的方法
     */
    @Test
    public void findTypeAll() {

        List<Pictype> list = TypeImpl.findTypeAll();

        for (Pictype p : list) {
            System.out.println(p);
        }
    }
}
