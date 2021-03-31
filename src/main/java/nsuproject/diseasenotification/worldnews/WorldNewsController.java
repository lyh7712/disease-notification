package nsuproject.diseasenotification.worldnews;

import nsuproject.diseasenotification.worlddata.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class WorldNewsController {

    @Autowired
    private WorldNewsService service;

    @GetMapping("/worldnews")
    public void getNews() {

        String url = "https://www.who.int/emergencies/disease-outbreak-news";

        service.insertNews(url);
    }
}
