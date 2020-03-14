package com.amao.gmall.pms.service;

import com.amao.gmall.pms.entity.ProductAttributeCategory;
import com.amao.gmall.vo.PageInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
public interface ProductAttributeCategoryService extends IService<ProductAttributeCategory> {

    PageInfoVo productAttributeCategoryPageInfo(Integer pageNum, Integer pageSize);
}
