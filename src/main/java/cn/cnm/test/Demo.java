package cn.cnm.test;

import cn.cnm.mapper.FlowerMapper;
import cn.cnm.pojo.Flower;
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
    }
}
