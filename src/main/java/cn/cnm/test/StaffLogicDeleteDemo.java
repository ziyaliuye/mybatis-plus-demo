package cn.cnm.test;

import cn.cnm.mapper.StaffMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lele
 * @version 1.0
 * @Description 测试逻辑删除， 本质就是update， 将对应的逻辑删除字段置为删除状态
 * @Email 414955507@qq.com
 * @date 2019/11/12 21:40
 */
public class StaffLogicDeleteDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        StaffMapper staffMapper = applicationContext.getBean("staffMapper", StaffMapper.class);
        staffMapper.deleteById(1);
    }
}
