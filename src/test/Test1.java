package test;

import java.util.Random;

/*
 * 1부터 100까지의 정수형 임의의 난수 100개를 저장하고,
 * 그중 소수인 숫자의 목록과, 갯수를 출력하기
 * Random 클래스를 이용
 */
public class Test1 {
	public static void main(String[] args) {
		new Random(100).ints(100,1,101).filter(t-> {
			int cnt=0; int scnt=0;
			boolean b =false;
			for(int i=1; i<=t; i++) {
				if(t%i==0) {
					cnt++;	
				} 
			}	
			if(cnt==2) {
				b=true;
				cnt=0;
			}
			if(b==true) return true;
			else if(t==1) return false;
			else return false;
		}).peek(s->System.out.print(s + ",")).count();
		
		System.out.println();
//		new Random(100).ints(10,1,10).forEach(s->System.out.print(s+",")); //확인용
		
		//소수 알고리즘
//		for(int i=2; i<a; i++) {
//			if(a%i==0) cnt++;
//		}
//		if(cnt>0) return false;
//		else return true;
	}
}