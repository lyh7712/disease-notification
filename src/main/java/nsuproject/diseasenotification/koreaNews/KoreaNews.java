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

    @Column
    private Long count;


    @Builder
    public KoreaNews(String title, String url, Long count) {
        this.title = title;
        this.url = url;
        this.count = count;
    }

}
