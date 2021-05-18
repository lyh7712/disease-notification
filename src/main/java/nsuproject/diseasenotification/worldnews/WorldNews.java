package nsuproject.diseasenotification.worldnews;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class WorldNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String url;

    @Column
    private Long count;

    @Builder
    public WorldNews(String title, String url, Long count) {
        this.title = title;
        this.url = url;
        this.count = count;
    }
}
