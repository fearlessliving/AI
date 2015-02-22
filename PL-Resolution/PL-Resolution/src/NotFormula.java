
public class NotFormula extends Formula{
	public Formula p;
	public NotFormula(Formula p){
		this.p = p;
	}
	public String toString(){
		return("(not " + p.toString() + ")");
	}
	
}
