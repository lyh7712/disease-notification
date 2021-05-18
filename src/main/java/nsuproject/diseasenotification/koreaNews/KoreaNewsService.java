package nsuproject.diseasenotification.koreaNews;

import lombok.RequiredArgsConstructor;
import nsuproject.diseasenotification.dto.KoreaNewsRequestDto;
import nsuproject.diseasenotification.koreaNews.KoreaNews;
import nsuproject.diseasenotification.koreaNews.KoreaNewsRepository;
import nsuproject.diseasenotification.koreadata.KoreaData;
import nsuproject.diseasenotification.worldnews.WorldNews;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KoreaNewsService {

    @Autowired
    private final KoreaNewsRepository repository;

    public void insertNews(String url) {

        try {

            Document doc = Jsoup.connect(url).get();

            Elements element = doc.select(".group_news");

            for (Element el : element.select(".news_area > a")) {

                KoreaNews koreaNews = KoreaNews.builder()
                        .title(el.text())
                        .url(el.attr("href"))
                        .count(0L)
                        .build();


                System.out.println(el.text());
                System.out.println(el.attr("href"));

                repository.save(koreaNews);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<KoreaNews> findAllNews() {
        return repository.findAll();
    }


    public void viewCountSet(Long id) {
        Optional<KoreaNews> koreaNews = repository.findById(id);

        koreaNews.ifPresent(selectNews -> {
                selectNews.setCount(2L);
                repository.save(selectNews);
    });

    }

}
