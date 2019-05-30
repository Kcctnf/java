package dong.work4;

/**
 * Author : dong
 * Time:2019/5/30
 */
public class Main3 {
    public static void main(String[] args) {
        Object o = new Object(){
          public boolean equals(Object obj){

              return true;
          }
        };
        System.out.println(o.equals("Fred"));
    }
}
