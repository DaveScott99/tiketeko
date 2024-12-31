package com.tiketeko.ticket.model.enums;

public enum TicketStatus {

    PENDING(1),
    ON_PROGRESS(2),
    COMPLETE(3);

    private int code;

    TicketStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TicketStatus valueOf(int code) {

        for (TicketStatus value : TicketStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid TicketStatus code");

    }
}
