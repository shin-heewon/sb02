package com.ssg.sb02.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Reply", indexes = { @Index(name="inx_reply_board_bno", columnList = "board_bno")})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")//board 테이블 참조하지 않겠다. =>
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)//하나의 글에 대해 여러개의 댓글이 달리 수 있다~
    // , 하나만 들고오지 않고 관려된 글들을 모두 들고온다?
    private Board board;

    private String replyText;

    private String replyer;

    public void changeText(String text){
        this.replyText = text;
    }
}
