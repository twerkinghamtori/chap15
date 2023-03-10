package chap15;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * 1. 1부터 100사이의 임의의 수 100개를 IntStream에 저장하고 저장된 수의 총합, 평균, 짝수 평군, 홀수 평균, 짝수개수, 홀수개수
 */
public class Exam1 {
	public static void main(String[] args) {
		int[] nums = new int[100];
		for(int i=0; i<nums.length; i++) {
			nums[i]=(int)(Math.random()*100+1);
//			System.out.print(nums[i] + ",");
		}
		IntStream is = Arrays.stream(nums);
		System.out.println();
		System.out.println("총합: " + is.sum());
		System.out.println("평균: " + IntStream.of(nums).average().getAsDouble());
		System.out.println("짝수 평균: " + IntStream.of(nums).filter(i->(i%2==0)).average().getAsDouble());
		System.out.println("홀수 평균: " + IntStream.of(nums).filter(i->(i%2!=0)).average().getAsDouble());
		System.out.println("짝수 개수: " + IntStream.of(nums).filter(i->(i%2==0)).count());
		System.out.println("홀수 개수: " + IntStream.of(nums).filter(i->(i%2!=0)).count());
		//distinct() : 중복된 데이터 제거. 한개만 남김. DB에서도 썼음.
		System.out.println("중복되지 않은 난수의 개수: " + Arrays.stream(nums).distinct().count());
		System.out.println("중복되지 않은 짝수 평균: " + IntStream.of(nums).distinct().filter(i->(i%2==0)).average().getAsDouble());
		System.out.println("중복되지 않은 홀수 평균: " + IntStream.of(nums).distinct().filter(i->(i%2!=0)).average().getAsDouble());
		System.out.println("중복되지 않은 짝수 개수: " + IntStream.of(nums).distinct().filter(i->(i%2==0)).count());
		System.out.println("중복되지 않은 홀수 개수: " + IntStream.of(nums).distinct().filter(i->(i%2!=0)).count());
	}
}
