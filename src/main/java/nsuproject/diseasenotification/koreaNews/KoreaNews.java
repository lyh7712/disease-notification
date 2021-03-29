package nsuproject.diseasenotification.koreaNews;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@ToString
@Entity
public class KoreaNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String url;

    @Builder
    public KoreaNews(Long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

}
