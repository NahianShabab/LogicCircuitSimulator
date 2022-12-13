package TextSimulate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import LoopDetector.LoopDetector;
import Node.Node;
import Node.Gate.And;
import Node.Gate.Not;
import Node.Gate.Or;
import Node.IO.Input.Input;
import Node.IO.Output.Output;

public class TextSimulate {
   
    public void simulate()throws FileNotFoundException {
        Scanner scanner=new Scanner(new File("input.txt"));
        List<Input> inputs=new ArrayList<>();
        List<Output> outputs=new ArrayList<>();
        List<Node> nodes=new ArrayList<>();
        while(scanner.hasNextLine()){
            try{
                String [] strings=scanner.nextLine().split(" ");
                if(strings[0].equalsIgnoreCase("Input")){
                    String label=strings[1];
                    boolean state=Boolean.parseBoolean(strings[2]);
                    Input input=new Input(label);
                    input.state=state;
                    inputs.add(input);
                    nodes.add(input);
                }
                else if(strings[0].equalsIgnoreCase("Output")){
                    String label=strings[1];
                    Output output=new Output(label);
                    outputs.add(output);
                    nodes.add(output);
                }
                else if(strings[0].equalsIgnoreCase("gate")){
                    String label=strings[2];
                    Node node=generateGate(strings[1], label);
                    if(node!=null)
                        nodes.add(node);
                }
                else if(strings[0].equalsIgnoreCase("Connect")){
                    String from=strings[1];
                    String to=strings[2];
                    Node inputNode=null,targetNode=null;
                    for(Node n:nodes){
                        if(n.label.equals(from))
                            inputNode=n;
                        else if(n.label.equals(to))
                            targetNode=n;
                    }
                    if(inputNode!=null && targetNode!=null)
                        targetNode.add_input(inputNode);
                }

            }//for any input format errors
            catch(Exception e){
                System.out.println("Found Error!");
            }
        }
        LoopDetector loopDetector=new LoopDetector();
        if(loopDetector.has_loop(nodes)){
            System.out.println("Has Loops");
            return;
        }
        for(Output o:outputs){
            System.out.println(o.label+" : "+o.get_output());
        }
    }

    // private boolean is_name_of_gate(String command){
    //     String [] gates={"And","Or","Not"};
    //     for(String s:gates){
    //         if(s.equalsIgnoreCase(command))
    //             return true;
    //     }
    //     return false;
    // }
    private Node generateGate(String gateName,String label){
        if(gateName.equalsIgnoreCase("And"))
            return new And(label);
        else if(gateName.equalsIgnoreCase("Or"))
            return new Or(label);
        else if(gateName.equalsIgnoreCase("Not"))
            return new Not(label);
        else
            return null;
    }

}
