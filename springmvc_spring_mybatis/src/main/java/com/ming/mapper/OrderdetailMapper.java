package com.ming.mapper;

import com.ming.po.Orderdetail;
import com.ming.po.OrderdetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderdetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    long countByExample(OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    int deleteByExample(OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    int insert(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    int insertSelective(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    List<Orderdetail> selectByExample(OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    Orderdetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Orderdetail record);
}