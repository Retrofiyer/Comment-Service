package com.comment_recommendation.Service;

import com.comment_recommendation.Entities.Comment;

import java.util.List;

public interface ICommentService {
    Comment createComment(Comment comment);
    List<Comment> getCommentsByVideoId(String videoId);
    void deleteComment(Long id);
}
