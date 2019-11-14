package cn.cnm.test;

import cn.cnm.mapper.FlowerMapper;
import cn.cnm.pojo.Flower;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.x.protobuf.MysqlxExpect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @author lele
 * @version 1.0
 * @Description MyBatisPlus分页查询
 * @Email 414955507@qq.com
 * @date 2019/11/13 21:37
 */
public class PageDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        FlowerMapper flowerMapper = applicationContext.getBean("flowerMapper", FlowerMapper.class);
        /* 分页查询 */
        // 定义一个分页查询类, 第一个参数是查询的页码， 第二个参数是多个条记录为一页
        Page<Flower> page = new Page<>(1, 2);
        IPage<Flower> iPage = flowerMapper.selectPage(page, null);
        // getRecords()就是返回对应的记录
        System.out.println(iPage.getRecords());

        /* selectPage()方法的第二个参数QueryWrapper（条件构造器），译为查询包装的意思， 它可以包装查询分页的条件 */
        // MyBatis plus2.X版本参数还可以是Condition， 和前者类似， 可以自由构建查询条件， 两者都继承自Wrapper， 使用差别不大
        QueryWrapper queryWrapper = new QueryWrapper();
        /* 拼接条件时， “且”的条件可以直接.出来， 而or条件需要调用orXxx的方法（注意条件Double和Float用and会有问题） */
        // 添加and条件， 第一个参数是字段， 后两个是between的范围
        queryWrapper.between("id", 1, 6);
        queryWrapper.eq("production", "中国");
        IPage<Flower> iPage2 = flowerMapper.selectPage(page, queryWrapper);
        // getRecords()就是返回对应的记录
        System.out.println(iPage2.getRecords());

        QueryWrapper<Flower> queryWrapper1 = new QueryWrapper();
        queryWrapper1.between("id", 1, 6);
        queryWrapper1.eq("production", "中国");
        List<Flower> list = flowerMapper.selectList(queryWrapper1);
        list.forEach(System.out::println);

        /* or()和like()条件， 其中or方法空参时表示条件都在一个括号内， like会自动加%% */
        QueryWrapper<Flower> queryWrapper2 = new QueryWrapper();
        queryWrapper2.eq("production", "中国");
        queryWrapper2.or();
        queryWrapper2.between("id", 1, 3);
        queryWrapper2.like("production", "全世界");
        List<Flower> list1 = flowerMapper.selectList(queryWrapper2);
        list1.forEach(System.out::println);

        QueryWrapper<Flower> queryWrapper3 = new QueryWrapper();
        queryWrapper3.eq("production", "中国");
        // or(boolean condition, Function<Param, Param> func)  表示嵌套， 将条件包裹到or中
        queryWrapper3.or(i -> i.between("id", 1, 3).ne("production", "全世界"));
        List<Flower> list2 = flowerMapper.selectList(queryWrapper3);
        list2.forEach(System.out::println);

        /* 同样update和delete操作可以使用条件构造器 */

        /* 条件构造器可以使用group by、order by等操作 */
        QueryWrapper<Flower> queryWrapper5 = new QueryWrapper();
        // 使用正序排列， 参数可以是单个String也可以是多个字符串
        queryWrapper5.orderByAsc("price", "id");
        List<Flower> list3 = flowerMapper.selectList(queryWrapper5);
        list3.forEach(System.out::println);

        // SQL拼接（要注意有SQL注入风险， 需谨慎使用）
        QueryWrapper<Flower> queryWrapper6 = new QueryWrapper();
        // 使用正序排列， 参数可以是单个String也可以是多个字符串
        queryWrapper6.last("order by id desc");
        List<Flower> list6 = flowerMapper.selectList(queryWrapper6);
        list6.forEach(System.out::println);
    }
}
