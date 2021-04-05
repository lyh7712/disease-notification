package nsuproject.diseasenotification.worldnews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorldNewsController {

    @Autowired
    private WorldNewsService service;


    @GetMapping("/world/news")
    public List<WorldNews> findAllNews() {
        String url = "https://www.who.int/emergencies/disease-outbreak-news";

        service.insertNews(url);

        return service.findAllData();
    }

}
