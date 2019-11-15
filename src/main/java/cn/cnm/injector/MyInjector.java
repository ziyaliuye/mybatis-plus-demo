package cn.cnm.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lele
 * @version 1.0
 * @Description 自定义全局操作
 * @Email 414955507@qq.com
 * @date 2019/11/15 23:45
 */
public class MyInjector extends AbstractSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        return Stream.of(
                new UpdateAll()
        ).collect(Collectors.toList());
    }
}
