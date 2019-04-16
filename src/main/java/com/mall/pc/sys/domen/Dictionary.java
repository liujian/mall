package com.mall.pc.sys.domen;

import java.io.Serializable;

public class Dictionary implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dictionary.dict_code
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    private String dictCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dictionary.dict_key
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    private String dictKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dictionary.dict_value
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    private String dictValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dictionary.sort
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    private String sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dictionary.remark
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dictionary
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dictionary.dict_code
     *
     * @return the value of dictionary.dict_code
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dictionary.dict_code
     *
     * @param dictCode the value for dictionary.dict_code
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dictionary.dict_key
     *
     * @return the value of dictionary.dict_key
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public String getDictKey() {
        return dictKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dictionary.dict_key
     *
     * @param dictKey the value for dictionary.dict_key
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey == null ? null : dictKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dictionary.dict_value
     *
     * @return the value of dictionary.dict_value
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dictionary.dict_value
     *
     * @param dictValue the value for dictionary.dict_value
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dictionary.sort
     *
     * @return the value of dictionary.sort
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public String getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dictionary.sort
     *
     * @param sort the value for dictionary.sort
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dictionary.remark
     *
     * @return the value of dictionary.remark
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dictionary.remark
     *
     * @param remark the value for dictionary.remark
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Dictionary other = (Dictionary) that;
        return (this.getDictCode() == null ? other.getDictCode() == null : this.getDictCode().equals(other.getDictCode()))
            && (this.getDictKey() == null ? other.getDictKey() == null : this.getDictKey().equals(other.getDictKey()))
            && (this.getDictValue() == null ? other.getDictValue() == null : this.getDictValue().equals(other.getDictValue()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dictionary
     *
     * @mbggenerated Thu Mar 21 10:09:12 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDictCode() == null) ? 0 : getDictCode().hashCode());
        result = prime * result + ((getDictKey() == null) ? 0 : getDictKey().hashCode());
        result = prime * result + ((getDictValue() == null) ? 0 : getDictValue().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}