import java.util.*;


/*
 * This class represents a Clause in a CNF Formula.
 * It consists of a set of variables.
 */

public class Clause {
	public Set<Variable> literals = new HashSet<Variable>();
	

	public boolean equals(Clause rhs){
		return(literals.equals(rhs.literals));
	}

	public boolean equals(Object rhs){
		return(equals((Clause)rhs));
	}
	
	public int hashCode(){
		int ret = 0;
		for(Variable v : literals){
			ret ^= v.hashCode();
		}
		return(ret);
	}
	
	
	
	public String toString(){
		String s = "(";
		for(Variable v : literals){
			s += v.toString() + " ";
		}
		s = s.trim();
		s += ")";
		return(s);
	}
	
	static Clause concat(Clause a , Clause b){
		Clause ret = new Clause();
		ret.literals.addAll(a.literals);
		ret.literals.addAll(b.literals);
		return(ret);
	}

	
	
	/*
	 *	This method checks for Valid Clauses. ie Clauses in the form
	 *	(A V ~A), (B V ~B V C V D). These Clauses are always true as 
	 *	the disjunction of a literal and it's compliment is always true.
	 */
	public boolean isValid(){
		for(Variable v : literals){
			for(Variable v2 : literals){
				if(v.varName.equals(v2.varName)){
					if(v.isNegated != v2.isNegated){
						// v == A and v2 == ~A
						return(true);
					}
				}
			}
		}
		return(false);
	}
	
	
	
}
