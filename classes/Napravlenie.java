package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Napravlenie {
	//конструктор со всеми параметрами
	public Napravlenie(String nazvanie, short elite, short formstudy){
		this.nazvanie = nazvanie;
		if((elite == 1)||(elite == 2))
			this.elite = elite;
		else{
			System.out.println("Указано недопустимое значение elite.");
			this.elite = 1;
		}
		if((formstudy == 1)||(formstudy == 2))
			this.formstudy = formstudy;
		else{
			System.out.println("Указано недопустимое значение formstudy.");
			this.formstudy = 1;
		}
		
	}
	
	//конструктор с одним параметром
	public Napravlenie(short allfields){
		nazvanie = Short.toString(allfields);
		elite = allfields;
		formstudy = allfields;
	}
	
	//конструктор без параметров
	public Napravlenie(){
		nazvanie = "";
		elite = 1;
		formstudy = 1;
	}
	
	//метод ввода класса
	public void input(){
		String nazvanie;
		short elite, formstudy;
		Scanner inp = new Scanner(System.in, "Cp866");
		System.out.println("Введите название вашего направления: ");
		nazvanie = inp.nextLine();
		System.out.println("Введите класс престижности вашего направления (1-обычная, 2-высокая): ");
		elite = inp.nextShort();
		System.out.println("Введите форму обучения (1-платное, 2-бюджет): ");
		formstudy = inp.nextShort();
		Napravlenie n = new Napravlenie(nazvanie, elite, formstudy);
		this.set(n);
	}

	/** Метод установки значений **/
    	public void set(Napravlenie n){
        	this.nazvanie = n.nazvanie;
        	this.elite = n.elite;
        	this.formstudy = n.formstudy;
    	}
	
	//метод вывода класса
	public void output(){
		System.out.println("Направление: " + nazvanie);
		if (elite == 1)
			System.out.println("Престижность направления: Обычная");
		else
			System.out.println("Престижность направления: Высокая");
		if (formstudy == 1)
			System.out.println("Форма обучения: Платное");
		else 
			System.out.println("Форма обучения: Бюджет");
	}

	// Метод для редактирования названия направления
    	public void editnazvanie(String nazvanie, String add){
        	StringBuilder sb = new StringBuilder();
        	String[] words = this.nazvanie.split(" ");
        	this.nazvanie = "";
        	for(String word : words) {
            		if(word.equals(nazvanie)) {
                		sb.append(add);
                		sb.append(" ");
            		}
            		sb.append(word);
            		sb.append(" ");
        	}
        	this.nazvanie = sb.toString();
    	}

	//метод записи в файл
	public void tofile(File file){
        	try {
            		checkfilename cf= new checkfilename();
            		if(!cf.checkfileextension(file.getName()))
                		throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            		FileWriter pw = new FileWriter(file, true);
            		pw.write(nazvanie + "\n");
            		pw.write(elite + "\n");
			pw.write(formstudy + "\n");
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
            		nazvanie = sc.nextLine();
            		elite = Short.parseShort(sc.nextLine());
			formstudy = Short.parseShort(sc.nextLine());
            		
        	}
        	catch(Exception e){
            		System.out.println(e);
        	}
    	}

	
		
	
	//поля класса
	private String nazvanie; //название направления
	protected short elite; //класс престижности направления (типа обычное и престижное)
	private short formstudy; //форма обучения
}