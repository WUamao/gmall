package com.amao.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.amao.gmall.pms.entity.Brand;
import com.amao.gmall.pms.mapper.BrandMapper;
import com.amao.gmall.pms.service.BrandService;
import com.amao.gmall.vo.PageInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Component
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageInfoVo brandPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        QueryWrapper<Brand> name = null;
        //自动拼%
        if (!StringUtils.isEmpty(keyword))
            name = new QueryWrapper<Brand>().like("name",keyword);

        IPage<Brand> brandIPage = brandMapper.selectPage(new Page<Brand>(pageNum.longValue(), pageSize.longValue()), name);

        PageInfoVo pageInfoVo = new PageInfoVo(brandIPage.getTotal(),
                brandIPage.getPages(),pageSize.longValue(),brandIPage.getRecords(),
                brandIPage.getCurrent());

        return pageInfoVo;
    }
}
