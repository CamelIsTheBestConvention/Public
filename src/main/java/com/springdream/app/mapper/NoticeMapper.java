package com.springdream.app.mapper;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.NoticeDTO;
import com.springdream.app.domain.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    //  추가
    public void insert(NoticeVO noticeVO);

    //  수정
    public void update(NoticeDTO noticeDTO);

    //  삭제
    public void delete(Long noticeNumber);

    //  조회
    public NoticeDTO select(Long noticeNumber);

    //  전체 조회
    public List<NoticeDTO> selectAll();

}
