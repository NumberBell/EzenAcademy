package com.ezen.test;

public class Hello {

	//�Լ��� �������̽� �����ϰ� ����ϱ�
	
	@FunctionalInterface
	public interface Sum {
		public int add(int a, int b);
	}
	
	public static void main(String[] args) {
		//�Ϲ�Ŭ����
		//�͸�Ŭ����
		//Lambda��
		
		class MyRun implements Runnable{
			@Override
			public void run() {
				System.out.println("1. run()");
			}
		}
		
		MyRun mr = new MyRun();
		Thread t1 = new Thread(mr);
		t1.start();
		//--------------------------------------------------
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("2. run()");
			}
		});
		t2.start();
		//--------------------------------------------------
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("3. run()");
			}
		}).start();
		//--------------------------------------------------
		new Thread(()->{
			System.out.println("4. run()");
		}).start();
		//--------------------------------------------------
		new Thread(()->System.out.println("5. run()")).start();
	
		//�Լ��� �������̽� �����ϰ� ����ϱ�
		//�޼ҵ尡 �ϳ����̶� add�޼ҵ� �������̵� ��
		lambda_test((a,b)->{return a+b;});
		
		getResult((a,b)->{
			int sum=0 ;
			for(int i=3; i<=b; i++) 
				sum= sum+i;
			return sum;
		});
		
		getResult1((start, end)->{
			int total=0 ;
			for(int i=start; i<=end; i++) 
				total +=i;
			return total;
		}, 2, 5);
	}
	
	public static void lambda_test(Sum sum) {
		int res = sum.add(3, 5);
		System.out.println("res=" + res);
	}
	
	public static void getResult(Sum sum) {
		int res1 = sum.add(3, 5);
		System.out.println("res1=" + res1);
	}
	
	@FunctionalInterface
	interface CumSum
	{
		int exec(int start, int end);
	}
	
	public static void getResult1(CumSum cs, int start, int end) {
		int res2 = cs.exec(start, end);
		System.out.println("res2=" + res2);
	}
		
}

