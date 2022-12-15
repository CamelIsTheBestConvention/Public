package com.springdream.app.controller;

import com.springdream.app.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice/*")
public class NoticeController {
    private final NoticeService noticeService;


    @GetMapping("/main")
    public void noticeMain(Model model) {
        model.addAttribute("notices", noticeService.showAll());
    }

    //
    @GetMapping("/recent")
    public String noticeRecent(Long noticeNumber, Model model){
        model.addAttribute("notices", noticeService.showAll());
        model.addAttribute("notice", noticeService.show(noticeNumber));
        return "/notice/recent";
    }
}
