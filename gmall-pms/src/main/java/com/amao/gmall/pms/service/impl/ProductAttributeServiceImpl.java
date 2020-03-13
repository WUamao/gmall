package com.amao.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.amao.gmall.pms.entity.ProductAttribute;
import com.amao.gmall.pms.mapper.ProductAttributeMapper;
import com.amao.gmall.pms.service.ProductAttributeService;
import com.amao.gmall.vo.PageInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
@Component
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements ProductAttributeService {

    @Autowired
    ProductAttributeMapper productAttributeMapper;

    @Override
    public PageInfoVo getCategoryAttributes(Long cid, Integer pageSize, Integer pageNum) {

        Page<ProductAttribute> page = new Page<>(pageNum, pageSize);
        QueryWrapper<ProductAttribute> wrapper = new QueryWrapper<ProductAttribute>().eq("cid", cid);
        IPage<ProductAttribute> selectPage = productAttributeMapper.selectPage(page, wrapper);
        PageInfoVo pageInfoVo =  PageInfoVo.getVo(selectPage, pageNum.longValue());
        return pageInfoVo;
    }
}
