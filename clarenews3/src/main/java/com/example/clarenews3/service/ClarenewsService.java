package com.example.clarenews3.service;

import com.example.clarenews3.api.Article;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClarenewsService {

    public List<Article> callEditorialsForArticles() {
        List<Article> articleList = new ArrayList<>();
        List<Article> sportList = callSportService();

        //Sport
        articleList.addAll(sportList);

        //Inrikes
        Article article = new Article();
        article.setRubrik("Ska det åttonde försöket att bilda regering lyckas?");
        article.setBrodText("I eftermiddag kommer Kalle Anka att lägga fram sitt regeringsförslag. Talmannen tror att hen har goda chanser efter de hittils misslyckade försöken...");
        articleList.add(article);

        //Utrikes
        Article article2 = new Article();
        article2.setRubrik("Trump vägrade dricksa Silvios Berlusconi's son");
        article2.setBrodText("Trump fick ytterligare ett sammanbrott på torsdagkvällen...");
        articleList.add(article2);

        return articleList;
    }




    private List<Article> callSportService() {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8081/sport";
        ResponseEntity<List<Article>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Article>>() {});

        return responseEntity.getBody();
    }
}
