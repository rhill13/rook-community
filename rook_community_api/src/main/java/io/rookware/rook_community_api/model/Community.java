package io.rookware.rook_community_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Community {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long communityId;

    @NotBlank(message = "Community name is required")
    private String communityName;

    @NotBlank(message = "Community description is required")
    private String description;

    @OneToMany(fetch = LAZY)
    private List<Post> posts;

    private Instant createdDate;

    @ManyToOne(fetch = LAZY)
    private AppUser user;

}
