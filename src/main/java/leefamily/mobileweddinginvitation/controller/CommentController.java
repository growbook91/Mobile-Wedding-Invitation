package leefamily.mobileweddinginvitation.controller;

import leefamily.mobileweddinginvitation.domain.Comment;
import leefamily.mobileweddinginvitation.repository.CommentRepository;
import leefamily.mobileweddinginvitation.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    private final CommentService commentService;
    // get mapping에서 열어주기
    // 읽어들이는 것
    @GetMapping(value = "/")
    public String list(Model model){
        List<Comment> comments = commentService.getCommentList();
        // FIXME : 이 모델은 뭐하는 것인가?
        model.addAttribute("comments", comments);
        return "index";
    }
    @GetMapping(value = "/comment")
    public String createForm() {
        return "comment/createCommentForm";
    }

    // 댓글 생성하는 것
    @PostMapping(value = "/comment")
    public String create(@ModelAttribute Comment comment) {
        commentService.writeComment(comment);
        return "blank";
    }

    // 삭제하는 것
    @GetMapping(value = "/comment/{id}")
    public String deleteForm(Model model, @PathVariable Long id){
        model.addAttribute("id", id);
        return "comment/deleteCommentForm";
    }

    @PostMapping(value = "/comment/{id}")
    public String delete(@ModelAttribute Comment comment,@PathVariable Long id){
        System.out.println("okok");
        Optional<Comment> result = commentService.getCommentById(id);
        if(result.isPresent()){
            commentService.deleteComment(comment, comment.getPassword());
        }
        return "blank";
    }


}
