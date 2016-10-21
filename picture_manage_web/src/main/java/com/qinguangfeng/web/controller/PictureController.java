package com.qinguangfeng.web.controller;

import com.fc.platform.commons.page.Page;
import com.qinguangfeng.dao.entity.Picdetail;
import com.qinguangfeng.dao.entity.Picture;
import com.qinguangfeng.dao.entity.Pictype;
import com.qinguangfeng.dao.entity.User;
import com.qinguangfeng.dao.vo.PictureVo;
import com.qinguangfeng.web.service.impl.DetailImpl;
import com.qinguangfeng.web.service.impl.PictureImpl;

import com.qinguangfeng.web.service.impl.TypeImpl;
import com.qinguangfeng.web.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengjicheng on 2016/10/8.
 */
@Controller
//@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureImpl pictureImpl;
    @Autowired
    private DetailImpl detailImpl;
    @Autowired
    private TypeImpl typeImpl;
    @Autowired
    private UserImpl userImpl;

    /**
     * 测试能不能把JSon数据发到 页面上
     *
     * @return
     */
    @RequestMapping("/picall")
    @ResponseBody
    public java.lang.Object getPicAll() {
        return pictureImpl.findAll();

    }

    /**
     * 查询图片信息表的全部内容，即首页
     */

    @RequestMapping("/piclist")

    public String getPicList(@RequestParam(name = "page", defaultValue = "0") Integer page, ModelMap modelMap, HttpSession session) {
        //表单验证，防止直接访问该页面
        Object name = session.getAttribute("user");
        if (name == null) {
            return "redirect:/denglu.html";
        }

        //分页，如果页数小于0,则进入条件,这是判断最小的，上一页的
        if (page < 0) {
            page = 0;
        }
        //分页，每个页面展示两条数据

      /*  List<Picture> pageList=pictureImpl.findAll();*/
        List<Picture> pageList = pictureImpl.findAllThree();


        //得到总页数
        int pageTotal = 0;
        if (pageList != null) {
            if (pageList.size() % 2 == 0) {
                pageTotal = pageList.size() / 2;
            } else {
                pageTotal = pageList.size() / 2 + 1;
            }
        }
        //分页，如果页数大于总页数,则进入条件,这是判断最大的，解决一直下一页出现的问题，-1是因为默认是从0开始算起的
        if (page > pageTotal - 1) {
            page = pageTotal - 1;
        }
        Page<Picture> pplist = pictureImpl.findPage(page, 2);
        modelMap.put("pplist", pplist);
        modelMap.put("currpage", page);


        List<Pictype> tylist = typeImpl.findTypeAll();
        modelMap.put("tylist", tylist);
        List<Picture> list = pictureImpl.findAll();
        modelMap.put("list", list);

        return "shouye";

    }

    /**
     * 图片信息表的增加方法1，返回Json字符串
     * 图片信息表的增加方法1，返回Json字符串
     */
    @RequestMapping("/picadd")
    @ResponseBody
    public boolean getPicAdd(Picture picture) {
        boolean boo = pictureImpl.addPic(picture);
        return boo;
    }

    /**
     * 曾超写的，存到Seesion里
     * @param session
     * @param picurl 如果属性和 变量名一致的话，比如String picurl，那就没必要再加上@Paragram("picurl")
     * @return
     */
    @RequestMapping("/pictureadd")
    @ResponseBody
        public boolean pictureadd(HttpSession session,String picurl) {

   List<String> pictureList = (List<String>) session.getAttribute("pictureList");

        if (pictureList == null) {
            pictureList = new ArrayList<String>();
        }
        pictureList.add(picurl);
        if(!"".equals(picurl)){
            session.setAttribute("pictureList", pictureList);
            return true;
        }
        return false;
    }

    /**
     * 图片信息表的增加的方法2，跳转页面
     */
    @RequestMapping("/topicadd")

    public String toAddPage(Picture picture, ModelMap modelMap, HttpSession session) {
        //表单验证，防止直接访问该页面
        Object name = session.getAttribute("user");
        if (name == null) {
            return "redirect:/denglu.html";
        }
        //套图详情表的查询全部，根据逻辑增加的条件查询，并存起来？？？这里恐怕要改一下！！
        List<Picdetail> addlist = detailImpl.findLogic();

        modelMap.put("addlist", addlist);


//图片信息表的查询全部
        List<Picture> plist = pictureImpl.findAll();
        modelMap.put("plist", plist);
//图片类型表的查询全部
        List<Pictype> plis = typeImpl.findTypeAll();
        modelMap.put("plis", plis);
        return "add";

    }


    /**
     * 根据ID删除图片信息表的方法
     */

    @RequestMapping("/deletepic")
    @ResponseBody
    public int deletePic(@RequestParam("picid") Integer picid) {
        try {
            int num = pictureImpl.delePic(picid);
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    /**
     * 图片信息表的编辑的方法，第一步
     * 根据图片的ID来查询详细的信息
     */
    @RequestMapping("/editpic")
    public String editPic(@RequestParam("picid") Integer picid, ModelMap modelMap, HttpSession session) {
        //表单验证，防止直接访问该页面
        Object name = session.getAttribute("user");
        if (name == null) {
            return "redirect:/denglu.html";
        }
        //根据ID查询 图片信息表全部，并存起来
        Picture pic = pictureImpl.findPicAll(picid);
        modelMap.put("pic", pic);
        //图片信息表直接查询 全部信息，并存起来
        List<Picture> plist = pictureImpl.findAll();
        modelMap.put("plist", plist);

        //图片类型表的查询全部
        List<Pictype> plis = typeImpl.findTypeAll();
        modelMap.put("plis", plis);

        //套图详情表的查询全部
        List<Picdetail> tlist = detailImpl.findDetailAll();
        modelMap.put("tlist", tlist);

        //为去除编辑页面的套图介绍的重复
      /*  Picdetail delist = detailImpl.serchDetailAll(detailid);
        modelMap.put("delist", delist);*/

        return "edit";
    }

    /**
     * 根据detailid来查询单个图片的内容，并且返回给edit.jsp页面
     */
    @RequestMapping("/editpicdetail")
    public String editPicDetail(@RequestParam("detailid") Integer detailid, ModelMap modelMap, HttpSession session) {

        //这里恐怕也得改！！
        Picdetail delist = detailImpl.serchDetailAll(detailid);
        modelMap.put("delist", delist);

        return "edit";
    }


    /**
     * 图片信息表的编辑的方法，第二步
     * 执行编辑 的功能
     */
    @RequestMapping("/doeditpic")
    @ResponseBody
    public int doEditPic(Picture picture) {
        try {
            int num = pictureImpl.editPic(picture);
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 登录验证的方法
     */
    @RequestMapping("/login")
    public String toLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpSession session) {

        User user = userImpl.findUserAll(username, password);
        if (user != null) {
            //存到session中

            session.setAttribute("user", user);
            /**
             * 这里重定向的不是 shouye的页面哦！
             */
            return "redirect:/piclist";
        } else {
            return "redirect:/denglu.html";
        }

    }


    /**
     * 注册的方法
     */
    @RequestMapping("/toregister")
    public String registerUs(@RequestParam(name = "registername") String registername, @RequestParam(name = "registerpwd") String registerpwd, User user) {
        user = new User();
        user.setUsername(registername);
        user.setPassword(registerpwd);
        boolean data = userImpl.registerUser(user);

        if (data == true) {

            return "redirect:/denglu.html";
        } else {
            return "redirect:/index.jsp";
        }

    }

    /**
     * 套图详情表的增加方法1，返回Json字符串
     */
    @RequestMapping("/detailadd")
    @ResponseBody
    public boolean detailAdd(Picdetail picdetail) {
        boolean boo = detailImpl.addDetail(picdetail);
        return boo;
    }

    @RequestMapping("/testadd")
    public String testAdd(ModelMap modelMap, @RequestParam("picurl") String picurl, @RequestParam("pictitle") String pictitle, @RequestParam("picdesc") String picdesc, @RequestParam("picid") Integer picid) {
        modelMap.put("picurl", picurl);
        modelMap.put("pictitle", pictitle);
        modelMap.put("picdesc", picdesc);
        modelMap.put("picid", picid);
        return "add";
    }


    /**
     * 套图详情表的增加的方法2，跳转页面
     */
    @RequestMapping("/todetailadd")

    public String toDetailAdd(Picdetail picdetail, ModelMap modelMap, HttpSession session) {
        //表单验证
        Object name = session.getAttribute("user");
        if (name == null) {
            return "redirect:/denglu.html";
        }
        //图片信息表直接查询 全部信息，并存起来
        List<Picture> plist = pictureImpl.findAll();
        modelMap.put("plist", plist);

        List<Picdetail> ttlist = detailImpl.findDetailAll();//这里恐怕要改一下！！！！
        modelMap.put("ttlist", ttlist);
        List<Picture> list = pictureImpl.findAll();
        modelMap.put("list", list);
        return "addpic";

    }

    /**
     * 套图详情表删除的方法
     */

    @RequestMapping("/deletedeta")
    @ResponseBody//不要忘记要加这个注解了，只要不是字符串都要加这个注解
    public int deleteDeta(@RequestParam("detailid") Integer detailid) {
        try {
            int num = detailImpl.deleDetail(detailid);
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    /**
     * 套图详情表的编辑的方法1
     * 根据图片的ID来查询套图的详细信息
     */
    @RequestMapping("/editdetail")
    public String editDetail(@RequestParam("detailid") Integer detailid, ModelMap modelMap, HttpSession session) {
        //表单验证
        Object name = session.getAttribute("user");
        if (name == null) {
            return "redirect:/denglu.html";
        }


        //这里恐怕也得改！！
        Picdetail delist = detailImpl.serchDetailAll(detailid);
        modelMap.put("delist", delist);

        List<Picdetail> ttlist = detailImpl.findDetailAll();
        modelMap.put("ttlist", ttlist);

        List<Picture> plist = pictureImpl.findAll();
        modelMap.put("plist", plist);

        return "detailedit";
    }


    /**
     * 杰哥写的！！！！
     * 套图详情表的编辑的方法1
     * 根据图片的ID来查询套图的详细信息，
     * <p/>
     * 最好是把，不同的controller分开来写！
     * 还有  学会 不仅仅只有页面跳转的方式而已，还有用回调函数的方式来获取数据！
     * <p/>
     * 要像杰哥那样 写思路！然后按照思路来，一步一步用所学的知识解决。
     */
    @RequestMapping("/picedetail_edit")
    @ResponseBody
    public Object picedetail_edit(@RequestParam("detailid") Integer detailid, HttpSession session) {
        //表单验证
        Object name = session.getAttribute("user");
        if (name == null) {
            return "{result:error}";
        }
     /*   throw new RuntimeException();*/
        //通过图片ID获取图片详情的方法
        return detailImpl.serchDetailAll(detailid);

    }

    /**
     * 套图详情表的编辑的方法2，执行编辑
     * 执行编辑 的功能
     */
    @RequestMapping("/doeditdeta")
    @ResponseBody
    public int doEditDeta(Picdetail picdetail) {
        try {
            int num = detailImpl.editDetail(picdetail);
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
