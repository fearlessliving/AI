/**
 * This program use the same parser function in CNFconverter, 
 * because the CNFconverter has already achieved the converting method
 * So I just call the PL sentence into Main function, and by using same techinc, 
 * it will translate PL sentence to required CNF form
 * then it will do simple resolution rule to get the final answer.
 * 
 * I did not implement these two strategies.
 * About the other two strategies, one is DPLL algorithm 
 * which essentially a recursive, depth-first search enmueration of possible models,
 * it includes three improvement method: early termination, pure symbol,unit clause heruistic.
 * 
 * The other is WalkSAT algorithm, it derives from Hill-Climbing and Simulated-Annealing.
 * On every iteration, it first picks up an unstaisfied clause and a symbol in the clause to flip. 
 * Then it chooses randomly between two wats to pick which symbol to flip.
 * 
 * @author Weizhen Yan
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestWumpus();
		TestUnicorn();
	}		
	public static void TestWumpus(){
		String s[] = new String[5];
		s[0] = "(not P11)";		
		s[1] = "(bicond B11 (or P12 P21))";		
		s[2] = "(bicond B21 (or P11 P22 P31))";	
		s[3] = "(not B11)";	//percept		
		s[4] = "B21";		//percept			

		Variable query1 = new Variable("P12" , false);
		Variable query2 = new Variable("P22" , false);
		AskKB resolver = new AskKB();
		for(String ss : s){
			resolver.kb.tellKb(Formula.parseString(new StringHolder(ss)));
		}
		System.out.println("TestWumpus");
		System.out.println("-------------");
		System.out.println(resolver.askKb(query1));
		System.out.println(resolver.askKb(query2));
		System.out.println();
	
	}
	
	public static void TestUnicorn(){
		String s[] = new String[4];
		s[0] = "(imply mythicial (not mortal))";		
		s[1] = "(imply (not mythicial) (and mortal mammal))";		
		s[2] = "(imply (or (not mortal) mammal) horned)";	
		s[3] = "(imply horned magical)";			
		Variable query1 = new Variable("mythicial" , true);
		Variable query2 = new Variable("horned" , true);
		Variable query3 = new Variable("magical" , true);
		AskKB resolver = new AskKB();
		for(String ss : s){
			resolver.kb.tellKb(Formula.parseString(new StringHolder(ss)));
		}
		System.out.println("TestUnicorn");
		System.out.println("-------------");
		System.out.println(resolver.askKb(query1));
		System.out.println(resolver.askKb(query2));
		System.out.println(resolver.askKb(query3));
		System.out.println();
	}
	
	
}
