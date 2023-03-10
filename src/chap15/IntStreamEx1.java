package chap15;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * IntStream 예제 : int형(정수형)값들의 모임
 */
public class IntStreamEx1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println("Arrays.stream() : 배열을 이용하여 IntStream 생성");
		IntStream is1 = Arrays.stream(arr); //IntStream은 당연히 int형만 들어가니까 제너릭 안붙이겠지?
		is1.forEach(System.out::print); //IntStream -> LongStream 자동형변환 되나?
		System.out.println();
		
		System.out.println("IntStream.of() : 배열을 이용햐여 IntStream 생성");
		IntStream.of(arr).forEach(s->System.out.print(s + " "));
		System.out.println();
		
		System.out.println("IntStream.range(1,11)메서드를 이용하여 IntStream 생성");
		IntStream.range(1,11).forEach(s->System.out.print(s));
		System.out.println();
		
		System.out.println("IntStream.rangeClosed(1,10)메서드를 이용하여 IntStream 생성");
		IntStream.rangeClosed(1, 10).forEach(s->System.out.print(s));
		System.out.println();
		
		System.out.println("IntStream을 이용하여 1~100까지 합을 구하기");
		System.out.println(IntStream.rangeClosed(1,100).sum());
		
		System.out.println("IntStream을 이용하여 1~100까지 짝수합을 구하기");
		System.out.println(IntStream.rangeClosed(1,100).filter(i->(i%2==0)).sum());
		
		System.out.println("IntStream을 이용하여 1~100까지 홀수의 개수 구하기");
		System.out.println(IntStream.rangeClosed(1, 100).filter(i->(i%2!=0)).count());
		
		System.out.println("IntStream을 이용하여 1~100까지 홀수의 평균 구하기");
		System.out.println(IntStream.rangeClosed(1, 100).filter(i->(i%2!=0)).average().getAsDouble()); 
		//average() 리턴타입이 OptionalDouble이라서 Double형이 아닌 객체로 리턴되기 때문에 getAsDouble로
		//그냥 average() 쓰면 OptionalDouble[50.0]으로 나오는데 Double객체로 주느거라고..?
	}
}
