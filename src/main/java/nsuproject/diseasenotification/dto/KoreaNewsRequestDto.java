package nsuproject.diseasenotification.dto;

import lombok.Builder;
import lombok.Data;
import nsuproject.diseasenotification.koreaNews.KoreaNews;


//
@Data
public class KoreaNewsRequestDto {

    private String title;
    private String url;

    @Builder
    public KoreaNewsRequestDto(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public KoreaNews toEntity() {
        return KoreaNews.builder()
                .title(title)
                .url(url)
                .build();
    }
}
