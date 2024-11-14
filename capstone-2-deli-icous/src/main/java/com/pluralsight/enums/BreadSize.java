package com.pluralsight.enums;

public enum BreadSize {
    SMALL("4 INCH"),
    MEDIUM("8 INCH"),
    LARGE("12 INCH");

    final String description;

    BreadSize(String description){
        this.description = description;
    }

}
