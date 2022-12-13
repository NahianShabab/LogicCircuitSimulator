package Node.Gate;

import Node.Node;

public class And extends Gate{
    public And(String label){
        super(label);
    }
    
    @Override
    public boolean get_output() {
        boolean value=true;
        for(Node n:inputs)
            value &=n.get_output();
        return value;
    }
    
}