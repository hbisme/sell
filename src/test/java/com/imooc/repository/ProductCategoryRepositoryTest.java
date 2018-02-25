package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

//    测试根据id查询出对象
    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

//    测试修改增加对象
    @Test
    @Transactional  // 这个注解在这里会将测试修改数据库的内容删除
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女人最爱",5);
        ProductCategory result =repository.save(productCategory);
        Assert.assertNotNull(result);
    }

//    @Test
////    public void saveTest2(){
////        ProductCategory productCategory = repository.findOne(2);
//////        productCategory.setCategoryId(2);
////        productCategory.setCategoryName("男生最爱");
////        productCategory.setCategoryType(4);
////        repository.save(productCategory);
////    }

    @Test
    @Transactional
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());

    }


}