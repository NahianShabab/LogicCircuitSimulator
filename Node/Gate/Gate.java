package Node.Gate;
import Node.Node;
public abstract class Gate extends Node{
    public Gate(String label){
        super(label);
    }
    @Override
    public boolean can_take_input() {
        return true;
    }

    @Override
    public boolean can_produce_output() {
        return true;
    }

}