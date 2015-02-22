
public class OrFormula extends Formula{
	public Formula p;
	public Formula q;
	public OrFormula(Formula p , Formula q){
		this.p = p;
		this.q = q;
	}
	
	public String toString(){
		return("(or " + p.toString() + " " + q.toString() + ")");
	}
}
