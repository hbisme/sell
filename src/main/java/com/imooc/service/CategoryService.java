package com.imooc.service;

import com.imooc.dataobject.ProductCategory;
import java.util.List;

// 类目的service层

public interface CategoryService {
//    根据id来查类目对象
    ProductCategory findOne(Integer categoryId);
//    查询所有的类目
    List<ProductCategory> findAll();
//    更加指定的类目队列返回对象队列
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
//    新增和更新类目
    ProductCategory save(ProductCategory productCategory);
}
