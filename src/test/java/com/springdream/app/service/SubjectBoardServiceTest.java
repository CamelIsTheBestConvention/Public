package com.springdream.app.service;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.BoardVO;
import com.springdream.app.domain.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SubjectBoardServiceTest {
    @Autowired
    private BoardService boardService;

    //    게시글 작성 테스트
    @Test
    public void registerTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.create("한국사", "한국사 서비스 테스트1", "한1", 300, 41L);
        boardService.register(boardVO);
    }

    //    게시글 수정 테스트
    @Test
    public void modifyTest(){
        BoardDTO boardDTO = boardService.show(104L);
        boardDTO.setBoardTitle("수정 서비스 테스트");
        boardService.modify(boardDTO);
    }

    //    게시글 조회 테스트
    @Test
    public void showTest(){
        log.info("board : " + boardService.show(2L));
    }

    //    게시글 목록 전체 조회
    @Test
    public void showAllTest(){
        boardService.showAll(new Criteria().create(1, 5)).stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }
    
    //    인기글
    @Test
    public void popularPost(){
        boardService.showAll(new Criteria()).stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }
    
    //    최신글
    @Test
    public void recentPost(){
        boardService.showAll(new Criteria()).stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }
    
    //    카테고리별
    @Test
    public void categoryPost(){
        boardService.categoryPost("한국사").stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }

}