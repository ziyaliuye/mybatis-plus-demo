package cn.cnm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
public class Flower {
    private Integer id;
    private String name;
    private Double price;
    private String production;
}
