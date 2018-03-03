package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CarDTO;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findById(String id) {
        return productInfoRepository.findOne(id);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public List<ProductInfo> findByProductStatus(Integer status) {
        return productInfoRepository.findByProductStatus(status);
    }

    @Override
    @Transactional
    public void increaseStock(List<CarDTO> carDTOList) {
        for(CarDTO carDTO: carDTOList){
            ProductInfo productInfo = productInfoRepository.findOne(carDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            Integer result = productInfo.getProductStock() + carDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CarDTO> carDTOList) {
        for(CarDTO carDTO: carDTOList){
            ProductInfo productInfo = productInfoRepository.findOne(carDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }else if (productInfo.getProductStock() >= carDTO.getProductQuantity()){

                productInfo.setProductStock(productInfo.getProductStock() - carDTO.getProductQuantity());
                productInfoRepository.save(productInfo);
            }else {
                throw new SellException(ResultEnum.PRODUCT_STOCK_NOT_ENOUGH);
            }

        }
    }
}
