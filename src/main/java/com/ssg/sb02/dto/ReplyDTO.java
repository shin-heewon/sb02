package com.ssg.sb02.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    
    private Long rno;//댓글의 고유값
    @NotNull
    private Long bno; // 게시물 번호
    
    @NotEmpty
    private String replyText;
    
    @NotEmpty
    private String replyer;
    
    @JsonFormat(pattern = "yyyy-MM-DD HH:mm:ss")//형식을 지정해줘서 데이터를 다루기 쉽게 처리
    private LocalDateTime regDate;
    
    @JsonIgnore // 직렬화/역직렬화 시 무시할 수 있음
    private LocalDateTime   
    modDate;
}
