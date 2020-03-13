package com.amao.gmall.pms.service;

import com.amao.gmall.pms.entity.ProductCategory;
import com.amao.gmall.vo.producct.PmsProductCategoryWithChildrenItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    List<PmsProductCategoryWithChildrenItem> listCatelogWithChilder(int i);
}
