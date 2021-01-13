package com.kd.microservices.tmp.tfs.enums;

import java.util.stream.Stream;

public enum TransportType {
    CAR("car"),
    BUS("bus"),
    TRUCK("truck"),
    TRAIN("train"),
    FLIGHT("flight"),
    SHIP("ship");

    private String value;

    private TransportType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TransportType of(String value) {
        return Stream.of(TransportType.values())
                .filter(p -> p.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
