package com.amao.gmall.pms.service;

import com.amao.gmall.pms.entity.Product;
import com.amao.gmall.vo.PageInfoVo;
import com.amao.gmall.vo.producct.PmsProductParam;
import com.amao.gmall.vo.producct.PmsProductQueryParam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
public interface ProductService extends IService<Product> {

    PageInfoVo productPageInfo(PmsProductQueryParam productQueryParam);

    void saveProduct(PmsProductParam productParam);

    void updatePublishStatus(List<Long> ids, Integer publishStatus);

    Product productInfo(Long id);
}
