/*
 * This class represents a Literal, positive or negative. It extends
 * Formula as a single (A) and (~A) are valid formulas.
 */


public class Variable extends Formula{
	public String varName;
	public boolean isNegated = false;

	public Variable() {
		this("");
	}
	public Variable(String name){
		this(name , true);
	}
	public Variable(String name , boolean sign){
		varName = name;
		isNegated = !sign;
	}
	
	/*
	 * Returns the compliment of the variable.
	 * ie. A returns (~A) and vice versa.
	 */
	public Variable compl(){
		Variable ret = new Variable();
		ret.varName = varName;
		ret.isNegated = !isNegated;
		return(ret);
	}
	
	
	/*
	 * Returns true if this equals rhs (Name and sign).
	 */
	public boolean equals(Variable rhs){
		return((varName.equals(rhs.varName)) && (isNegated == rhs.isNegated));
	}
	
	/*
	 * Returns a hash code representing this variable
	 */
	public int hashCode(){
		return(varName.hashCode() ^ Boolean.valueOf(isNegated).hashCode());
	}
	
	
	/*
	 *	Returns a string representation of the variable in the form:
	 *	A or (not A) 
	 */
	public String toString(){
		String s = "";
		if(isNegated){
			s = "(not ";
		}
		s += varName;
		if(isNegated){
			s += ")";
		}
		return(s);
	}
}
