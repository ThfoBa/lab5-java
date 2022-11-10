import classes.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		byte years = 10;
		byte akadem = 1;
		Experience exp3 = new Experience(years, akadem);
		String str = "Приборостроение";
		byte elit = 1;
		byte form = 2;
		Napravlenie nap3 = new Napravlenie(str, elit, form);
		String str3 = "Приборостроение и техника";
		Napravlenie n3 = new Napravlenie(str3, elit, form);
		byte bal1 = 45, bal2 = 20;
		Uspevaemost us3 = new Uspevaemost(bal2, 30, 70, 100, nap3);
		Student[] arr = new Student[3];
		Student[][] arr1 = new Student[2][2];
		int i,j;
		try{
			File file = new File("test.txt");
			for(i=0;i<3;i++) {
				System.out.println("arr["+i+"]");
				arr[i] = new Student();
				arr[i].tofile(file);
				arr[i].output();
			}
		}
		catch(Exception e){
            		System.out.println(e);
       		}
		try {
			File file = new File("test.txt");
			Scanner sc = new Scanner(file);
			for (i = 0; i < 2; i++) {
                		for (j = 0; j < 2; j++) {
                    			System.out.println("arr1[" + i + "]" + "[" + j + "]");
                    			arr1[i][j] = new Student();
                    			arr1[i][j].getfromfile(file, sc);
                    			arr1[i][j].output();
                		}
            		}
            		sc.close();
        	}
        	catch(Exception e1){
            		System.out.println(e1);
        	}
    	
	}
}