package magazin.server.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import magazin.server.enums.ReactionType;

@Data
public class ReactionDTO {
    @NotNull
    private long postId;
    @NotNull
    private long profileId;
    @NotNull
    private ReactionType reactionType;
}
