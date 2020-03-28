package com.amao.gmall.pms.service;

import com.amao.gmall.pms.entity.SkuStock;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 * sku的库存 服务类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
public interface SkuStockService extends IService<SkuStock> {

    BigDecimal getSkuPriceBySkuId(Long skuId);
}
