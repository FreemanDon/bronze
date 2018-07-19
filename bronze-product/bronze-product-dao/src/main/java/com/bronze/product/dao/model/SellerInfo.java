package com.bronze.product.dao.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class SellerInfo {
  @Id
  private String id;

  /*用户名称*/
  private String username;

  /*密码*/
  private String password;

  /*微信openid*/
  private String openid;

  /*生成日期*/
  private Date createTime;

  /*修改日期*/
  private Date updateTime;
}
