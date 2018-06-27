package com.demo.UserInfo.test;
/**
 * 
 * @author liu.hb
 *如果你有三个线程，分别为T1,T2,T3,如何让线程T2在线程T1之后执行，在线程T3之前执行。
 *thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
 *比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
 *t.join();      //使调用线程 t 在此之前执行完毕。
 *t.join(1000);  //等待 t 线程，等待时间是1000毫秒
 */
public class ThreeThread {
	public static void main(String[] args) throws InterruptedException {  
        final Thread t1 = new Thread(new Runnable(){  
            @Override  
            public void run() {  
                try {  
                    Thread.sleep(1000);  
                    System.out.println(Thread.currentThread().getName());  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        },"Thread-T1");  
        final Thread t2 = new Thread(new Runnable(){  
            @Override  
            public void run() {  
                try {  
                    t1.join();  
                    Thread.sleep(1000);  
                    System.out.println(Thread.currentThread().getName());  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        },"Thread-T2");  
        final Thread t3 = new Thread(new Runnable(){  
            @Override  
            public void run() {  
                try {  
                    t2.join();  
                    Thread.sleep(1000);  
                    System.out.println(Thread.currentThread().getName());  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        },"Thread-T3");  
        Thread t4 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					t3.join();
					Thread.sleep(1000);
					 System.out.println(Thread.currentThread().getName());  
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}
		},"Thread-T4");
        t3.start();  
        t2.start();  
        t1.start();  
        t4.start(); 
        
        /**
         * 第二种实现方式，线程执行顺序可以在方法中调换
         */       
            Runnable runnable = new Runnable() {
                @Override public void run() {
                    System.out.println(Thread.currentThread().getName() + "执行完成");
                }
            };
            Thread t5 = new Thread(runnable, "t5");
            Thread t6 = new Thread(runnable, "t6");
            Thread t7 = new Thread(runnable, "t7");
            try {
            	t5.start();
            	t5.join();
            	t6.start();
            	t6.join();
            	t7.start();
            	t7.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }        
    }  
}
