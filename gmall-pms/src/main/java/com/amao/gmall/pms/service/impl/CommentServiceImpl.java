package com.amao.gmall.pms.service.impl;

import com.amao.gmall.pms.entity.Comment;
import com.amao.gmall.pms.mapper.CommentMapper;
import com.amao.gmall.pms.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
