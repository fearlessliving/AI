
public class EquivFormula extends Formula{
	public Formula p;
	public Formula q;
	public EquivFormula(Formula p , Formula q){
		this.p = p;
		this.q = q;
	}

	public String toString(){
		return("(bicond " + p.toString() + " " + q.toString() + ")");
	}



}
