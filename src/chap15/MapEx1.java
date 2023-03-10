package chap15;

import java.util.Arrays;
import java.util.List;

/*
 * mapXXX 메서드 : 스트림의 요소를 치환할 수 있는 메서드
 * mapToInt() : Stream => IntStream
 */
public class MapEx1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동전", "춘향전","구운몽","전우치전");
		list.stream().mapToInt(String::length).forEach(s->System.out.print(s+",")); //여기서 length는 메서드(함수)
//		list.stream().mapToInt(s->s.length).forEach(s->System.out.print(s+",")); 위에랑 똑같음.
		
		List<Student> list2 = Arrays.asList(new Student("홍길동",80,95), new Student("이몽룡",70,75), new Student("김삿갓",75,70));
		System.out.println("\n영어 점수 목록: ");
		list2.stream().mapToInt(s-> s.getEng()).forEach(s-> System.out.print(s+","));
//      list2.stream().mapToInt(Student::getEng).forEach(s->System.out.print(s+",")); 이 방법은 왜 getEng() 괄호 안쓰지? 메서드 이름만 쓰나? ㅇㅇ
		
		System.out.println("\n수학 점수 목록: ");
		list2.stream().mapToInt(Student::getMath).forEach(s->System.out.print(s+","));
		
		System.out.println("\n합계 점수 목록: ");
		list2.stream().mapToInt(s->s.getEng()+s.getMath()).forEach(s->System.out.print(s+","));
//		list2.stream().mapToInt(Student::getEng+getMath).forEach(s->System.out.print(s+",")); //틀림. 메서드참조 방식으로는 쓸 수 없음.
		//그러면 메서드참조방식은 매개변수 있는 메서드는 사용 못하나? ㅇㅇ
		//매개변수 있는 메서드는 어떻게 써야되지? 메서드 참조방식으로는 못쓰고, forEach에서 print메서드에 (s+",") 쓴 것처럼 쓰면 됨.
		
		System.out.print("\n수학 점수 합계: ");
		System.out.println(list2.stream().mapToInt(s->s.getMath()).sum());
		System.out.print("수학 점수 평균: ");
		System.out.println(list2.stream().mapToInt(s->s.getMath()).average().getAsDouble());
		System.out.print("영어 점수 합계: ");
		System.out.println(list2.stream().mapToInt(s->s.getEng()).sum());
		System.out.print("영어 점수 평균: ");
		System.out.println(list2.stream().mapToInt(s->s.getEng()).average().getAsDouble());
		System.out.print("점수 합계: ");
		System.out.println(list2.stream().mapToInt(s->s.getMath()+s.getEng()).sum());
		System.out.print("점수 평균: ");
		System.out.println(list2.stream()
				                .mapToInt(s->s.getMath()+s.getEng())
				                .average()
				                .getAsDouble()); //이런식으로 많이 써서 어려워 보임. 그냥 한줄이라고 생각하고 읽자
		
	}
}
