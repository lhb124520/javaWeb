package com.demo.UserInfo.test;

import java.util.Random;

public class BubbleSort {
    
	/**
	 * ð������
	 * ƽ��ʱ�临�Ӷȣ�O(n2)
	 * @param arr
	 */
	public static void BubbleSort(int [] arr){
		System.out.println("----------û�����������-----------");
		for(int i=0;i<arr.length-1;i++){			
			System.out.print("���֣�"+arr[i]+"  ");
		}
		
		int temp;//��ʱ����
		for(int i=0; i<arr.length-1; i++){
			//��ʾ������һ��arr.length-1�Ρ� 
			for(int j=arr.length-1; j>i; j--){ 
				if(arr[j] < arr[j-1]){ 
					temp = arr[j]; 
					arr[j] = arr[j-1]; 
					arr[j-1] = temp; 
					} 
				} 
			}
		System.out.println();
		System.out.println("----------ð������������-----------");
		for(int i=0;i<arr.length-1;i++){			
			System.out.print("���֣�"+arr[i]+"  ");
		}
	}
	/**
	 * �Ż�ð������
	 * ��һ��û�з���������˵�����ݵ�˳���Ѿ��źã�û�б�Ҫ����������ȥ��
	 * @param arr
	 */
	public static void BubbleSort1(int []arr){
		System.out.println("\n-------------�Ż����ð������------------");
		System.out.println("----------û�����������-----------");
		for(int i=0;i<arr.length-1;i++){			
			System.out.print("���֣�"+arr[i]+"  ");
		}
		int temp;//������ʱ����
		for(int i=0;i<arr.length-1;i++){
			boolean flag=false;
			for(int j=arr.length-1;j>0;j--){
				if(arr[j]<arr[j-1]){
					temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
					flag=true;
				}				
			}
			if(!flag){
				break;
			}
		}
		System.out.println();
		System.out.println("----------ð������������-----------");
		for(int i=0;i<arr.length-1;i++){			
			System.out.print("���֣�"+arr[i]+"  ");
		}
	}
	public static void main(String[] args) {
		Random random=new Random();
		int [] arr=new int[10];
		for(int i=0;i<10;i++){
			arr[i]=random.nextInt(10)+1;
		}
		BubbleSort(arr);
		BubbleSort1(arr);
	}

}
