package com.demo.UserInfo.test;

public class TicketThread extends Thread{
	private int ticket = 10;

    public void run(){
        for(int i =0;i<10;i++){
        	 //���ͬ����
            synchronized (this){
                if(this.ticket>0){
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName()+"��Ʊ---->"+(this.ticket--));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] arg){
        TicketThread t1 = new TicketThread();
        new Thread(t1,"�߳�1").start();
        new Thread(t1,"�߳�2").start();
        //Ҳ�ﵽ����Դ�����Ŀ�ģ��˴������и���д�����ܶ�д��������Բ��˵����һЩ����������ӡ֤�Լ��Ĺ۵㣬Ȼ����ʵȴ������ˡ�
    }
}
