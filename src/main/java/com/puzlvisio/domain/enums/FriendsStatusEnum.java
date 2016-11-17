package com.puzlvisio.domain.enums;

/**
 * Created by wonder on 6/2/2016.
 */
public enum FriendsStatusEnum {
    REQUEST, ACCEPTED, DENY;

    FriendsStatusEnum() {}

    public String getName() {
        return this.name();
    }
}
