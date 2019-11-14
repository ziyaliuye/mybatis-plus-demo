package cn.cnm.service.impl;

import cn.cnm.pojo.Flower;
import cn.cnm.mapper.FlowerMapper;
import cn.cnm.service.FlowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lele
 * @since 2019-11-14
 */
@Service
public class FlowerServiceImpl extends ServiceImpl<FlowerMapper, Flower> implements FlowerService {

}
