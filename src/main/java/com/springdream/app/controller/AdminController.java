package com.springdream.app.controller;

import com.springdream.app.domain.MemberDTO;
//import com.springdream.app.service.AdminReportService;
import com.springdream.app.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {

//    private final AdminReportService adminreportService;

    private final AdminBoardService adminBoardService;
    private final AdminMemberService adminMemberService;
    private final AdminReportService adminReportService;


    @GetMapping("main")
    public String main(Model model){
        // 관리자 계정인지 검사 필요
        model.addAttribute("newMembers", adminMemberService.newMembers(10));
        return "admin/adminPage-main";
    }

    // 유저 리스트
    @GetMapping("userlist")
    public String userList(Model model){
        int totalMemberCount = adminMemberService.selectAllDTO().size();
        model.addAttribute("members", adminMemberService.selectAllDTO());
        model.addAttribute("memberTotal", totalMemberCount);
        return "admin/adminPage-userlist";
    }

    @PostMapping("userlist")
    public String searchMember(String memberNumber, Model model){
        if (!memberNumber.equals("")) {
            Long num = Long.parseLong(memberNumber);
            int totalMemberCount = adminMemberService.selectAllDTO().size();
            model.addAttribute("members", adminMemberService.selectDTO(num));
            model.addAttribute("memberTotal", totalMemberCount);
        }
        else {
            int totalMemberCount = adminMemberService.selectAllDTO().size();
            model.addAttribute("members", adminMemberService.selectAllDTO());
            model.addAttribute("memberTotal", totalMemberCount);
        }

        return "admin/adminPage-userlist";

    }

    @ResponseBody
    @PostMapping("userlist.remove")
    public void removeMember(String memberNumber){
        adminMemberService.remove(Long.parseLong(memberNumber));
    }

    @ResponseBody
    @PostMapping("userlist.quit")
    public void quitMember(String memberNumber){
        adminMemberService.quit(Long.parseLong(memberNumber));
    }

    // 게시글 목록
    @GetMapping("boards")
    public String boards(Model model){
        int totalBoardCount = adminBoardService.showAll().size();
        model.addAttribute("boards", adminBoardService.showAll());
        model.addAttribute("totalBoardCount", totalBoardCount);
        return "admin/adminPage-post";
    }

    @PostMapping("boards/search.category")
    public String searchBoardByCategory(String boardCategory, Model model){

        int totalBoardCount = adminBoardService.showAll().size();
        if (!boardCategory.equals("")) {
            model.addAttribute("boards", adminBoardService.categoryPost(boardCategory));

        } else {
            model.addAttribute("boards", null);
        }
        model.addAttribute("totalBoardCount", totalBoardCount);
        return "admin/adminPage-post";
    }

    @PostMapping("boards/search.number")
    public String searchBoardByNum(String boardNumber, Model model){
        if (!boardNumber.equals("")) {
            Long num = Long.parseLong(boardNumber);
            int totalBoardCount = adminBoardService.showAll().size();

            model.addAttribute("boards", adminBoardService.show(num));
            model.addAttribute("totalBoardCount", totalBoardCount);
        } else {
            int totalBoardCount = adminBoardService.showAll().size();
            model.addAttribute("boards", adminBoardService.showAll());
            model.addAttribute("totalBoardCount", totalBoardCount);
        }
        return "admin/adminPage-post";

    }

    @ResponseBody
    @PostMapping("boards.remove")
    public void removeBoard(String boardNumber){
        adminBoardService.remove(Long.parseLong(boardNumber));
    }

    @GetMapping("report")
    public String report(Model model){
        model.addAttribute("reports", adminReportService.showAll());
        return "admin/adminPage-report";
    }
}
