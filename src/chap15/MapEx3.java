package chap15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/*
 * product.txt 파일 분석하기
 */
class Car {
	private int month;
	private int con;
	private String car;
	private int qty;
	private String remark;
	public Car() {}
	public Car(int month, int con, String car, int qty, String remark) {
		this.month=month;
		this.con=con;
		this.car=car;
		this.qty=qty;
		this.remark=remark;
	}
	public int getMonth() {return month;}
	public int getCon() {return con;}
	public String getCar() {return car;}
	public int getQty() {return qty;}
	public String getRemark() {return remark;}
	@Override
	public String toString() {
		return "[month=" + month + ", con=" + con + ", car=" + car + ", qty=" + qty + ", remark=" + remark + "]";
	}	
}
public class MapEx3 {
	public static void main(String[] args) throws IOException {
		//1.file의 내용을 Stream으로 생성
		BufferedReader br = new BufferedReader(new FileReader("product.txt"));
		//f : Stream<String> => Stream<Car>
		Function<String,Car> f = s-> { //갑자기 어떤 String을 매개변수로..? 매개변수의 자료형. 밑에 map(f)에서 가져오나? 한줄씩 읽은 stream을?
			//s : 4,3,K9,몰라요
			String[] str = s.split(",");
			String temp = "";
			try {
				temp=str[4]; //remark가 비어있는 경우 ?? str[4]=temp 아닌가??
			} catch(ArrayIndexOutOfBoundsException e) {
				temp="";
			}
			return new Car(Integer.parseInt(str[0]),Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]),temp);};
			
		//br.lines() => 자동으로 한줄씩 stream으로 들어감.
	    //map(f) : Stream<String> => Stream<Car>
		br.lines().map(f).filter(c->c.getCar().equals("K9"))
		.forEach(s->System.out.println(s));
		

	}
}
