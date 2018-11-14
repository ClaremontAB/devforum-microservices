package com.example.sport.rest;

import com.example.sport.api.SportArticle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SportRestController {

    @RequestMapping(value = "/sport", method = RequestMethod.GET)
    public ResponseEntity<List<SportArticle>> getSportArticles() {
        List<SportArticle> sportArticleList = new ArrayList<>();
        SportArticle sportArticle1 = new SportArticle();
        SportArticle sportArticle2 = new SportArticle();

        sportArticle1.setRubrik("Bajen vinner SM!");
        sportArticle1.setBrodText("Som alla förväntade sig, så vann Hammarby SM-guldet för sjätte året i rad...");

        sportArticleList.add(sportArticle1);

        sportArticle2.setRubrik("Claremont vann Företags-OS!");
        sportArticle2.setBrodText("Som väntat tog Claremont hem FOS efter att fullständigt krossat i alla friidrottsgrenar.");

        sportArticleList.add(sportArticle2);

        return ResponseEntity.ok(sportArticleList);
    }
}
