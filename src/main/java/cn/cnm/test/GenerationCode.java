package cn.cnm.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author lele
 * @version 1.0
 * @Description 代码生成器主类
 * @Email 414955507@qq.com
 * @date 2019/11/14 21:22
 */
public class GenerationCode {
    public static void main(String[] args) {
        // 全局配置
        GlobalConfig config = new GlobalConfig();
        // 是否支持AR模式
        config.setActiveRecord(true)
                // 设置注释上的作者名
                .setAuthor("lele")
                //.setOutputDir("D:\\IDEA Space\\mybatis-plus-demo\\src\\main\\java") // 生成路径， 选择项目的java目录
                .setOutputDir("D:\\code")
                // 是否覆盖文件
                .setFileOverride(true)
                // 主键策略，自增
                .setIdType(IdType.AUTO)
                // 默认生成第一个字母带一个I， 这里设置将生成的service接口的名字的首字母是否为I去掉
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        // 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        // 设置数据库类型
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://192.168.58.128:3306/ssm?serverTimezone=UTC")
                .setUsername("root")
                .setPassword("root");

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //全局大写命名
        strategy.setCapitalMode(true);
        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 设置表名前缀
        strategy.setTablePrefix("tb_");
        // 生成的表， 多表用数组
        strategy.setInclude("airport");
        // 自定义继承的实体类类全称，带包名， 这里暂不需要
        // strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        // 是否为lombok模型
        strategy.setEntityLombokModel(true);
        // 生成<code>@RestController</code> 控制器
        strategy.setRestControllerStyle(true);

        // 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("cn.cnm")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("pojo")
                // .setModuleName("模块名")
                .setXml("mapper");

        // 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(strategy)
                .setPackageInfo(pkConfig);

        // 执行
        ag.execute();
    }
}
