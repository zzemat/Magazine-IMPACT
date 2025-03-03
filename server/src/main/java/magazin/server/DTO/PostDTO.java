package magazin.server.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

// TODO : Add Banner img
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @Size(max = 255)
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String content;

    private List<String> tags = new ArrayList<>();
}
