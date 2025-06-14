package com.example.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName yz_user
 */
@TableName("yz_user")
@Data
public class YzUser implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    private Date ct;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String passwd;

    /**
     *
     */
    private Integer sortnum;

    /**
     *
     */
    private Integer status;

    /**
     *
     */
    private Integer err;

    private static final long serialVersionUID = 1L;
}