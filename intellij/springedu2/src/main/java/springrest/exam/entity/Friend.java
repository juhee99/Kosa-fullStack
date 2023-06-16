package springrest.exam.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fname;
    private Integer fage;

    @Builder
    public Friend(String fname, Integer fage){
        this.fname =fname;
        this.fage =fage;
    }

}
