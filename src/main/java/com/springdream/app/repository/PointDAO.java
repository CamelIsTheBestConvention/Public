package com.springdream.app.repository;


import com.springdream.app.domain.PointDTO;
import com.springdream.app.domain.PointVO;
import com.springdream.app.mapper.PointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PointDAO {
    private final PointMapper pointMapper;

    //  가입
    public void join(Long memberNumber) { pointMapper.insert(memberNumber); }

    //  현재 포인트 조회
    public PointVO findById(Long memberNumber){
        return pointMapper.select(memberNumber);
    }

    //  누적 포인트 조회
    public PointVO totalPointById(Long memberNumber){
        return pointMapper.totalPoint(memberNumber);
    }



    //  포인트VO insert
    public void insertPoint(PointVO pointVO){
        pointMapper.insert(pointVO);
    }


    //    채택 포인트 전송 (1 to 2)
//    public PointVO sendPoint(Long memberNumber1, Long memberNumber2){
//
//    }




//--------------참고 코드-----------------
//    private final BoardMapper boardMapper;
//    //    추가
//    public void save(BoardDTO boardDTO){
//        boardMapper.insert(boardDTO);
//    }
//    //    수정
//    public void setBoardVO(BoardDTO boardDTO){
//        boardMapper.update(boardDTO);
//    }
//    //    삭제
//    public void remove(Long boardNumber){
//        boardMapper.delete(boardNumber);
//    }
//    //    조회
//    public BoardVO findById(Long boardNumber){
//        return boardMapper.select(boardNumber);
//    }
//    //    전체 조회
//    public List<BoardVO> findAll(Criteria criteria){
//        return boardMapper.selectAll(criteria);
//    }
//    //    전체 개수
//    public int findCountAll(){
//        return boardMapper.getTotal();
//    }
}
