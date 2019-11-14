package cn.cnm.test;

import cn.cnm.mapper.AirportMapper;
import cn.cnm.pojo.Airport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/12 21:40
 */
public class GenerationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        AirportMapper airportMapper = applicationContext.getBean("airportMapper", AirportMapper.class);
        Airport airport = airportMapper.selectById("1");
        System.out.println(airport);
    }
}
