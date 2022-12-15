package com.springdream.app.controller;

import com.springdream.app.domain.RankingDTO;
import com.springdream.app.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ranking/*")
public class RankingController {
    private final RankingService rankingService;

    //  랭킹
    @GetMapping("/rankingList")
    public void totalRanking(Model model) {
        List<RankingDTO> points = rankingService.rankingListService();
        model.addAttribute("points", points);

        List<RankingDTO> adopts = rankingService.rankingAdoptService();
        model.addAttribute("adopts", adopts);

        List<RankingDTO> replies = rankingService.rankingRepliesService();
        model.addAttribute("replies", replies);
    }
}




