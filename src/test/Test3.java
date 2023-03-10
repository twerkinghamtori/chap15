package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

import chap15.GeneratorProductFile;

/*
 * product.txt 파일을 읽어 6월달,그랜저 판매 수량을 출력하기
 [결과]
[month=6, con=2, car=그랜저, qty=1, remark=]
[month=6, con=2, car=그랜저, qty=2, remark=]
[month=6, con=2, car=그랜저, qty=1, remark=]
[month=6, con=2, car=그랜저, qty=2, remark=]
[month=6, con=2, car=그랜저, qty=4, remark=]
[month=6, con=2, car=그랜저, qty=5, remark=]
[month=6, con=2, car=그랜저, qty=5, remark=]
합계:20
 */
class Car {
	private int month;
	private int con;
	private String car;
	private int qty;
	private String remark;
	public Car() {}
	public Car(int month,int con,String car,int qty,String remark) {
		this.month = month;
		this.con = con;
		this.car = car;
		this.qty = qty;
		this.remark = remark;
	}
	public int getMonth() {return month;}
	public int getCon() {return con;}
	public String getCar() {return car;}
	public int getQty() {return qty;}
	public String getRemark() {return remark;}
	@Override
	public String toString() {
		return "[month=" + month + ", con=" + con 
				+ ", car=" + car + ", qty=" + qty 
				+ ", remark=" + remark + "]";
	}
}

public class Test3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("product.txt"));
		Function<String,Car> f = s-> {
			String[] str = s.split(",");
			String temp = "";
			try {
				temp=str[4]; //remark가 비어있는 경우
			} catch(ArrayIndexOutOfBoundsException e) {
				temp="";
			}
			return new Car(Integer.parseInt(str[0]),Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]),temp);
		};
		int sum = br.lines().map(f).filter(t->t.getCar().equals("그랜저")&&t.getMonth()==6).peek(s->System.out.println(s+",")).mapToInt(t->t.getQty()).sum();
		System.out.println("합계: " + sum);
	}
}