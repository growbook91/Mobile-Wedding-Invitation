package leefamily.mobileweddinginvitation.repository;

import leefamily.mobileweddinginvitation.domain.Comment;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    // 생성과 삭제 findAll이 구현되어야 한다.
    Comment create(Comment comment);
    boolean delete(Comment comment);
    List<Comment> findAll();
}
