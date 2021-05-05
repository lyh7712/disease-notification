package nsuproject.diseasenotification.koreadata;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KoreaDataService {

    @Autowired
    private KoreaDataRepository repository;

    public void insertNewsData(String url) {

        try {
            Element doc = Jsoup.connect(url).get();

            Elements elements = doc.select(".ca_body");

            KoreaData koreaData = KoreaData.builder()
                    .koreaTotal(elements.select("dd").first().text())
                    .todayPatient(elements.select("p").first().text().replace("+ ", ""))
                    .totalCure(elements.select("dd").get(2).text())
                    .todayCure(elements.select("span").first().text().replace("+ ", ""))
                    .dead(elements.select("dd").get(6).text())
                    .build();

            repository.save(koreaData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<KoreaData> findAllData() {
        return repository.findAll();
    }
}
