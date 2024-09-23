package com.ssg.sb02.service;

import com.ssg.sb02.domain.Board;
import com.ssg.sb02.domain.Reply;
import com.ssg.sb02.dto.BoardDTO;
import com.ssg.sb02.dto.PageRequestDTO;
import com.ssg.sb02.dto.PageResponseDTO;
import com.ssg.sb02.dto.ReplyDTO;
import com.ssg.sb02.repository.BoardRepository;
import com.ssg.sb02.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Transactional
@Service
public class ReplyServiceImpl implements ReplyService{

    private final ModelMapper modelMapper;
    private final ReplyRepository repository;
    private final BoardRepository boardRepository;

    @Override
    public Long register(ReplyDTO replyDTO) {

        Reply reply = modelMapper.map(replyDTO, Reply.class);
        Long rno = repository.save(reply).getRno();
        return rno;
    }

    @Override
    public ReplyDTO read(Long rno) {
        return null;
    }

    @Override
    public void remove(Long rno) {
        Optional<Reply> result = repository.findById(rno);
        Reply reply = result.orElseThrow();
        ReplyDTO replyDTO = modelMapper.map(reply, ReplyDTO.class);
    }

    @Override
    public PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO) {

        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() <=0? 0: pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("rno").ascending());

        Page<Reply> result = repository.listOfBoard(bno, pageable);

        List<ReplyDTO> dtoList =
                result.getContent().stream().map(reply -> modelMapper.map(reply, ReplyDTO.class))
                        .collect(Collectors.toList());

        return PageResponseDTO.<ReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();

    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Optional<Reply> result = repository.findById(replyDTO.getRno());
        Reply reply = result.orElseThrow();
        reply.changeText(reply.getReplyText());
    }


}
