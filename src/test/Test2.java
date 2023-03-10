package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
  화면에서 정수를 입력받아 
  입력된 숫자까지의 합, 짝수의 합, 홀수의 합을 구하는 프로그램 작성하기
 IntStream.rangeClosed
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println("입력된 숫자까지의 합: " + IntStream.rangeClosed(1, num).sum());
		System.out.println("입력된 숫자까지 짝수의 합: " + IntStream.rangeClosed(1, num).filter(t->t%2==0).sum());
		System.out.println("입력된 숫자까지의 합: " + IntStream.rangeClosed(1, num).filter(t->t%2!=0).sum());
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("입렵된 숫자까지의 합: " + br.lines().mapToInt(t->Integer.parseInt(t)).sum());
	}
}