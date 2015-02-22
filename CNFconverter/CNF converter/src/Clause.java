import java.util.*;

/**
 * Clause class is a container for literals.
 */
public class Clause {
	public Vector<Variable> literals = new Vector<Variable>();
	
	public String toString(){
		String s = "(";
		for(int i = 0 ; i < literals.size(); i++){
			s += literals.get(i).toString() + " ";
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
	
}
