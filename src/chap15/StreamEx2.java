package chap15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * 
 */
class Student {
	private String name;
	private int eng;
	private int math;
	Student(String name, int eng, int math) {
		this.name=name;
		this.eng=eng;
		this.math=math;
	}
	public String getName() {
		return name;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	@Override
	public String toString() {
		return "name=" + name + ", eng=" + eng + ", math=" + math;
	}
}
public class StreamEx2 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동", 60, 70), new Student("김삿갓",65,70), 
				                           new Student("이몽룡", 80, 75), new Student("임꺽정", 85, 65));
        Stream<Student> st = list.stream();
        //s : Student객체
        //forEach -> Consumer: 매개변수 o, 리턴값 x
        st.forEach(s-> { //forEach도 반복자임.
        	System.out.print(s);
        	int sum = s.getEng() + s.getMath();
        	double avg = sum/2.0;
        	System.out.printf(", 총점=%-4d, 평균=%.2f\n",sum,avg);
        });
        System.out.println("==============");
//      st.forEach(s->System.out.println("이름:"+s.getName())); //오류발생. Stream은 일회용. stream has already been operated or closed.
        //System.out::println : 메서드 참조
        list.stream().forEach(System.out::println); //이렇게 해야 stream 다시 읽을 수 있음.
        System.out.println("==============");
        
        //mapToInt : 정수형만 뽑을거야(mapping 시킬거야) -> IntStream이 됨
        //Student :: getMath -> Student 객체에서 getMath 메서드의 Int만 뽑아.
        System.out.println("수학점수총점: " + list.stream().mapToInt(Student::getMath).sum());
        System.out.println("영어점수총점: " + list.stream().mapToInt(Student::getEng).sum());
        System.out.println("학생의 인원수: " + list.stream().count());
	}
}
