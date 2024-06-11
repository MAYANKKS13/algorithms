package com.learn.algorithms;


public class Test2 {


    public static void main(String[] args) {
        Test2 t = new Test2();
        t.mainhelper();
    }

    public void mainhelper(){
        for (int i = 1; i <= 100; i++){
            synchronized(MyThread.class) {
                new Thread(new MyThread(i)).start();
            }
        }
    }



}


class MyThread implements Runnable {

    int a;

    public MyThread(int a) {
        this.a = a;
    }

    @Override
    public void run() {
       m1();
    }

    private void m1() {
        System.out.println(a);
    }
}
