package com.amao.gmall.pms.mapper;

import com.amao.gmall.pms.entity.ProductAttribute;
import com.amao.gmall.pms.entity.ProductAttributeValue;
import com.amao.gmall.to.es.EsProductAttributeValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 存储产品参数信息的表 Mapper 接口
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
public interface ProductAttributeValueMapper extends BaseMapper<ProductAttributeValue> {

    List<ProductAttribute> selectProductSaleAttrName(Long id);

    List<EsProductAttributeValue> selectProductBaseAttrAndValue(Long id);
}
