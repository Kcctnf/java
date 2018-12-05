package com.dong;

/**
 * Autor : dong
 * Time:2018/12/5
 */
public class Message implements AutoCloseable {

    public void print() {
        System.out.println("message打印");
    }

    @Override
    public void close() throws Exception {
        System.out.println("message关闭");
    }

    public static void main(String[] args) {

//        Message message = new Message();
//        message.print();
//        try {
//            message.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //AutoCloseable 的close能够被自动调用
        /*
            try{

            }catch(){

            }finally{

            }

            //try-with-resources
            try(实例化对象的代码，实例化对象的类实现AutoCloseable接口){

            }catch(){

            }finally{

            }
         */

//        try (Message message = new Message()) {
//            message.print();
//        } catch (Exception e) {
//
//        }
        Message message = null;
        try {
            message = new Message();
            message.print();
        } catch (Exception e) {

        } finally {
            //自己关闭对象
            if (message != null) {
                try {
                    message.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}



