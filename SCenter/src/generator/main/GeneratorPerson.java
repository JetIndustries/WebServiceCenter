package generator.main;

import java.util.Random;

public class GeneratorPerson {
	private static String[] names = { "Jacob", "Tyler", "Lauren", "Sophia", "Alexander", "Alyssa", "David", "Grace",
			"Nicholas", "Sarah", "Ryan", "Alexis", "Anthony", "Elizabeth", "Christopher", "Joseph", "Samantha",
			"Samantha", "Ashley", "Daniel", "Isabella", "Andrew", "Abigail", "Hannah", "Ethan", "Olivia", "Matthew",
			"Madison", "Joshua", "Emma", "Michael", "Emily" };
	
	private static String[] last_name = {	"Mcadoo", "Seckman", "Shut", "Del", "Solarz", "Sabal", "Mark", "Dulan", "Kasper", 
			"Melodi", "Alosta", "Kenneth", "Schnabl", "Lamar", "Franken", "Mittie", "Tommy", "Young", "Aschim", "Milissa", 
			"Middlebrooks", "Marge", "Lavanchy", "Roman", "Halaby", "Rusaw", "Felicia", "Geerdes", "Soules", "Christie", "Leflore", 
			"Wendy", "Steffel", "Urbaez", "Yong", "Pattie"};
	
	private static Random gen = new Random();
	
	private static String[] positionJob = {"manager", "technic", "support", "director"};
	private static String[] product = {"LG", "Samsung","WD","MAG","Sigma","Optiquest", "Nec", "Logitech", "A4","MicroLab", "Acer", "Asus", "HP"};
	
	
	

	public static String getPhoneNumber(int countDigit){
		StringBuffer res = new StringBuffer("0");
		for(int i=0; i<countDigit; i++){
			res.append(genInt(9));
		}
		return res.toString();
	}
	
	public static String getSerialNumber(int countDigit, String name){
		StringBuffer res = new StringBuffer("");
		res.append(name.charAt(0));
		for(int i=0; i<countDigit; i++){
			res.append(genInt(9));
		}
		return res.toString();
	}
	
	

	private String genFromArray(String[] array) {
		return array != null ? array[gen.nextInt(array.length)] : null;
	}

	private static int genInt(int max) {
		return max > 0 ? 1 + gen.nextInt(max) : 1 + gen.nextInt(255);
	}
}
