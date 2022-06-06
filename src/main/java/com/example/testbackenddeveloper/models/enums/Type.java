package com.example.testbackenddeveloper.models.enums;

public enum Type {

    DNI("dni"),
    LE("le"),
    LC("lc");

    private final String string;

    Type(final String string)
    {
        this.string = string;
    }

    public String get()
    {
        return string;
    }
}
