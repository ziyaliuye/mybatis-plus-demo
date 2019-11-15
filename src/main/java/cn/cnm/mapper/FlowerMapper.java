package cn.cnm.mapper;

import cn.cnm.pojo.Flower;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/12 21:53
 */
public interface FlowerMapper extends BaseMapper<Flower> {
    // 定义自定义的CRUD方法
    int updateAll();
}
