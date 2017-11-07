package Utils;

/**
 * Created by hanxiaodi on 17/7/26.
 */
public class MyThread implements Runnable{
    public static  void main(String[] args){
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt,"t1");
        Thread t2 = new Thread(mt,"t2");
        Thread t3 = new Thread(mt,"t3");
        t1.start();
        t2.start();
        t3.start();



    }
    public void run(){


            for(int i =0 ;i<10;i++)
            System.out.println(Thread.currentThread().getName()+"计数"+i);

    }

}
