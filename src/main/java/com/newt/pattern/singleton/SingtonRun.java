package com.newt.pattern.singleton;


/**
 * 单例模式
 * 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 使用双检测机制，保证不需要同步代码的异步执行性，又保证了单例
 */
public class SingtonRun {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.start();
        t2.start();
        t3.start();
        /************Console******
         1543418172
         228173447
         228173447
         ***********************/
    }

    static class MyObject {

        private volatile static MyObject object;

        private MyObject() {

        }

        public static MyObject getInstance() {
            try {
                if (object != null) {
                } else {
                    //模拟创建对象执行操作
                    Thread.sleep(3000);
                    synchronized (MyObject.class) {
                        if (object == null) {
                            object = new MyObject();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return object;
        }
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(MyObject.getInstance().hashCode());
        }
    }
}
