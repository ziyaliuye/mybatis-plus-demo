package cn.cnm.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/16 13:37
 */
@Data // get/set
@AllArgsConstructor // 全参构造
@NoArgsConstructor // 无参构造
@Accessors(chain = true) // 链式风格访问
public class Staff {
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 公共字段自动填充注解, DEFAUL(默认不填充)、INSERT/UPDATE 插入/更新时填充、INSERT_UPDATE 插入和更新时填充
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String name;
    // 逻辑删除注解
    @TableLogic
    private Integer logic_flag;
}
