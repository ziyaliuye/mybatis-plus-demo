package cn.cnm.test;

import cn.cnm.pojo.Flower;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lele
 * @version 1.0
 * @Description 乐观锁流程：当要更新一条记录的时候， 希望这条记录没有被别人更新， 就可以使用乐观锁
 * @Email 414955507@qq.com
 * @date 2019/11/15 22:10
 */
public class OptimisticLockDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        System.out.println(applicationContext);
        Flower flower = new Flower(1, "矮牵牛", 3F, "南美阿根廷", null);
        flower.updateById();
    }
}
