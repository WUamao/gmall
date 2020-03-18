package com.amao.gmall.search;

import com.amao.gmall.search.service.SearchProductService;
import com.amao.gmall.search.service.impl.SearchProductServiceImpl;
import com.amao.gmall.vo.search.SearchParam;
import com.amao.gmall.vo.search.SearchResponse;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallSearchApplicationTests {

    @Autowired
    SearchProductService searchProductService;

    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {

        SearchParam searchParam = new SearchParam();
        searchParam.setKeyword("手机");


        String[] brand = new String[]{"苹果"};
        searchParam.setBrand(brand);

        String[] cate = new String[]{"19","20"};
        searchParam.setCatelog3(cate);

        searchParam.setPriceFrom(5000);
        searchParam.setPriceTo(10000);

        String[] props = new String[]{"45:4.7","46:4G-3G"};
        searchParam.setProps(props);

        SearchResponse searchResponse = searchProductService.searchProduct(searchParam);
        System.out.println(searchResponse);

    }


    @Test
    public void contextLoads0() throws IOException {

        Search build = new Search.Builder("").addIndex("product").addType("info").build();
        SearchResult execute = jestClient.execute(build);
        System.out.println(execute.getTotal());
    }

    @Test
    public void testSearchSource(){
        SearchSourceBuilder builder = new SearchSourceBuilder();


        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchAllQuery());

        builder.query(boolQueryBuilder);

        String s = builder.toString();
        System.out.println(s);
    }

}
