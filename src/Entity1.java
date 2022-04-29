/**
 * @author aliou on 4/29/2022
 * @project KnowledgeGraph
 */
public class Entity1 implements Comparable<Entity1> {

	private Relation[] relations;
    private Entity2[] dependent;
	//Added by Matthew
	private String entityname;
	private int relationscount;
	private int dependentcount;
	//Added by Matthew

    public Entity1(String name){
    	// Added by Matthew
    	entityname = name;
    	relations = new Relation[5];
    	dependent = new Entity2[5];
    	relationscount = 0;
    	dependentcount = 0;
    	// Added by Matthew
    }

    @Override
    public int compareTo(Entity1 o) {
        return 0;
    }
    
    //Added By Matthew
    public void addRelation (Relation newrel) {
    	relations[relationscount] = newrel;
    	relationscount ++;
    }
    
    public void addDependent (Entity2 newdep) {
    	dependent[dependentcount] = newdep;
    	dependentcount++;
    }
    
    public String toString() {
    	String s = "All relations and their dependents for"+entityname;
    	for (int i = 0; i <= relationscount; i++) {
    		System.out.println(""+entityname+" "+relations[i].getName()+" "+dependent[i].getName());
    	}
    	return s;
    }
    
    public String getName() {
    	return entityname;
    }
    
    public Entity1 getEntity() {
    	return this;
    }
    
    //Added By Matthew
    
}
