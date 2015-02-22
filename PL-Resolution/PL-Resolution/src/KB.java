
public class KB {
   public CNFFormula cf_ = new CNFFormula();

   /**
	 * Adds the percept to the knowledge base.
	 */
	public void tellKb(Formula f){
		CNFFormula tmp = CNFFormula.convert(f);
		tmp.removeValid();
		cf_.clauses.addAll(tmp.clauses);
	}
	public void clearKb(){
		cf_.clauses.clear();
	}
	
}
