package com.dongs;

/**
 * Autor : dong
 * Time:2018/12/10
 */
class Point {
    private Object x;
    private Object y;


    public Point() {
    }

    public Point(Object x, Object y) {
        this.x = x;
        this.y = y;
    }

    public Object getX() {
        return x;
    }

    public Object getY() {
        return y;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public void setY(Object y) {
        this.y = y;
    }
}

public class PointTest {
    public static void main(String[] args) {
    //she zhi shu ju
    Point p = new Point();
    p.setX(10);
    p.setY(20);
    //qu chu shu ju
    int x = (Integer) p.getX();
    int y = (Integer) p.getY();
    System.out.println("x= :"+x+",y= :"+y);

    //设置数据
    Point p1 = new Point();
    p.setX("东经80度");
    p.setY("北纬20度");
    // 取出数据
    String x1 = (String) p.getX();
    String y1 = (String) p.getY();
    System.out.println("x= "+x+",y= "+y);

    }
}
