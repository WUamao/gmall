package com.amao.gmall.search.service;

import com.amao.gmall.vo.search.SearchParam;
import com.amao.gmall.vo.search.SearchResponse;

/**
 * @author amao
 * @date 2020/3/18 16:10
 */
public interface SearchProductService {
    SearchResponse searchProduct(SearchParam searchParam);
}
