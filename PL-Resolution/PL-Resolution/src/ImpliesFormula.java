
public class ImpliesFormula extends Formula{
	public Formula p;
	public Formula q;
	public ImpliesFormula(Formula p , Formula q){
		this.p = p;
		this.q = q;
	}

	public String toString(){
		return("(imply " + p.toString() + " " + q.toString() + ")");
	}

}
