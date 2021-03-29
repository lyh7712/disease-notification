package nsuproject.diseasenotification.koreaNews;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class KoreaNewsRepositoryTest {

    @Autowired
    KoreaNewsRepository koreaNewsRepository;

    @AfterEach
    public void clear() {
        koreaNewsRepository.deleteAll();
    }

    @Test
    void 뉴스_내용_저장() {

        //Giver
        String title = "테스트 제목";

        koreaNewsRepository.save(KoreaNews.builder()
                .title(title)
                .build());

        //When
        List<KoreaNews> newsList = koreaNewsRepository.findAll();

        KoreaNews koreaNews = newsList.get(0);
        Assertions.assertThat(title).isEqualTo(koreaNews.getTitle());
    }
}