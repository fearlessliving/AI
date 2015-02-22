/**

* @author Weizhen Yan
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("TestToyConvert");
		System.out.println("---------------");
		TestToyConvert();
		
		System.out.println("TestWumpusConvert");
		System.out.println("-----------------");
		TestWumpusConvert();
		
		System.out.println("TestUnicornConvert");
		System.out.println("-------------------");
		TestUnicornConvert();
		
	}		
	
	public static void TestToyConvert(){
		String s[] = new String[6];
		s[0] = "(and (not a) b)";
		s[1] = "(or b (and c d))";
		s[2] = "(not (or d e))";
		s[3] = "(not (and e f))";
		s[4] = "(imply (and f g) h)";
		s[5] = "(bicond (and h (not i)) (and j k))";
		
		for(String ss : s){
			System.out.println(ss);
			Formula pf = Formula.parseString(new StringHolder(ss));
			CNFFormula f = CNFFormula.convert(pf);
			System.out.println(f);
			System.out.println();
		}
		
	}
	
	public static void TestWumpusConvert(){
		String s[] = new String[2];	
		s[0] = "(bicond B11 (or P12 P21))";		
		s[1] = "(bicond B21 (or P11 P22 P31))";	
					
		
		for(String ss : s){
			System.out.println(ss);
			CNFFormula f = CNFFormula.convert(Formula.parseString(new StringHolder(ss)));		
			System.out.println(f);
			System.out.println();
		}
	}
	
	public static void TestUnicornConvert(){
		String s[] = new String[4];
		s[0] = "(imply A (not B))";		
		s[1] = "(imply (not A) (and B C))";		
		s[2] = "(imply (or (not B) C) D)";	
		s[3] = "(imply D E)";			

		for(String ss : s){
			System.out.println(ss);
			CNFFormula f = CNFFormula.convert(Formula.parseString(new StringHolder(ss)));
			System.out.println(f);
			System.out.println();
		}
		
	}
		
}
