package nsuproject.diseasenotification.koreaData;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class KoreaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String koreaTotal;
    private String todayPatient;
    private String totalCure;
    private String todayCure;
    private String Dead;

    @Builder
    public KoreaData(String koreaTotal, String todayPatient, String totalCure, String todayCure, String dead) {
        this.koreaTotal = koreaTotal;
        this.todayPatient = todayPatient;
        this.totalCure = totalCure;
        this.todayCure = todayCure;
        Dead = dead;
    }
}
