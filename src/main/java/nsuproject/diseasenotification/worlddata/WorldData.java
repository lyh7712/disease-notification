package nsuproject.diseasenotification.worlddata;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class WorldData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String worldTotal;
    private String totalDead;

    @Builder
    public WorldData(String worldTotal, String totalDead) {
        this.worldTotal = worldTotal;
        this.totalDead = totalDead;
    }

}
