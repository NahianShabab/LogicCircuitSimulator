package Node.IO.Input;

import Node.Node;
import Node.IO.IO;

public class Input extends IO{
	public boolean state;
	public Input(String label){
		super(label);
		state=false;
	}
	@Override
	public boolean can_take_input() {
		return false;
	}
	@Override
	public boolean can_produce_output() {
		return true;
	}
	@Override
	public boolean get_output(){
		return state;
	}

	@Override
	public void add_input(Node node){
		
	}

	
}