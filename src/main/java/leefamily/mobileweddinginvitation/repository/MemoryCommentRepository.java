package leefamily.mobileweddinginvitation.repository;

import leefamily.mobileweddinginvitation.domain.Comment;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class MemoryCommentRepository implements CommentRepository{
    private static Map<Long, Comment> memoryDB = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Comment create(Comment comment) {
        // TODO : 자동적으로 날짜도 할당해줘야 한다.
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd");
        comment.setDate(date.format(new Date()));
        comment.setId(++sequence);
        memoryDB.put(comment.getId(), comment);
        return comment;
    }

    @Override
    public boolean delete(Long id) {
        return memoryDB.remove(id) != null;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.ofNullable(memoryDB.get(id));
    }

    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(memoryDB.values());
    }

    public void clearStore() {
        memoryDB.clear();
    }
}
