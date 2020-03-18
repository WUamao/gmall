package com.amao.elasticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchDemoApplicationTests {

    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {
        System.out.println(jestClient);
    }

    @Test
    public void index() throws IOException {

        //Update  Delete Search Index
        //1、Action action = new Crud.Builder(携带的数据).其他信息.build();
        //2、DocumentResult execute = jestClient.execute(action);
        //3、获取结果DocumentResult数据即可

        User user = new User();
        user.setEmail("122333");user.setUserName("阿毛");


        Index index = new Index.Builder(user)
                .index("user")
                .type("info")
                .build();

        DocumentResult execute = jestClient.execute(index);

        System.out.println("执行？"+execute.getId()+"==>"+execute.isSucceeded());
    }

    @Test
    public void query() throws IOException {

        //Update  Delete Search Index
        //1、Action action = new Crud.Builder(携带的数据).其他信息.build();
        //2、DocumentResult execute = jestClient.execute(action);
        //3、获取结果DocumentResult数据即可

        Search search = new Search.Builder("").addIndex("user")
                .build();
        SearchResult execute = jestClient.execute(search);

        System.out.println("总记录数：" + execute.getTotal()
            +" ==> "+ execute.getMaxScore());
        System.out.println("查询到的数据");
        List<SearchResult.Hit<User, Void>> list = execute.getHits(User.class);
        list.forEach((hit)->{
            User user  = hit.source;
            System.out.println(user.getUserName());
        });


    }
}


class User{
    private String userName;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
