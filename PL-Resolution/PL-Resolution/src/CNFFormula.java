import java.util.*;

public class CNFFormula {
	public Set<Clause> clauses = new HashSet<Clause>();

	
	
	/**
	 * This method removes all valid clauses as determined by
	 * Clause.isValid().
	 */
	public void removeValid(){
		Set<Clause> tmp = new HashSet<Clause>();
		for(Clause c : clauses)
			if(!c.isValid())
				tmp.add(c);
		clauses = tmp;
	}
	
	public String toString(){
		String s = "";
		for(Clause c : clauses)
			s += c.toString() + " ";
		return(s);
	}

	
	
	/**
	 * This static function converts a Formula f to CNF Form.
	 */
	static public CNFFormula convert(Formula f){
		if(f instanceof Variable){
			Variable v = new Variable();
			v.varName = ((Variable)f).varName;
			CNFFormula cf = new CNFFormula();
			Clause cl = new Clause();
			cl.literals.add(v);
			cf.clauses.add(cl);
			return(cf);
		}
		
		if(f instanceof AndFormula){
			AndFormula af = (AndFormula)f;
			CNFFormula p = convert(af.p);
			CNFFormula q = convert(af.q);
			CNFFormula cf = new CNFFormula();
			for(Clause c : p.clauses)
				cf.clauses.add(c);
			for(Clause c : q.clauses)
				cf.clauses.add(c);
			return(cf);
		}
		
		if(f instanceof OrFormula){
			OrFormula of = (OrFormula)f;
			CNFFormula p = convert(of.p);
			CNFFormula q = convert(of.q);
			CNFFormula cf = new CNFFormula();
			for(Clause c1 : p.clauses){
				for(Clause c2 : q.clauses){
					cf.clauses.add(Clause.concat(c1, c2));
				}
			}
			return(cf);
		}
		
		if(f instanceof NotFormula){
			NotFormula nf = (NotFormula)f;
			CNFFormula ret = new CNFFormula();
			if(nf.p instanceof Variable){
				Variable v = new Variable();
				v.varName = ((Variable)nf.p).varName;
				v.isNegated = true;
				Clause cl = new Clause();
				cl.literals.add(v);
				ret.clauses.add(cl);
				return(ret);
			}
			if(nf.p instanceof NotFormula){
				NotFormula nf2 = (NotFormula)nf.p;
				return(convert(nf2.p));
			}
			if(nf.p instanceof AndFormula){
				AndFormula af = (AndFormula)nf.p;
				NotFormula a = new NotFormula(af.p);
				NotFormula b = new NotFormula(af.q);
				return(convert(new OrFormula(a , b)));
			}
			if(nf.p instanceof OrFormula){
				OrFormula af = (OrFormula)nf.p;
				NotFormula a = new NotFormula(af.p);
				NotFormula b = new NotFormula(af.q);
				return(convert(new AndFormula(a , b)));
			}		
		}
		
		if(f instanceof ImpliesFormula){
			ImpliesFormula ff = (ImpliesFormula)f;
			return(convert(new OrFormula(new NotFormula(ff.p) , ff.q)));
		}
		if(f instanceof EquivFormula){
			EquivFormula ff = (EquivFormula)f;
			AndFormula a = new AndFormula(ff.p, ff.q);
			AndFormula b = new AndFormula(new NotFormula(ff.p), new NotFormula(ff.q));
			return(convert(new OrFormula(a, b)));
		}
		
		
		return(null);
	}

	
	
	
}
