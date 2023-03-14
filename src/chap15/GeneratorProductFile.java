package chap15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class GeneratorProductFile {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = null;
		String[] cars = {"아반테","그랜저","SM7","BMW","벤츠","K9"};
		String[] remarks = {"몰라요","싫어요","그냥그래요","좋아요"}; 
		int limit=0, con=0;
		fos = new FileOutputStream("product.txt");
		PrintStream ps = new PrintStream(fos);
		while(limit++ < 100) {
			ps.print((int)(Math.random()*12+1) + ","); //월
			con = (int)(Math.random()*3+1); //1.생산, 2.판매, 3.반품
			ps.print(con + ",");
			ps.print(cars[(int)(Math.random()*cars.length)] + ",");
			ps.print((int)(Math.random()*5+1)); //판매수량
			if(con==3) {
				ps.print(",");
				ps.print(remarks[(int)(Math.random()*remarks.length)]);
			}
			ps.println();
		}
		ps.flush();
		ps.close();
	}
}
