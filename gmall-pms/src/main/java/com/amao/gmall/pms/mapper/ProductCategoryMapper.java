package com.amao.gmall.pms.mapper;

import com.amao.gmall.pms.entity.ProductCategory;
import com.amao.gmall.vo.producct.PmsProductCategoryWithChildrenItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 产品分类 Mapper 接口
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    List<PmsProductCategoryWithChildrenItem> listCatelogWithChilder(int i);
}
