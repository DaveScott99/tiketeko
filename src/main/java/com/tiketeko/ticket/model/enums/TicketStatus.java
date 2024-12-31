package com.tiketeko.ticket.model.enums;

public enum TicketStatus {

    OPEN(1),
    PENDING(2),
    ON_PROGRESS(3),
    FINISHED(4),
    CLOSED(5);

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
