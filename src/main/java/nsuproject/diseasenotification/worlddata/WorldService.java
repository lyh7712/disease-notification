package nsuproject.diseasenotification.worlddata;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WorldService {

    @Autowired
    WorldDataRepository repository;

    public void insertData(String url) {

        try {
            Document doc = Jsoup.connect(url).get();

            Elements elements = doc.select(".status_info");
            System.out.println("el = " + elements.select("p").get(4).text());
            System.out.println("el = " + elements.select("p").get(5).text());

            WorldData worldData = WorldData.builder()
                    .worldTotal(elements.select("p").get(4).text())
                    .totalDead(elements.select("p").get(5).text())
                    .build();

            repository.save(worldData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
