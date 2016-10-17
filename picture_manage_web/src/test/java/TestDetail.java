import com.qinguangfeng.dao.entity.Picdetail;
import com.qinguangfeng.web.Start;

import com.qinguangfeng.web.service.impl.DetailImpl;
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
public class TestDetail {
    @Autowired
    private DetailImpl detailImpl;

    /**
     * 测试查詢全部的方法
     */
    @Test
    public void findDetailAll() {

        List<Picdetail> list = detailImpl.findDetailAll();

        for (Picdetail p : list) {
            System.out.println(p);
        }
    }

    /**
     * 测试详表 增加方法
     */
    @Test
    public void addDetail() {
        Picdetail p = new Picdetail();

        p.setPicdesc("asdas");
        p.setPictitle("asdas");
        p.setPicurl("dasdasd");


        detailImpl.addDetail(p);


    }


    /**
     * 测试查詢全部的方法
     */
    @Test
    public void findAddPicdetail() {

        List<Picdetail> list = detailImpl.findAddPicdetail();

        for (Picdetail p : list) {
            System.out.println(p);
        }
    }

    /**
     * 测测能不能只从addlogic这个条件查东西的
     */

    @Test
    public void findDetaByLogic() {
        List<Picdetail> list = detailImpl.findLogic();
        for (Picdetail p : list) {
            System.out.println(p);

        }

    }

    /**
     * 测试删除的方法
     */
    @Test
    public void deleDetail() {

        int num = detailImpl.deleDetail(22);
        System.out.println(num);


    }

    /**
     * 测试根据ID查询的方法
     */
    @Test
    public void serchDetailAllById() {

        Picdetail picdetail = detailImpl.serchDetailAll(1);
        System.out.println(picdetail);
    }

}
