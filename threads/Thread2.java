package com.threads;

/**
 * Autor : dong
 * Time:2018/12/22
 */
class PersonInfoRunnable implements Runnable{
    private final PrintInfo task;
    public PersonInfoRunnable(PrintInfo task){
        this.task = task;
    }
    @Override
    public void run(){
        this.task.print("hello","java");
    }
}
class PrintInfo{
    public void print(Object ... args){
        for(int i =0;i < args.length;i++){
            System.out.println(args[i]);
        }
    }
}
public class Thread2{
    public static void main(String[] args){
		//new PrintInfo().print("hells","world");
		PrintInfo task = new PrintInfo();
		Runnable tRunnable = new PersonInfoRunnable(task);
		Thread thread1 = new Thread(tRunnable);
		thread1.start();

		Thread thread2 = new Thread(tRunnable);
		thread2.start();
       /* Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                task.print("hello","java");
            }
        });
        //Lambda表达式,就可以不用实现Runnable接口了
        Thread thread4 = new Thread(() -> task.print("hello","java"));
        thread4.start();*/
    }
}
