package chap15;

import java.util.Random;
/*
 * Random().ints(개수, 시작값, 종료값+1) -> IntStream으로 전달.
 * Random().longs(개수, 시작값, 종료값+1) ->LongStream으로 전달.
 * Random().doubles(개수) -> DoubleStream(0<=x<1.0)
 */
public class RandomToStreamEx1 {
	public static void main(String[] args) {
		System.out.println("int 형 난수 3개를 가진 스트림 생성");
		new Random().ints(3).forEach(s->System.out.print(s+",")); //정수값 전체범위에서 난수를 가져옴 ex. -924407162
		System.out.println("\n0~2사이의 int 형 난수 10개를 가진 스트림 생성");
		new Random().ints(10,0,3).forEach(s->System.out.print(s+","));
		System.out.println("\n1~100사이의 int 형 난수 10개를 가진 스트림 생성");
		new Random().ints(10,1,101).forEach(s->System.out.print(s+","));
		
		System.out.println("\nlong 형 난수 3개를 가진 스트림 생성");
		new Random().longs(3).forEach(s->System.out.print(s+","));
		System.out.println("\nlong 형 난수 3개를 가진 스트림 생성");
		new Random().longs(3,0,10).forEach(s->System.out.print(s+","));
		
		System.out.println("\nchar 형 난수 3개를 가진 스트림 생성");
		new Random().ints(3,'A','Z'+1).forEach(s->System.out.print((char)s+","));
		
		System.out.println("\ndouble 형 난수 3개를 가진 스트림 생성");
		new Random().doubles(3).forEach(s->System.out.print(s+","));
	}
}
