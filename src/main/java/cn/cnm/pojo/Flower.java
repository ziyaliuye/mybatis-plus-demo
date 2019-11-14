package cn.cnm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/12 21:26
 */
@Data // get/set
@AllArgsConstructor // 全参构造
@NoArgsConstructor // 无参构造
@Accessors(chain = true) // 链式风格访问
/* 只需要让实体类继承 MyBatis Plus 提供好的 Model 类， 且实现主键指定方法即可开启AR模式 */
public class Flower extends Model<Flower> {
    /* IdType.AUTO：自增主键 */
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Float price;
    private String production;

    /* 实现主键指定方法 */
    @Override
    protected Serializable pkVal() {
        // 返回主键字段
        return this.id;
    }
}
