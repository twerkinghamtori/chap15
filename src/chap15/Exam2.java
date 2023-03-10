package chap15;

import java.util.Random;
import java.util.stream.IntStream;

/*
 * Exam1번 문제를 Random() 으로 풀어보기
 */
public class Exam2 {
	public static void main(String[] args) {
		IntStream is = new Random(1000).ints(100,1,101);
		System.out.println("총합: " + is.sum());
		System.out.println("평균: " + new Random(1000).ints(100,1,101).average().getAsDouble());
		System.out.println("짝수 평균: " + new Random(1000).ints(100,1,101).filter(i->(i%2==0)).average().getAsDouble());
		System.out.println("홀수 평균: " + new Random(1000).ints(100,1,101).filter(i->(i%2!=0)).average().getAsDouble());
		System.out.println("짝수 개수: " + new Random(1000).ints(100,1,101).filter(i->(i%2==0)).count());
		System.out.println("홀수 개수: " + new Random(1000).ints(100,1,101).filter(i->(i%2!=0)).count());

	}
}
