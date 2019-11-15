package cn.cnm.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author lele
 * @version 1.0
 * @Description 更新所有记录操作
 * @Email 414955507@qq.com
 * @date 2019/11/15 22:41
 */
public class UpdateAll extends AbstractMethod {
    // 拓展该方法完成自定义操作
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        // 注入的SQL语句
        String sql = "update " + tableInfo.getTableName() + " set price = price + 10000";
        // 注入的方法名（值必须和baseMapper的自定义方法名一致）
        String method = "updateAll";
        // 构造SqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        // 构造一个删除的MappedStatement对象
        this.addUpdateMappedStatement(mapperClass, modelClass, method, sqlSource);

        return addUpdateMappedStatement(mapperClass, modelClass, method, sqlSource);
    }
}

