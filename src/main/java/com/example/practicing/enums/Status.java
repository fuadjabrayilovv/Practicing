package com.example.practicing.enums;

public enum Status {
        ADMINISTRATOR("administrator"),
        EDITOR("editor"),
        USER("user");

        private final String value;

        Status(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Status fromValue(String value) {
            if(value == null){
                return null;
            }
            for (Status status : values()) {
                if (status.name().equalsIgnoreCase(value)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("incorrect value: " + value);
        }
    }

