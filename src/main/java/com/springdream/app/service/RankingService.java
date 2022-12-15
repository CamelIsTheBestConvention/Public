package com.springdream.app.service;

import com.springdream.app.domain.RankingDTO;
import com.springdream.app.repository.RankingDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("ranking") @Primary
public class RankingService {
    private final RankingDAO rankingDAO;
////    포인트 보유 리스트
//    @Override
//    public List<PointVO> list(Criteria criteria) {
//        return pointDAO.findAll(criteria);
//    }

    //  포인트 랭킹 리스트
    public List<RankingDTO> rankingListService(){ return rankingDAO.findAllOrderByTotalPoint(); }

    //  채택 랭킹 리스트
    public List<RankingDTO> rankingAdoptService() { return rankingDAO.findAllOrderByAdoptCount(); }

    //  답글 랭킹 리스트
    public List<RankingDTO> rankingRepliesService() { return rankingDAO.countReplies(); }

    //  조회수 랭킹 리스트(최근 한달)
    public List<RankingDTO> rankingViewcountService() { return rankingDAO.findAllOrderByViewcount();}
}






















