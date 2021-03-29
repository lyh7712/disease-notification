package nsuproject.diseasenotification.koreaData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KoreaData {

    private final Long koreaTotal;
    private final Long todayPatient;
    private final Long totalCure;
    private final Long todayCure;
    private final Long Dead;

    public KoreaData(Long koreaTotal, Long todayPatient, Long totalCure, Long todayCure, Long dead) {
        this.koreaTotal = koreaTotal;
        this.todayPatient = todayPatient;
        this.totalCure = totalCure;
        this.todayCure = todayCure;
        Dead = dead;
    }

}
