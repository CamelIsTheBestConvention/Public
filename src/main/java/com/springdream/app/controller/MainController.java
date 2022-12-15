package com.springdream.app.controller;

import com.springdream.app.domain.RankingDTO;
import com.springdream.app.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {
    private final RankingService rankingService;

    @GetMapping("index")
    public String index(@CookieValue(name = "memberNumber", required = false) String memberNumber, Model model, HttpServletRequest request) {

        model.addAttribute("memberNumber", request.getSession().getAttribute("memberNumber"));

        if (memberNumber != null) {
            model.addAttribute("memberNumber", Integer.valueOf(memberNumber));
        }
        List<RankingDTO> points = rankingService.rankingListService();
        model.addAttribute("points", points);

        List<RankingDTO> populars = rankingService.rankingViewcountService();
        model.addAttribute("populars", populars);

        return "main/index";
    }

    @GetMapping("searchResult")
    public String search() {
        return "fix/searchResult";
    }

}
