package com.wh.xyxwhl.web.service;

public interface IBaseService<T> {
	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_area
     *
     * @mbggenerated Mon Jul 30 17:10:15 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_area
     *
     * @mbggenerated Mon Jul 30 17:10:15 CST 2018
     */
    int insert(T t);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_area
     *
     * @mbggenerated Mon Jul 30 17:10:15 CST 2018
     */
    int insertSelective(T t);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_area
     *
     * @mbggenerated Mon Jul 30 17:10:15 CST 2018
     */
    T selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_area
     *
     * @mbggenerated Mon Jul 30 17:10:15 CST 2018
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_area
     *
     * @mbggenerated Mon Jul 30 17:10:15 CST 2018
     */
    int updateByPrimaryKey(T t);

}