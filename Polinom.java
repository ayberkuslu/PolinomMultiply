import java.util.Scanner;

public class Polinom {
		
	public  int parse( String string ){
	    int i = 0;
	    int num = 0;
	    boolean isNeg = false;
	    if (string.charAt(0) == '-') {
	        isNeg = true;
	        i = 1;
	    }
	    if(string.charAt(0) == '+') i = 1;
	    
	    while( i < string.length()) {
	        num *= 10;
	        num += string.charAt(i++) - '0'; 
	    }
	    if (isNeg)
	        num = -num;
	    
	   // System.out.println("Parse : " + string+"  : " + num + "");
	    return num;
	}
	
	public  String parcala(String s) {

	int pos =0;
	if(s.length() ==0 ) return "";
	if(s.charAt(0) != '-' && s.charAt(0) != '+') s = "+"+s;
	
	
		for(int i = 1 ; i < s.length() ; i++) {
			if(s.charAt(i) == '+' || s.charAt(i) == '-') { pos = i; 
			break;
			}
		}

		return s.substring(0, pos);
	}
	
	public  String carp(String pol1,String pol2) {
		

		int isaret = 1;
		if(pol1.length() == 0 || pol2.length() == 0 ) return "";
		if(pol1.charAt(0) != pol2.charAt(0)) isaret = -1;
		
		if(pol1.charAt(0) == '+' && pol1.charAt(1) == 'x') pol1 =  	pol1.charAt(0)+ "1" + pol1.substring(1);
		else if(pol1.charAt(0) == '-' && pol1.charAt(1) == 'x') pol1 = pol1.charAt(0)+ "1" + pol1.substring(1);

		if(pol2.charAt(0) == '+' && pol2.charAt(1) == 'x') pol2 = 	pol2.charAt(0)+ "1" + pol2.substring(1);
		else if(pol2.charAt(0) == '-' && pol2.charAt(1) == 'x') pol2 = 	pol2.charAt(0)+ "1" + pol2.substring(1);
		
		if(pol1.charAt(pol1.length()-1) == 'x') pol1= pol1+"^1";
		if(pol2.charAt(pol2.length()-1) == 'x') pol2= pol2+"^1";

		if(pol1.indexOf("x^") == -1) pol1= pol1+"x^0";
		if(pol2.indexOf("x^") == -1) pol2= pol2+"x^0";
		

		
		String carpan1 = pol1.substring(1, pol1.indexOf("x^"));
		String carpan2 = pol2.substring(1, pol2.indexOf("x^"));
		
		int sayi1= parse(carpan1);
		int sayi2 = parse(carpan2);
		
	 int sonucCarpan = sayi1*sayi2*isaret;
	 	
		String tepe1 = pol1.substring(pol1.indexOf("x^")+2);
		String tepe2 = pol2.substring(pol2.indexOf("x^")+2);
		
		
		int us1 = parse(tepe1);
		int us2= parse(tepe2);
		
		String son ="";
		if(isaret >0 ) son = "+" + sonucCarpan + "x^"+ (us1+us2);
		else son = sonucCarpan+"x^"+(us1+us2);
		
		return son;
	}
	
	
	
	public  String sirala(String s) {
		
		String s2 = s;
	String sonuc = "";
	
	while(s2.length()>1) {
	
	String ust="";
	String maxUst = "-1";
	
		for(int i = 0 ; s.length()>0 ;i++) {
			int k = s.indexOf("x^");
			int j = k+2;
			while(s.length() > j &&k >-1 &&s.charAt(j) != '+' && s.charAt(j) != '-' ) {
				ust += s.charAt(j);
				j++;
			}

			if(ust.length()>0 &&parse(ust) > parse(maxUst)) maxUst = ust;
			
			else if(ust.length()>0 && parse(ust) == parse(maxUst)) {
				
							
				
			}
			s = s.substring(j);
			ust = "";

				
				
			
		}
		int yer =s2.indexOf("x^"+maxUst);
		for(int i = yer; i>-1 ;i--) {
			if(s2.charAt(i) == '+' || s2.charAt(i) == '-') {
				sonuc += s2.substring(i,yer)+"x^"+maxUst;
				s2= s2.replace(s2.substring(i,yer)+"x^"+maxUst, "");
				break;
			}
		}
		
		s = s2;

	}
		
		
		
		
		return sonuc;
	}
	
	public  String birlestir(String pol1, String pol2) {

		if(pol2.length() == 0) return pol1;

		int ilk1 = pol1.indexOf("x^");
		int ilk2 = pol2.indexOf("x^");
		
		String ust1S ="";
		for(int i = ilk1+2 ; i < pol1.length() ; i++) {
			if(pol1.charAt(i) == '+' || pol1.charAt(i) == '-') break;
			ust1S += pol1.charAt(i);
		}
		
		String ust2S = "";
		for(int i = ilk2+2 ; i < pol2.length() ; i++) {
			if(pol2.charAt(i) == '+' || pol2.charAt(i) == '-') break;
			ust2S += pol2.charAt(i);
		}
		int sayi1 = parse(ust1S);
		int sayi2 = parse(ust2S);
		
		String carpan1S = "";
		String carpan2S = "";
		
		if(sayi1 != sayi2) return pol1;
	

			for(int i = ilk1-1; i >-1 ; i--) {
				carpan1S = pol1.charAt(i)+ carpan1S;				
				if(pol1.charAt(i) == '+' || pol1.charAt(i) == '-') break;
			}	
			
			
			for(int i = ilk2-1; i >-1 ; i--) {
				carpan2S = pol2.charAt(i)+ carpan2S;				
				if(pol2.charAt(i) == '+' || pol2.charAt(i) == '-') break;
			}	
			
			
			int carpan1 = parse(carpan1S);
			int carpan2 = parse(carpan2S);
						
			String son = carpan1+carpan2+"x^"+ust1S;
			if(son.charAt(0) != '-') son = "+"+son;

			
		

		
		
		return son;
	}
		
		
	}
	
	

