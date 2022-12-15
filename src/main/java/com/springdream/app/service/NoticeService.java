package com.springdream.app.service;

import com.springdream.app.domain.NoticeDTO;
import com.springdream.app.repository.NoticeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("notice") @Primary
public class NoticeService{

    private final NoticeDAO noticeDAO;

    //  공지사항 메인 - 최신순 공지사항 조회
    public List<NoticeDTO> showAll(){ return noticeDAO.findAll();}

    //  공지사항 상세 페이지
    public NoticeDTO show(Long noticeNumber){ return noticeDAO.findByNoticeNumber(noticeNumber);}
}
