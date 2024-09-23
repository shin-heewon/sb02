//package com.ssg.sb02.controller;
//
//
//import com.ssg.sb02.dto.ReplyDTO;
//import com.ssg.sb02.service.ReplyService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.http.MediaType;
//import org.springframework.validation.BindException;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.awt.*;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/replies")
//@Log4j2
//@RequiredArgsConstructor
//public class ReplyController {
//
//    private final ReplyService replyService;
//
//
//    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String, Long> register(@Valid @RequestBody ReplyDTO replyDTO, BindingResult bindingResult)throws BindException{
//        log.info(replyDTO);
//
//        if(bindingResult.hasErrors()){
//            throw new BindException(bindingResult);
//        }
//
//        Map<String, Long> resultMap = new HashMap<>();
//        Long rno = replyService.register(replyDTO);
//        resultMap.put("rno", rno);
//
//        return resultMap;
//    }
//
//}
