
public class Variable extends Formula{
	public String varName;
	public boolean isNegated = false;
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
