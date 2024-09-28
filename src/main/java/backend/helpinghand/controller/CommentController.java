package backend.helpinghand.controller;


import backend.helpinghand.entities.Comment;
import backend.helpinghand.entities.Donation;
import backend.helpinghand.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/helpinghands")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> listAllComments() {
        return new ResponseEntity<>(commentService.listAllComments(), HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment>  addComment(@RequestBody Comment comment) {
        Comment newComment = commentService.addComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.OK);
    }

    @GetMapping("/comments/profile/{name}")
    public ResponseEntity<List<Comment>> listCommentsByProfileName(@PathVariable ("name") String name){
        return new ResponseEntity<>(commentService.listCommentsByProfileName(name),HttpStatus.OK);
    }
}
