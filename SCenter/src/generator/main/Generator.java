package generator.main;

import java.util.Random;

public class Generator {
	private static String[] names = { "Jacob", "Tyler", "Lauren", "Sophia", "Alexander", "Alyssa", "David", "Grace",
			"Nicholas", "Sarah", "Ryan", "Alexis", "Anthony", "Elizabeth", "Christopher", "Joseph", "Samantha",
			"Samantha", "Ashley", "Daniel", "Isabella", "Andrew", "Abigail", "Hannah", "Ethan", "Olivia", "Matthew",
			"Madison", "Joshua", "Emma", "Michael", "Emily" };
	
	private static String[] last_name = {	"Mcadoo", "Seckman", "Shut", "Del", "Solarz", "Sabal", "Mark", "Dulan", "Kasper", 
			"Melodi", "Alosta", "Kenneth", "Schnabl", "Lamar", "Franken", "Mittie", "Tommy", "Young", "Aschim", "Milissa", 
			"Middlebrooks", "Marge", "Lavanchy", "Roman", "Halaby", "Rusaw", "Felicia", "Geerdes", "Soules", "Christie", "Leflore", 
			"Wendy", "Steffel", "Urbaez", "Yong", "Pattie"};
	
	private static Random gen = new Random();
	private static String[] mails = {"@mail.ru", "@gmail.com", "@ukr.net", "@hotline.com", "@telnet.com", "@gov.co.il", "@nesses.com"};

	
	private static String[] positionJob = {"manager", "technic", "support", "director"};
	private static String[] product = {"LG", "Samsung","WD","MAG","Sigma","Optiquest", "Nec", "Logitech", "A4","MicroLab", "Acer", "Asus", "HP"};
	private static String[] manufacturing = {"Monitor", "HDD", "Mouse", "Keyboard", "Laptop", "Power", "CDRom", "Sound"};
	private static String[] streets = { "Lenina", "Rothschild", "Yerushalayim", "Ben Gurion", "Allenby", "Dizengoff",
			"HaArbaa", "HaMasger", "HaYarkon", "Ibn Gabirol" };
	private static String[] cities = { "Haifa", "Tel Aviv", "Eilat", "Jerusalem", "Beer Sheva", "Rehovot" };
	
	

	public static String genPhoneNumber(int countDigit){
		StringBuffer res = new StringBuffer("0");
		for(int i=0; i<countDigit; i++){
			res.append(genInt(9));
		}
		return res.toString();
	}
	
	public static String genSerialNumber(int countDigit, String name){
		StringBuffer res = new StringBuffer("");
		res.append(name.charAt(0));
		for(int i=0; i<countDigit; i++){
			res.append(genIntChar(name));
		}
		return res.toString();
	}
	
	public static String genName(){
		return genFromArray(names);
	}
	
	public static String genLastName(){
		return genFromArray(last_name);
	}
	
	public static String genPosJob(){
		return genFromArray(positionJob);
	}	
	
	public static String genProduct(){
		return genFromArray(product);
	}

	public static String genEmail(String name, String name_last){
		return name.toLowerCase() + "_" + name_last.toLowerCase() +  genFromArray(mails);
	}
	
	public static String genAdress(){
		return genFromArray(cities) + ", " + genFromArray(streets) + " " + genInt(159);
	}	
	
	private static String genIntChar(String name) {
		char c[] = name.toCharArray();
		int num = genInt(8 + c.length);
		return num>9? Character.toString(c[num - 9]).toUpperCase() : Integer.toString(num);
	}

	public static int genInt(int max) {
		return max > 0 ? 1 + gen.nextInt(max) : 1 + gen.nextInt(255);
	}
	
	private static String genFromArray(String[] array){
		return array[gen.nextInt(array.length)];
	}

	public static String genCities() {
		return genFromArray(cities);
	}
	
	public static String genManufactur() {
		return genFromArray(manufacturing);
	}
}
