package ntd.springboot.blogapprestapi.service;

import ntd.springboot.blogapprestapi.model.payload.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(long postId, long cmtId);
    CommentDto updateComment(long postId, long cmtId, CommentDto commentDto);
    void deleteComment(long postId, long cmtId);
}
