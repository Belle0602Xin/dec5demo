package com.example.dec5demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    // 用来调外部接口
    private final RestTemplate restTemplate = new RestTemplate();

    // 外部接口的基础 URL
    private static final String BASE_URL =
            "https://jsonmock.hackerrank.com/api/article_users";

    // 根据 page 参数去请求外部接口 比如 https://jsonmock.hackerrank.com/api/article_users?page=2
    private ArticleUserResponse fetchPage(int page) {
        String url = BASE_URL + "?page=" + page;
        return restTemplate.getForObject(url, ArticleUserResponse.class);
    }

    // GET /users?page=c 只拿指定页的数据
    @GetMapping(params = "page")
    public List<ArticleUser> getUsersByPage(@RequestParam("page") int page) {

        // 页码小于 1 就返回空
        if (page < 1) {
            return Collections.emptyList();
        }

        ArticleUserResponse response = fetchPage(page);

        if (response == null || response.getData() == null) {
            return Collections.emptyList();
        }

        return response.getData();
    }

    // GET /users 不带 page 参数，拿所有页的数据
    @GetMapping
    public List<ArticleUser> getAllUsers() {

        List<ArticleUser> result = new ArrayList<>();

        // 先请求第 1 页
        ArticleUserResponse firstPage = fetchPage(1);

        if (firstPage == null || firstPage.getData() == null) {
            return result;
        }

        // 把第一页的数据加进去
        result.addAll(firstPage.getData());

        int totalPages = firstPage.getTotal_pages();

        // 再从第二页循环到最后一页
        for (int page = 2; page <= totalPages; page++) {
            ArticleUserResponse pageResp = fetchPage(page);
            if (pageResp != null && pageResp.getData() != null) {
                result.addAll(pageResp.getData());
            }
        }

        return result;
    }
}