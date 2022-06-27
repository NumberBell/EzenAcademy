package com.ezen.test;

public class Hello {

	//함수형 인터페이스 선언하고 사용하기
	
	@FunctionalInterface
	public interface Sum {
		public int add(int a, int b);
	}
	
	public static void main(String[] args) {
		//일반클래스
		//익명클래스
		//Lambda식
		
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
	
		//함수형 인터페이스 선언하고 사용하기
		//메소드가 하나뿐이라 add메소드 오버라이드 됨
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

