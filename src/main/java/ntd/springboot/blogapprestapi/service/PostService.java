package ntd.springboot.blogapprestapi.service;

import ntd.springboot.blogapprestapi.model.payload.PostDto;
import ntd.springboot.blogapprestapi.model.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);
    List<PostDto> getPostsByCategoryId(long categoryId);
}
