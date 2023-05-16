package com.example.springedu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
    private String kind;
    private int priceAvg;

    public void setKind(String kind) {
        switch (kind){
            case "b01" : this.kind = "프로그래밍 언어"; break;
            case "b02" : this.kind = "웹 프로그래밍"; break;
            case "b03" : this.kind = "빅 데이터"; break;
            case "b04" : this.kind = "데이터 베이스"; break;
            case "b05" : this.kind = "인프라"; break;
        }
    }

}
