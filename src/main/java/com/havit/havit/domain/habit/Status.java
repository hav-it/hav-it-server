package com.havit.havit.domain.habit;

import java.util.Objects;
import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

    Status(String value) {
        this.value = value;
    }

    public static Status getStatus(String status) {
        return Objects.equals(status, ACTIVE.value) ? ACTIVE : INACTIVE;
    }

    private String value;
}
