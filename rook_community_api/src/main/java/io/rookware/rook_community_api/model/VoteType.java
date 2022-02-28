package io.rookware.rook_community_api.model;

public enum VoteType {
    UPVOTE(1), DOWNVOTE(-1),;

    VoteType(int direction){}
}
