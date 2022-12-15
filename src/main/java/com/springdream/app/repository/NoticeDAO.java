package com.springdream.app.repository;

import com.springdream.app.domain.NoticeDTO;
import com.springdream.app.domain.NoticeVO;
import com.springdream.app.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeDAO {
    private final NoticeMapper noticeMapper;
    //    추가
    public void save(NoticeVO noticeVO){
        noticeMapper.insert(noticeVO);
    }
    //    수정
    public void setBoardDTO(NoticeDTO noticeDTO){
        noticeMapper.update(noticeDTO);
    }
    //    삭제
    public void remove(Long noticeNumber){
        noticeMapper.delete(noticeNumber);
    }

    //  조회
    public NoticeDTO findByNoticeNumber(Long noticeNumber) {
        return noticeMapper.select(noticeNumber);
    }

    //  전체 조회
    public List<NoticeDTO> findAll(){ return noticeMapper.selectAll(); }


}
