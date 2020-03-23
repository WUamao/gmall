package com.amao.gmall.shopportal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.amao.gmall.search.service.SearchProductService;
import com.amao.gmall.vo.search.SearchParam;
import com.amao.gmall.vo.search.SearchResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Map;

/**
 * 商品检索的controller
 * @author amao
 * @date 2020/3/18 19:32
 */
@CrossOrigin
@Api(tags = "检索功能")
@RestController
public class ProductSearchController {

    @Reference
    SearchProductService searchProductService;

    @GetMapping("/success")
    public Map success(HttpServletRequest request){
        Map<String, String[]> map = request.getParameterMap();
        return map;
    }

    @GetMapping("/fail")
    public Map fail(HttpServletRequest request){
        Map<String, String[]> map = request.getParameterMap();
        return map;
    }

    @ApiOperation("商品检索")
    @GetMapping("/search")
    public SearchResponse productSearchResponse(SearchParam searchParam){
        SearchResponse searchResponse = searchProductService.searchProduct(searchParam);
        return searchResponse;
    }

}
