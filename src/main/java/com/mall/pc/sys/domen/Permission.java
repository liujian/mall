package com.mall.pc.sys.domen;

import java.io.Serializable;

public class Permission implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.id
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.parent_id
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    private Integer parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.menu_name
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    private String menuName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.menu_url
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    private String menuUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.perm_code
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    private String permCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.sort
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    private Integer sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.type
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table permission
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.id
     *
     * @return the value of permission.id
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.id
     *
     * @param id the value for permission.id
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.parent_id
     *
     * @return the value of permission.parent_id
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.parent_id
     *
     * @param parentId the value for permission.parent_id
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.menu_name
     *
     * @return the value of permission.menu_name
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.menu_name
     *
     * @param menuName the value for permission.menu_name
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.menu_url
     *
     * @return the value of permission.menu_url
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.menu_url
     *
     * @param menuUrl the value for permission.menu_url
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.perm_code
     *
     * @return the value of permission.perm_code
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public String getPermCode() {
        return permCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.perm_code
     *
     * @param permCode the value for permission.perm_code
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public void setPermCode(String permCode) {
        this.permCode = permCode == null ? null : permCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.sort
     *
     * @return the value of permission.sort
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.sort
     *
     * @param sort the value for permission.sort
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.type
     *
     * @return the value of permission.type
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.type
     *
     * @param type the value for permission.type
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
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
        Permission other = (Permission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuUrl() == null ? other.getMenuUrl() == null : this.getMenuUrl().equals(other.getMenuUrl()))
            && (this.getPermCode() == null ? other.getPermCode() == null : this.getPermCode().equals(other.getPermCode()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbggenerated Thu Feb 21 14:50:19 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuUrl() == null) ? 0 : getMenuUrl().hashCode());
        result = prime * result + ((getPermCode() == null) ? 0 : getPermCode().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}
