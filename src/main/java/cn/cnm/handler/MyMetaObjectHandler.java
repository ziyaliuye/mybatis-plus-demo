package cn.cnm.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/16 14:45
 */
public class MyMetaObjectHandler implements MetaObjectHandler {
    // 插入操作时填充逻辑
    @Override
    public void insertFill(MetaObject metaObject) {
        // 获取需要被填充的字段值, 假设字段叫 name
        Object fieldValue = getFieldValByName("name", metaObject);
        // 如果值为空说明字段为空， 需要进行填充处理
        if (fieldValue == null) {
            // 对name字段进行填充
            setFieldValByName("name", "wocao", metaObject);
        }
    }

    // 更新操作时填充逻辑
    @Override
    public void updateFill(MetaObject metaObject) {
        // 获取需要被填充的字段值, 假设字段叫 name
        Object fieldValue = getFieldValByName("name", metaObject);
        // 如果值为空说明字段为空， 需要进行填充处理
        if (fieldValue == null) {
            // 对name字段进行填充
            setFieldValByName("name", "caodan", metaObject);
        }
    }
}
