package ntd.springboot.blogapprestapi.model.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class PostDtoV2 {
    private Long id;

    @Schema(description = "Title of Post", example = "Spring Boot")
    @NotEmpty
    @Size(min = 2, message = "Title should have at least 2 characters")
    private String title;

    @Schema(description = "Description of Post", example = "Spring Boot is a framework")
    @NotEmpty
    @Size(min = 10, message = "Description should have at least 10 characters")
    private String description;

    @Schema(description = "Content of Post", example = "Spring Boot is a framework to help you build Spring based applications quickly and easily")
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;

    @Schema(description = "Category Id of Post", example = "1")
    private Long categoryId;

    private List<String> tags;
}
