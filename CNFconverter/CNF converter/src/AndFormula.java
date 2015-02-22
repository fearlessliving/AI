
public class AndFormula extends Formula{
	public Formula p;
	public Formula q;
	public AndFormula(Formula p , Formula q){
		this.p = p;
		this.q = q;
	}
	public String toString(){
		return("(and " + p.toString() + " " + q.toString() + ")");
	}
}
