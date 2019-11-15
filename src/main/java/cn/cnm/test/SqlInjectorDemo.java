package cn.cnm.test;

import cn.cnm.mapper.FlowerMapper;
import cn.cnm.pojo.Flower;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lele
 * @version 1.0
 * @Description 自定义自己的通用方法可以实现接口ISqlInjector也可以继承抽象类AbstractSqlInjector注入通用方法SQL语句
 * 然后继承 BaseMapper 添加自定义方法，全局配置sqlInjector注入MP会自动将类所有方法注入到mybatis容器中
 * @Email 414955507@qq.com
 * @date 2019/11/15 22:10
 */
public class SqlInjectorDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        FlowerMapper flowerMapper = applicationContext.getBean("flowerMapper", FlowerMapper.class);
        // 调用注入的SQL， 在Mybatis启动时便装入了容器中（无序在XML中写SQL）
        Integer row = flowerMapper.updateAll();
        System.out.println("更新了" + row + "行");
    }
}
