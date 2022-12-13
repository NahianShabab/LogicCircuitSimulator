package Node;
import java.util.ArrayList;
import java.util.List;

public abstract class Node{
	protected List<Node> inputs;
	public String label;
	public Node(String label){
		inputs=new ArrayList<Node>();
		this.label=label;
	}
	public abstract boolean can_take_input();
	public abstract boolean can_produce_output();
	public void add_input(Node node){
		if(can_take_input()){
			if(node.can_produce_output()){
				inputs.add(node);
			}
		}
	}
	// unfinished
	public abstract boolean get_output();
}