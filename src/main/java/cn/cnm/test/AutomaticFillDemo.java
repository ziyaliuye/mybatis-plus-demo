package cn.cnm.test;

import cn.cnm.mapper.StaffMapper;
import cn.cnm.pojo.Staff;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lele
 * @version 1.0
 * @Description 公共字段自动填充测试， 测试name字段在insert和update操作为空时自动填充默认值
 * @Email 414955507@qq.com
 * @date 2019/11/12 21:40
 */
public class AutomaticFillDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        StaffMapper staffMapper = applicationContext.getBean("staffMapper", StaffMapper.class);
        Staff staff = new Staff(6, null, 0);
        // 插入
        staffMapper.insert(staff);
        staff.setName(null);
        // 更新
        staffMapper.updateById(staff);
    }
}
