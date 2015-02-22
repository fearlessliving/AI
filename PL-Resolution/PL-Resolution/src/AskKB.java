import java.util.*;


/**
 * This Class performs resolution on PL Formulas
 */
public class AskKB {
	KB kb =new KB();

	public boolean askKb(Variable p){
		return(resolution(p));
	}
	
	/**  Resolution method
     *checks for empty clauses. If the empty clause is found ,return true
	 * and if no more clauses can be resolved , returns false. 
	 */
	public boolean resolution(Variable p){
		CNFFormula cf = new CNFFormula();
		cf.clauses.addAll(kb.cf_.clauses);
		Clause c = new Clause();
		c.literals.add(p.compl());
		cf.clauses.add(c);
		Set<Clause> cnew = new HashSet<Clause>();
		while(true){
			for(Clause ci : cf.clauses){
				if(ci.isValid()) continue;
				for(Clause cj : cf.clauses){
					if(cj.isValid()) continue;
					if(ci.equals(cj))
						continue;
					Vector<Clause> resolvents = resolve(ci, cj);
					for(Clause cr : resolvents)
						if(cr.literals.isEmpty())
							return(true);					
					cnew.addAll(resolvents); // cnew = cnew U resolvents
				}
			}
			if(cf.clauses.containsAll(cnew)) // if cnew is subset of cf.clauses
				return(false);
			cf.clauses.addAll(cnew); // cf.clauses = cf.clauses U cnew
		}
	}
	
	public Vector<Clause> resolve(Clause Ci , Clause Cj){
		Vector<Clause> ret = new Vector<Clause>();
		for(Variable vi : Ci.literals){
			for(Variable vj : Cj.literals){
				if(vi.equals(vj.compl())){
					Clause c = Clause.concat(Ci, Cj);
					c.literals.remove(vi);
					c.literals.remove(vj);
					ret.add(c);
				}
			}
		}
		return(ret);
	}
}
