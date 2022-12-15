package com.springdream.app.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class RankingDTO {
    //  Ranking
    private long adopts;
    private long replies;

    //  PK
    private long memberNumber;

    //  Point
    private long currentPoint;
    private long totalPoint;

    //  Member
    private String memberNickname;

    //  Board
    private String boardTitle;
    private long boardNumber;
    private long boardViewcount;


}
