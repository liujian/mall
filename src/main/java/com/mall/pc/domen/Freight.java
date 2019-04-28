package com.mall.pc.domen;

import java.math.BigDecimal;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-28 10:20
 **/

public class Freight {

    /**
     *运费
     */
    private BigDecimal freight;

    /**
     *免运费金额
     */
    private BigDecimal freeship;

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getFreeship() {
        return freeship;
    }

    public void setFreeship(BigDecimal freeship) {
        this.freeship = freeship;
    }
}

