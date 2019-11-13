package cn.cnm.test;

import cn.cnm.mapper.FlowerMapper;
import cn.cnm.pojo.Flower;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/12 21:40
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        FlowerMapper flowerMapper = applicationContext.getBean("flowerMapper", FlowerMapper.class);
        Flower flower = flowerMapper.selectById("1");
        System.out.println(flower);

        Flower insertFlower = new Flower(6, "葵花", 99.9, "中国");
        flowerMapper.insert(insertFlower);

        /* 分页查询 */
        // 定义一个分页查询类, 第一个参数是查询的页码， 第二个参数是多个条记录为一页
        Page<Flower> userPage = new Page<>(3, 2);//参数一是当前页，参数二是每页个数
        IPage<Flower> iPage = flowerMapper.selectPage(userPage, null);
        // getRecords()就是返回对应的记录
        System.out.println(iPage.getRecords());
    }
}
