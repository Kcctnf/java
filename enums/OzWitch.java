package com.enums;

/**
 * Autor : dong
 * Time:2018/12/17
 */

public enum OzWitch {
    WEST("west"),
    NORTH("north"),
    EAST("east"),
    SOUTH("south");
    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch z : OzWitch.values()) {
            System.out.println(z + " " + z.ordinal() + z.getDescription());
        }
    }

}
