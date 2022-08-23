package org.example.log.enums;

public enum BusinessType {
    SELECT("select"),
    INSERT("insert"),
    UPDATE("update"),
    DELETE("delete"),
    GRANT("grant"),
    EXPORT("export"),
    IMPORT("import"),
    CLEAN("clean"),
    OTHER("other");

    private final String value;
    BusinessType(String value) {
        this.value = value;
    }
}
