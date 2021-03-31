package nsuproject.diseasenotification.worldnews;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WorldNewsService {

    @Autowired
    private final WorldNewsRepository repository;

    public void insertNews(String url) {

        try {
            Document doc = Jsoup.connect(url).get();

            Elements elements = doc.select(".sf-list-vertical__item");

            for(Element el : elements) {
                System.out.println(el.select("h4").text());
                System.out.println(el.select("a").attr("href"));

                WorldNews worldNews = WorldNews.builder()
                        .title(el.select("h4").text())
                        .url(el.select("a").attr("href"))
                        .build();

                repository.save(worldNews);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
