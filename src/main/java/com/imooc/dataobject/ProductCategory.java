package com.imooc.dataobject;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**类目 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class ProductCategory {
//    类目id
    @Id
    @GeneratedValue
    private Integer categoryId;
//    类目名字
    private String categoryName;
//    类目编号
    private Integer categoryType;
////    创建时间
//    private Date createTime;
////    修改时间
//    private Date updateTime;


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
