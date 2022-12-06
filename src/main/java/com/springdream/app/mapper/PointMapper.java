package com.springdream.app.mapper;

import com.springdream.app.domain.PointDTO;
import com.springdream.app.domain.PointVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//  worker: Lee JunSang
//  lastUpdate: 221206
@Mapper
public interface PointMapper {
    //  회원 가입
    public void insert(Long memberNumber);

//    개인 포인트 조회
    public PointVO select(Long memberNumber);

//    개인 총 포인트 조회
    public PointVO totalPoint(Long memberNumber);

//    포인트 기반 랭킹 조회
    public List<PointDTO> selectAllOrderByTotalPoint();

//    채택 수 기반 랭킹 조회
    public List<PointDTO> selectAllOderByAdoptCount();

//   insert
    public void insert(PointVO pointVO);

    List<PointDTO> countReplies();
}
