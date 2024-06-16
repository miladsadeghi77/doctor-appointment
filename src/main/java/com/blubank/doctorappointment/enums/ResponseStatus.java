package com.blubank.doctorappointment.enums;

public enum ResponseStatus {
    ERROR("error"),
    SUCCESS("success"),
    WARN("warn");

    private final String status;

    ResponseStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
