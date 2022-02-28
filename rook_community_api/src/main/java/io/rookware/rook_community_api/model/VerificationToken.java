package io.rookware.rook_community_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "token")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long tokenId;

    private String token;

    @OneToOne(fetch = LAZY)
    private AppUser user;

    private Instant expires;

}
