package leefamily.mobileweddinginvitation.service;

import leefamily.mobileweddinginvitation.domain.Comment;
import leefamily.mobileweddinginvitation.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class CommentServiceTest {
    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;


    @Test
    public void 댓글작성() throws Exception {
        //Given
        Comment comment = new Comment();
        comment.setPassword("1234");
        comment.setName("이강민");
        comment.setContent("여러분의 결혼을 축복합니다.");

        //when
        Long savedId = commentService.writeComment(comment);

        //Then
        Comment result = commentRepository.findById(comment.getId()).get();

        //객체가 동일한 지 검증
        assertThat(result.getName()).isEqualTo(comment.getName());
        assertThat(result.getDate()).isEqualTo(comment.getDate());
        assertThat(result.getContent()).isEqualTo(comment.getContent());
        assertThat(result.getPassword()).isEqualTo(comment.getPassword());
    }
    @Test
    public void 댓글삭제() throws Exception {
        //Given
        Comment comment = new Comment();
        comment.setPassword("1234");
        comment.setName("이강민");
        comment.setContent("여러분의 결혼을 축복합니다.");

        //When
        Long savedId = commentService.writeComment(comment);
        commentService.deleteComment(comment,comment.getPassword());

        //Then
        Optional<Comment> result = commentRepository.findById(comment.getId());
        assertThat(result).isEqualTo(Optional.empty());
    }

    @Test
    public void 공란처리() throws Exception {
        //Given
        Comment comment = new Comment();
        comment.setPassword("1234");
        comment.setName("");
        comment.setContent("여러분의 결혼을 축복합니다.");

        //When
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> commentService.writeComment(comment));

        assertThat(e.getMessage()).isEqualTo("이름을 입력해주세요.");
    }
}