package com.zzz.pms.pmssys.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Verifycode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 验证码类型
     */
    private Integer codeType;

    /**
     * 验证码
     */
    private String codeNumber;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 接收端(手机号码，邮箱)
     */
    private String receiver;


}
