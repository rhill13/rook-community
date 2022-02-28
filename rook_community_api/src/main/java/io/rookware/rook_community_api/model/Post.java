package io.rookware.rook_community_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long postId;

    @NotBlank(message = "Post Name cannot be blank or null")
    private String postName;

    @Nullable
    private String url;

    @Nullable
    @Lob
    private String description;

    private Integer voteCount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private AppUser user;

    private Instant createdDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "communityId", referencedColumnName = "communityId")
    private Community community;

}
