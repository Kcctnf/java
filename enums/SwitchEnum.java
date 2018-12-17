package com.enums;

/**
 * Autor : dong
 * Time:2018/12/17
 */


public class SwitchEnum {
    Spiciness degree;

    public SwitchEnum(Spiciness degree) {
        this.degree = degree;
    }

    public void describe() {
        System.out.println("这个SwitchEnum是：");
        switch (degree) {
            case NOT:
                System.out.println("at all");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little hot");
                break;
            case HOT:
            case FLAMING:
            default:
                System.out.println("too hot");
        }
    }

    public static void main(String[] args) {
        SwitchEnum plain = new SwitchEnum(Spiciness.NOT);
        SwitchEnum green = new SwitchEnum(Spiciness.MEDIUM);
        SwitchEnum lapeno = new SwitchEnum(Spiciness.HOT);
        plain.describe();
        green.describe();
        lapeno.describe();
    }
}





