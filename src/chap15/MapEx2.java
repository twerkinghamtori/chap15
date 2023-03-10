package chap15;

import java.util.Arrays;
import java.util.List;

/*
 * 
 */
public class MapEx2 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동",80,95), new Student("이몽룡",70,75), new Student("김삿갓",75,70));
		//영어 점수 목록과 합계 출력하기
//		list.stream().mapToInt(Student::getEng).forEach(s->System.out.print(s+",").sum()); 오류발생. forEach는 대표적인 최종처리. 뒤에 뭐가 더 못붙음.
		int sum = list.stream().mapToInt(Student::getEng).peek(s->System.out.print(s+",")).sum();
		//list->stream->IntStream->print->sum()
		System.out.println("\n합계: " +sum);
		System.out.println("peek==============");
		//peek(중간처리)는 다음에 뭐가 있어야 실행됨. 출력안됨. => 최종 출력을 위해서는 forEach(최종처리)를 이용해야함
		//peek의 리턴타입은 IntStream
		//peek : Stack 과 Queue에서도 나왔음. 조회만 하는거라서 Stack과 Queue에 변화 없는 걸로.
		list.stream().mapToInt(Student::getEng).peek(s->System.out.print(s+","));
		System.out.println("forEach===========");
		list.stream().mapToInt(Student::getEng).forEach(s->System.out.print(s+","));
		
		//목록, 합계 따로
		System.out.print("\n수학점수 목록: ");
		int mathsum = list.stream().mapToInt(Student::getMath).peek(s->System.out.print(s+",")).sum();
		//람다식을 쓸 수 있는건 getEng메서드로 판단하는게 아니라 mapToInt가 ToIntFunction FunctionalInterface여서 그런건지? 
       //mapToInt는 Stream 인터페이스의 메서드 -> 그럼 mapToInt의 메서드의 매개변수가 ToIntFunction(Functional Interface) 인터페이스????
		System.out.print(" 수학점수 합계: " +mathsum + "\n");
		//목록, 합계 한번에
		System.out.println(list.stream().mapToInt(Student::getMath).peek(s->System.out.print(s+",")).sum());
		
		System.out.print("\n합계 점수 목록: ");
		//mapToInt에서 s = Student의 s
		//peek에서 s = Student.getMath()+Student.getEng() <= 앞에 mapToInt() 때문에 s가 바뀐거임(연쇄적으로)
		int totalsum = list.stream().mapToInt(s->s.getMath()+s.getEng()).peek(s->System.out.print(s+",")).sum();
		System.out.println(" 전체합계: " + totalsum);
		
	}
}
