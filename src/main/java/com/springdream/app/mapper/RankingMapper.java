package com.springdream.app.mapper;

import com.springdream.app.domain.PointDTO;
import com.springdream.app.domain.RankingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankingMapper {
    //  포인트 기반 랭킹 조회
    public List<RankingDTO> selectAllOrderByTotalPoint();

    //  채택 수 기반 랭킹 조회
    public List<RankingDTO> selectAllOrderByAdoptCount();

    //  댓글 수 기반 랭킹
    public List<RankingDTO> countReplies();

    //  조회 수 기반 랭킹 조회
    public List<RankingDTO> selectAllOrderByViewcount();
}
