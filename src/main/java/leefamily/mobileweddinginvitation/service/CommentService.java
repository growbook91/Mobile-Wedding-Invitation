package leefamily.mobileweddinginvitation.service;

import leefamily.mobileweddinginvitation.domain.Comment;
import leefamily.mobileweddinginvitation.repository.CommentRepository;
import leefamily.mobileweddinginvitation.repository.MemoryCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    private final CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    /*새로운 댓글 작성*/
    public void writeComment(Comment comment){
        validateInputs(comment);
        commentRepository.create(comment);
    }

    public void deleteComment(Comment comment, String input){
        //  TODO: validation이 실패하면 팝업 창이 떠야 함..
        if(!comment.getPassword().equals(input)){
            throw new IllegalArgumentException("비밀번호를 다시 확인해주세요.");
        }
        else{
            commentRepository.delete(comment.getId());
        }
    }
    private void validateInputs(Comment comment){
    //  TODO: validation이 실패하면 팝업 창이 떠야 함..
        if(comment.getName().isEmpty()){
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        else if(comment.getContent().isEmpty()){
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }
        else if(comment.getPassword().isEmpty()){
            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
        }
    }


    public List<Comment> getCommentList() {
        return commentRepository.findAll();
    }
}
