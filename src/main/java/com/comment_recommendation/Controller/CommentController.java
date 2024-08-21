package com.comment_recommendation.Controller;

import com.comment_recommendation.Entities.Comment;
import com.comment_recommendation.Service.ICommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@Tag(name = "Api Rest for brands use Swagger 3 - Comments")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/save")
    @Operation(summary = "This endpoint is used to comment videos")
    public void createComment(@RequestBody Comment comment) {
        commentService.createComment(comment);
    }

    @GetMapping("/video/{videoId}")
    @Operation(summary = "This endpoint is used to find video")
    public ResponseEntity<?> getCommentByVideoId(@PathVariable String videoId) {
        List<Comment> comments = commentService.getCommentsByVideoId(videoId);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "This endpoint is used to delete comment video")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        try {
            commentService.deleteComment(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}