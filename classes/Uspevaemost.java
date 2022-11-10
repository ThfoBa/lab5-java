package classes;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Uspevaemost {
	
	//конструктор класса со всеми параметрами
	public Uspevaemost(short srball, int minimum, int normal, int high, Napravlenie nam){
	    if((srball >= 0)&&(srball <= 100))
		this.srball = srball;
	    else{
		System.out.println("Указано недопустимое значение srball.");
           	this.srball = 0;
	    }
	    if((minimum > 0)&&(minimum < 100))
		this.minimum = minimum;
	    else{
		System.out.println("Указано недопустимое значение minimum.");
           	this.minimum = 0;
	    }
	    if((normal > 0)&&(normal < 100)&&(normal > minimum))
		this.normal = normal;
	    else{
		System.out.println("Указано недопустимое значение normal.");
           	this.normal = 0;
	    }
	    if((high > 0)&&(high <= 100)&&(high > normal))
		this.high = high;
	    else{
		System.out.println("Указано недопустимое значение high.");
           	this.high = 0;
	    }
	    na = nam;
	}
	
	//конструктор класса с одним параметром
	public Uspevaemost(short allfields){
		srball = allfields;
		minimum = 30;
		normal = 70;
		high = 100;
		na = new Napravlenie(allfields);
	}
	
	//конструктор класса без параметров
	public Uspevaemost(){
		srball = 0;
		minimum = 30;
		normal = 70;
		high = 100;
		na = new Napravlenie();
	}
	
	//метод ввода
	public void input(){
		Scanner inp = new Scanner(System.in);
		System.out.println("Введите средний балл студента: ");
		srball = inp.nextShort();
	}

	//метод подсчета размера стипендии
	public int getstip()
	{
		int stip = 0;
		if (srball<=minimum)
			stip = 1000;
		else if ((srball>minimum)&&(srball<=normal))
			stip = 4000;
		else if ((srball>normal)&&(srball<=high))
			stip = 7000;
		return stip;
	}
	
	public void bonuss(){
		if ((na.elite) == 1)
			System.out.println("Бонус не положен");
		else 
			System.out.println("Положен бонус в размере 2000");
	}

	//метод вывода
	public void output(){
		if (srball<=minimum)
			System.out.println("Успеваемость: Низкая");
		else if ((srball>minimum)&&(srball<=normal))
			System.out.println("Успеваемость: Нормальная");
		else if ((srball>normal)&&(srball<=high))
			System.out.println("Успеваемость: Высокая");
		System.out.println("Средний балл студента: " + srball);
	}

	//метод записи в файл
	public void tofile(File file){
        	try {
            		checkfilename cf= new checkfilename();
            		if(!cf.checkfileextension(file.getName()))
                		throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            		FileWriter pw = new FileWriter(file, true);
            		pw.write(srball + "\n");
            		pw.write(minimum + "\n");
            		pw.write(normal + "\n");
			pw.write(high + "\n");
            		pw.close();
        	}
        	catch(Exception e){
            		System.out.println(e);
        	}
    	}
	
	//метод записи из файла
	public void getfromfile(File file, Scanner sc){
        	try {
            		checkfilename cf= new checkfilename();
            		if(!cf.checkfileextension(file.getName()))
                		throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            		srball = Short.parseShort(sc.nextLine());
				minimum = Integer.parseInt(sc.nextLine());
            		normal = Integer.parseInt(sc.nextLine());
            		high = Integer.parseInt(sc.nextLine());
        	}
        	catch(Exception e){
            		System.out.println(e);
        	}
    	}
	
	//поля класса
	private short srball; //средний балл студента по всем предметам 
	private int minimum; //порог, меньше которого успеваемость считается низкой
	private int normal; //порог, меньше которого успеваемость считается нормальной
	private int high; //порог, меньше которого успеваемость считается высокой
	private Napravlenie na;
}