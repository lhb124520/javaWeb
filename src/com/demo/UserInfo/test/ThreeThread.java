package com.demo.UserInfo.test;
/**
 * 
 * @author liu.hb
 *������������̣߳��ֱ�ΪT1,T2,T3,������߳�T2���߳�T1֮��ִ�У����߳�T3֮ǰִ�С�
 *thread.Join��ָ�����̼߳��뵽��ǰ�̣߳����Խ���������ִ�е��̺߳ϲ�Ϊ˳��ִ�е��̡߳�
 *�������߳�B�е������߳�A��Join()������ֱ���߳�Aִ����Ϻ󣬲Ż����ִ���߳�B��
 *t.join();      //ʹ�����߳� t �ڴ�֮ǰִ����ϡ�
 *t.join(1000);  //�ȴ� t �̣߳��ȴ�ʱ����1000����
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
         * �ڶ���ʵ�ַ�ʽ���߳�ִ��˳������ڷ����е���
         */       
            Runnable runnable = new Runnable() {
                @Override public void run() {
                    System.out.println(Thread.currentThread().getName() + "ִ�����");
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
