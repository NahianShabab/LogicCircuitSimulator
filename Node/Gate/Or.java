package Node.Gate;

import Node.Node;

public class Or extends Gate{

    public Or(String label){
        super(label);
    }



    @Override
    public boolean get_output() {
        boolean value=false;
        for(Node n:inputs)
            value |=n.get_output();
        return value;
    }
    
}