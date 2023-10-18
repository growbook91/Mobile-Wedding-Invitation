package leefamily.mobileweddinginvitation.repository;

import leefamily.mobileweddinginvitation.domain.Comment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryCommentRepositoryTest {
    MemoryCommentRepository repository = new MemoryCommentRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void create(){
        Comment comment = new Comment("이강민", "여러분의 결혼을 축복합니다", "1234");
        repository.create(comment);

//        Comment comment2 = new Comment("이지혜", "아주 감사합니다", "2023.10.20");
//        repository.create(comment2);
        Comment result = repository.findById(comment.getId()).get();
        assertThat(result).isEqualTo(comment);
    }

    @Test
    public void delete() {
        Comment comment = new Comment("이강민", "여러분의 결혼을 축복합니다", "1234");
        repository.create(comment);
        Long commentId = comment.getId();
        repository.delete(commentId);

        Optional<Comment> result = repository.findById(commentId);
        assertThat(result).isEqualTo(Optional.empty());

    }

    @Test
    public void findAll(){
        Comment comment1 = new Comment("이강민", "여러분의 결혼을 축복합니다",  "1234");
        repository.create(comment1);

        Comment comment2 = new Comment("이지혜", "아주 감사합니다",  "1234");
        repository.create(comment2);

        List<Comment> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}