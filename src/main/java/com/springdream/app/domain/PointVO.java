package com.springdream.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PointVO {

    private long currentPoint;
    private long totalPoint;
    private long memberNumber;

    //  join
    public void create(Long memberNumber) {
        this.memberNumber = memberNumber;
    }

//    CREATE TABLE TBL_POINT(
//            CURRENT_POINT NUMBER DEFAULT 500,
//            TOTAL_POINT NUMBER DEFAULT 500,
//            MEMBER_NUMBER NUMBER CONSTRAINT PK_POINT PRIMARY KEY,
//            CONSTRAINT FK_MEMBER_NUMBER3 FOREIGN KEY(MEMBER_NUMBER) REFERENCES TBL_MEMBER(MEMBER_NUMBER) ON DELETE CASCADE
//);
}
