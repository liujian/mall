package com.mall.pc.domen;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-26 15:13
 **/

public class TaxRate implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     *国际邮编
     */
    private String zipcode;


    /**
     *国家名称
     */
    private String country;

    /**
     *区域名称
     */
    private String area;

    /**
     *税率
     */
    private BigDecimal taxrate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }
}

