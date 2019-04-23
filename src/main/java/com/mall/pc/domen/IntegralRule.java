package com.mall.pc.domen;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-23 14:08
 **/

public class IntegralRule implements Serializable {

    /**
     *积分数
     */
    private Integer integral;

    /**
     *抵扣金额
     */
    private BigDecimal deduction;

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public BigDecimal getDeduction() {
        return deduction;
    }

    public void setDeduction(BigDecimal deduction) {
        this.deduction = deduction;
    }
}

