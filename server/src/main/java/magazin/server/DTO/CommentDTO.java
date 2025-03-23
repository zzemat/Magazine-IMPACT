package magazin.server.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentDTO {
    @NotNull
    private long postId;
    @NotNull
    @NotBlank
    private String content;
}
