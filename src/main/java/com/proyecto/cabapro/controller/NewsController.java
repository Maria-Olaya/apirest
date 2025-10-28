package com.proyecto.cabapro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.cabapro.model.NewsArticle;
import com.proyecto.cabapro.service.NewsDataService;

@RestController
public class NewsController {

    private final NewsDataService newsDataService;

    public NewsController(NewsDataService newsDataService) {
        this.newsDataService = newsDataService;
    }

    @GetMapping("/nba-news")
    public List<NewsArticle> fetchNBAnews() {
        return newsDataService.getBasketballNews();
    }
}
