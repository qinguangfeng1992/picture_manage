import com.qinguangfeng.dao.entity.Picture;
import com.qinguangfeng.dao.vo.PictureVo;
import com.qinguangfeng.web.Start;
import com.qinguangfeng.web.service.impl.PictureImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by dengjicheng on 2016/10/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value = Start.class)
public class TestPic {
    @Autowired
    private PictureImpl pictureImpl;

    /**
     * 测试查詢全部的方法
     */
    @Test
    public void findPicAll() {

        List<Picture> list = pictureImpl.findAll();

        for (Picture p : list) {
            System.out.println(p);
        }
    }


    /**
     * 测试新增的方法
     */
/*    @Test
    public void inserPic() {
        PictureVo pictureVo = new PictureVo();
        pictureVo.setPicname("你好");
        pictureVo.setPictime("2016-5-4");
        pictureImpl.addPic(pictureVo);


    }*/

    /**
     * 测试删除的方法
     */
    @Test
    public void delePic() {

        int num = pictureImpl.delePic(5);
        System.out.println(num);


    }

    /**
     * 测试通过ID查找 全部信息的方法
     */
    @Test
    public void findPicAllById() {

        Picture picture = pictureImpl.findPicAll(2);
        System.out.println(picture);

    }

    /**
     * 测试修改的方法
     */
    @Test
    public void editPic() {
        Picture picture = new Picture();
        picture.setPicid(6);
        picture.setTypeid(2);
        int num = pictureImpl.editPic(picture);
        System.out.println(num);

    }

    /**
     * 测试逻辑删除的方法
     */
    @Test
    public void delePicByLogic() {

        int num = pictureImpl.delePic(7);
        System.out.println(num);

    }


}
