package Node.Gate;
import Node.Node;


public class Not extends Gate{

    public Not(String label){
        super(label);
    }

    @Override
    public void add_input(Node node){
        if(node.can_produce_output()){
            if(inputs.size()==0)
                inputs.add(node);
            else
                inputs.set(0, node);
        }
	}

    @Override
    public boolean get_output() {
        if(inputs.size()==1)
            return !inputs.get(0).get_output();
        return false;
    }
}