import java.util.Scanner;

public class Demo {

public static void main(String[] args) {
		
		
		Scanner kb = new Scanner(System.in);
		Polinom sinif = new Polinom();
		
		
		System.out.print("1. Polinom :");
		String pol1 = kb.next()+"+";
		
		if(pol1.charAt(0) != '-') pol1 = "+"+pol1;
		
		System.out.println("");
		System.out.print("2. Polinom :");
		String pol2 = kb.next() +"+";
		if(pol2.charAt(0) != '-') pol2 = "+"+pol2;

		String temp1= pol1;
		String temp2 = pol2;
		
		String sonuc ="";
		for(int i = 0 ; temp1.length()>1 ; i++) {
			for(int j = 0 ; temp2.length() >1 ; j++) {
				sonuc += sinif.carp(sinif.parcala(temp1),sinif.parcala(temp2));
				int a = sinif.parcala(temp2).length();

			temp2 = temp2.substring(a);
			}
			
			temp2=pol2;
			int b = sinif.parcala(temp1).length();
			temp1 = temp1.substring(b);
		}
		
		sonuc = sinif.sirala(sonuc)+"+";
		String gec = sonuc;
		
		String polinom ="";

		for(int i = 0 ; sonuc.length() > 1 ; i++ ) {
			int k =sinif.parcala(sonuc).length();
			
			String s1 = sinif.parcala(sonuc);
			String s2 =sinif.parcala(sonuc.substring(k));
			String s3 = sinif.birlestir(s1,s2);

			polinom += s3;
			int k2 = sinif.parcala(sonuc.substring(k+1)).length();

			if(!s3.equals(s1))
				sonuc = sonuc.substring(k+k2);
			else
			sonuc = sonuc.substring(k);

		}
		sonuc = polinom;
		
	sonuc = sonuc.replaceAll("-1x", "-x");

	sonuc = sonuc.replaceAll("\\+1x" , "+x");

	sonuc = sonuc.replace("x^0", "");

	sonuc = sonuc.replace("x^1+", "x+");
	sonuc = sonuc.replace("x^1-", "x-");


	
	while(sonuc.length() >= 1 &&sonuc.charAt(0) == '+') sonuc = sonuc.substring(1);
	
	while(sonuc.charAt(sonuc.length()-1) == '+') sonuc = sonuc.substring(0, sonuc.length()-1);
		
		System.out.println(sonuc);
		
			
	}
}
