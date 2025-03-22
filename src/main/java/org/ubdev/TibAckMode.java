package org.ubdev;

public enum TibAckMode {

    AUTO_ACKNOWLEDGE(1),
    CLIENT_ACKNOWLEDGE(2),
    DUPS_OK_ACKNOWLEDGE(3),
    NO_ACKNOWLEDGE(22),
    EXPLICIT_CLIENT_ACKNOWLEDGE(23),
    EXPLICIT_CLIENT_DUPS_OK_ACKNOWLEDGE(24);

    public final int mode;

    TibAckMode(int mode) {
        this.mode = mode;
    }
}
