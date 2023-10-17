package leefamily.mobileweddinginvitation.repository;

import leefamily.mobileweddinginvitation.domain.Comment;

import java.lang.reflect.Member;
import java.util.*;

public class MemoryCommentRepository implements CommentRepository{
    private static Map<Long, Comment> memoryDB = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Comment create(Comment comment) {
        comment.setId(++sequence);
        memoryDB.put(comment.getId(), comment);
        return comment;
    }

    @Override
    public boolean delete(Comment comment) {
        long commentId = comment.getId();
        return memoryDB.remove(commentId) != null;
    }


    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(memoryDB.values());
    }
}
