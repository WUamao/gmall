package com.amao.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.amao.gmall.constant.SysCacheConstant;
import com.amao.gmall.pms.entity.ProductCategory;
import com.amao.gmall.pms.mapper.ProductCategoryMapper;
import com.amao.gmall.pms.mapper.ProductMapper;
import com.amao.gmall.pms.service.ProductCategoryService;
import com.amao.gmall.vo.producct.PmsProductCategoryWithChildrenItem;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Slf4j
@Service
@Component
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    ProductCategoryMapper categoryMapper;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    /**
     * 分布式缓存用redis来做
     * @param i
     * @return
     */
    @Override
    public List<PmsProductCategoryWithChildrenItem> listCatelogWithChilder(int i) {
        List<PmsProductCategoryWithChildrenItem> items;

        Object cacheMenu = redisTemplate.opsForValue().get(SysCacheConstant.CATEGORY_MENU_CACHE_KEY);
        if (cacheMenu != null){
            log.debug("菜单数据命中缓存...");
            items = ( List<PmsProductCategoryWithChildrenItem>) cacheMenu;
        }else {
            items = categoryMapper.listCatelogWithChilder(i);
            redisTemplate.opsForValue().set(SysCacheConstant.CATEGORY_MENU_CACHE_KEY,items);
        }
        return items;
    }
}
