package doneByAnything;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fgj {
	public static void main(String[] args) {
		XYZ obj = new XYZ();
		String date1 = "12/16/2018";
		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate  d1 = LocalDate.parse(date1, df);
		obj.setLd(d1);
		System.out.println(obj.getLd());
	}
}
