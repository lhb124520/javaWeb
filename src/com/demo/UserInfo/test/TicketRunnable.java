package com.demo.UserInfo.test;

public class TicketRunnable implements Runnable{
	private int ticket = 10;

    @Override
    public void run() {
        for(int i =0;i<10;i++){
            //���ͬ����
            synchronized (this){
                if(this.ticket>0){
                    try {
                        //ͨ��˯���߳���ģ������һ��Ʊ����Ʊ����
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName()+"��Ʊ---->"+(this.ticket--));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] arg){
        TicketRunnable t1 = new TicketRunnable();
        new Thread(t1, "�߳�1").start();
        new Thread(t1, "�߳�2").start();
    }
}
