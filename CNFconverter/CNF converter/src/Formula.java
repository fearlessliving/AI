
public class Formula {
	public String toString(){
		return("Formula");
	}
	
	
	/**
	 * Parses a String of PL formula
	 * returns an instance of a derived class containing the formula.
	 * The formula is a tree of formulas.
	 */
	static Formula parseString(StringHolder s){
		s.str = s.str.trim();
		if(!s.str.startsWith("(")){ 
			Variable v = new Variable();
			int i = s.str.indexOf(' ');
			int j = s.str.indexOf(')');
			if(i < 0)
				i += 1000005;
			if(j < 0)
				j += 1000005;
			if(j < i)
				i = j;
			if(i > 1000000){
				v.varName = s.str;
				s.str = "";
			}else {
				v.varName = s.str.substring(0 , i);
				s.str = s.str.substring(i);
			}
			return(v);
		}
	
		s.str = s.str.substring(1);
		s.str = s.str.trim();
		int i = s.str.indexOf(' ');
		String op = s.str.substring(0 , i);
		s.str = s.str.substring(i);
		s.str = s.str.trim();
		Formula p = parseString(s);
		Formula q = null;
		Formula f = p;
		s.str = s.str.trim();
		do{
			if(!op.equalsIgnoreCase("not"))
				q = parseString(s);
			if(op.equalsIgnoreCase("and")){
				f=new AndFormula(f, q);
			}else if(op.equalsIgnoreCase("or")){
				f=new OrFormula(f, q);
			}else if(op.equalsIgnoreCase("not")){
				f=new NotFormula(f);
			}else if(op.equalsIgnoreCase("imply")){
				f=new ImpliesFormula(f, q);
			}else if(op.equalsIgnoreCase("bicond")){
				f = new EquivFormula(f, q);
			}else{
				System.out.println("Unknown op: " + op);
				return(null);
			}
			s.str = s.str.trim();
		}while(s.str.charAt(0) != ')');
		s.str = s.str.substring(1);
		return(f);
	}
	
	
}
