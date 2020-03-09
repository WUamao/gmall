package com.amao.gmall.oms.service.impl;

import com.amao.gmall.oms.entity.CartItem;
import com.amao.gmall.oms.mapper.CartItemMapper;
import com.amao.gmall.oms.service.CartItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {

}
