package com.demo.UserInfo.test;

import java.util.Random;

public class BubbleSort {
    
	/**
	 * 冒泡排序
	 * 平均时间复杂度：O(n2)
	 * @param arr
	 */
	public static void Sort(int []arr){
		System.out.println("----------没有排序的数组-----------");
		for(int i=0;i<arr.length-1;i++){			
			System.out.print("数字："+arr[i]+"  ");
		}
		
		int temp;//临时变量
		for(int i=0; i<arr.length-1; i++){
			//表示趟数，一共arr.length-1次。 
			for(int j=arr.length-1; j>i; j--){ 
				if(arr[j] < arr[j-1]){ 
					temp = arr[j]; 
					arr[j] = arr[j-1]; 
					arr[j-1] = temp; 
					} 
				} 
			}
		System.out.println();
		System.out.println("----------冒泡排序后的数组-----------");
		for(int i=0;i<arr.length-1;i++){			
			System.out.print("数字："+arr[i]+"  ");
		}
	}
	/**
	 * 优化冒泡排序
	 * 这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。
	 * @param arr
	 */
	public static void BubbleSort1(int []arr){
		System.out.println("\n-------------优化后的冒泡排序------------");
		System.out.println("----------没有排序的数组-----------");
		for(int i=0;i<arr.length-1;i++){			
			System.out.print("数字："+arr[i]+"  ");
		}
		int temp;//设置临时参数
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
		System.out.println("----------冒泡排序后的数组-----------");
		for(int i=0;i<arr.length-1;i++){			
			System.out.print("数字："+arr[i]+"  ");
		}
	}
	public static void main(String[] args) {
		Random random=new Random();
		int [] arr=new int[10];
		for(int i=0;i<10;i++){
			arr[i]=random.nextInt(10)+1;
		}
		Sort(arr);
		BubbleSort1(arr);
	}

}
