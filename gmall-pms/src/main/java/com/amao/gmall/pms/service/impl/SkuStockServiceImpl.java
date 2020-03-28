package com.amao.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.amao.gmall.pms.entity.SkuStock;
import com.amao.gmall.pms.mapper.SkuStockMapper;
import com.amao.gmall.pms.service.SkuStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**
 * <p>
 * sku的库存 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
@Component
public class SkuStockServiceImpl extends ServiceImpl<SkuStockMapper, SkuStock> implements SkuStockService {

}
