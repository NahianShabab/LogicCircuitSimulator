package Node.IO.Output;

import Node.Node;
import Node.IO.IO;

public class Output extends IO{
    public Output(String label){
		super(label);
	}
    @Override
    public boolean can_take_input() {
        return true;
    }

    @Override
    public boolean can_produce_output() {
        return false;
    }

    @Override
    public boolean get_output(){
        if(inputs.size()==1)
            return inputs.get(0).get_output();
        return false;
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
}