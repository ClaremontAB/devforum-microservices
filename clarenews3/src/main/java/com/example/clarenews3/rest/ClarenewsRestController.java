package com.example.clarenews3.rest;

import com.example.clarenews3.api.Article;
import com.example.clarenews3.service.ClarenewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClarenewsRestController {
    @Autowired
    ClarenewsService clarenewsService;


    @RequestMapping(value = "/clarenews", method = RequestMethod.GET)
    public ResponseEntity<List<Article>> getArticlesFromAllEditorials() {
        List<Article> articleList = clarenewsService.callEditorialsForArticles();

        return ResponseEntity.ok(articleList);
    }
}
