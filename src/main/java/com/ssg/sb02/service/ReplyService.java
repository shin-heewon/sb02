package com.ssg.sb02.service;


import com.ssg.sb02.domain.Reply;
import com.ssg.sb02.dto.PageRequestDTO;
import com.ssg.sb02.dto.PageResponseDTO;
import com.ssg.sb02.dto.ReplyDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyService  {

    Long register(ReplyDTO replyDTO);

    ReplyDTO read(Long rno);

    void modify(ReplyDTO replyDTO);

    void remove(Long rno);

    PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO);
}
