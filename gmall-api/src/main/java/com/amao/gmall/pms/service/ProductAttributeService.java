package com.amao.gmall.pms.service;

import com.amao.gmall.pms.entity.ProductAttribute;
import com.amao.gmall.vo.PageInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
public interface ProductAttributeService extends IService<ProductAttribute> {

    PageInfoVo getCategoryAttributes(Long cid,Integer type, Integer pageSize, Integer pageNum);
}
