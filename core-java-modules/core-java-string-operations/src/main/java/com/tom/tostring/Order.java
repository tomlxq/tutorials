package com.tom.tostring;

import lombok.Getter;
import lombok.Setter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */
@Getter
@Setter
public class Order {

    private String orderId;
    private String desc;
    private long value;
    private String status;

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", desc=" + desc + ", value=" + value + "]";
    }
}
