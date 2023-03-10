package chap15;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 * Stream 예제
 * 
 *   Collection 방식과 Stream 방식 비교
 */
public class StreamEx1 {
	public static void main(String[] args) { //(String ... args) 도 똑같음.
		//Arrays.aslist(String(Generic)...a) : (...)=>가변매개변수
		//              String 매개변수 0개 이상. 이라는 의미
		List<String> list = Arrays.asList("홍길동","김삿갓","이몽룡");
		System.out.println("iterator 방식");
		Iterator<String> it = list.iterator(); //반복자 어디서 배웠더라..? 찾아보기. 병렬처리는 또 뭐더라..ㅋ 복습 좀 하셈. chap12
		while(it.hasNext()) System.out.print(it.next() + ",");
		System.out.println();
		
		System.out.println("Stream 방식");
		list.stream().forEach(name->System.out.print(name+","));
		System.out.println();
		
		Stream<String> st = list.stream();
		st.forEach(name -> System.out.print(name+",")); //이렇게도 쓸 수 있다~
	}
}
