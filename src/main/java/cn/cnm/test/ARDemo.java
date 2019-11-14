package cn.cnm.test;

import cn.cnm.pojo.Flower;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author lele
 * @version 1.0
 * @Description ActiveRecord（活动记录）-- AR模式操作， 以实体类的实例为操作对象
 * 本质就是一个语法糖， 内部还是调用的基本的CRUD
 * @Email 414955507@qq.com
 * @date 2019/11/13 21:37
 */
public class ARDemo {
    public static void main(String[] args) {
        // 加载Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        System.out.println(applicationContext);
        Flower flower = new Flower(10, "含羞草", 88.8F, "母鸡呀");
        // AR模式插入
        flower.insert();
        flower.setName("不害羞草");
        // AR模式更新, 根据id更新
        flower.updateById();

        // AR模式查询, 根据id查询
        System.out.println(flower.selectById());
        // AR模式查询, 查询所有记录
        System.out.println(flower.selectAll());
        // AR模式查询, 带条件查询
        List<Flower> list = flower.selectList(new QueryWrapper<Flower>().like("name", "草"));
        System.out.println("查询数据：" + list);
        // AR模式查询, 带条件查询, 查询条数
        Integer count = flower.selectCount(new QueryWrapper<Flower>().like("name", "草"));
        System.out.println("查询条数：" + count);

        // AR模式删除, 根据主键ID删除, 返回的是否删除成功boolean值（注意，是判断SQL是否正确执行，删除0条也返回true）
        flower.deleteById();
        // AR模式删除, 根据条件进行删除, 返回的是否删除成功boolean值（注意，是判断SQL是否正确执行，删除0条也返回true）
        flower.delete(new QueryWrapper<Flower>().like("name", "葵花"));

        /* AR分页操作 */
        System.out.println("=====");
        flower.selectPage(new Page<>(2, 1), new QueryWrapper<Flower>().like("name", "草"))
                .getRecords().forEach(System.out::println);
    }
}
