package LoopDetector;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Node.Node;
import Node.NodeColor;

public class LoopDetector {
    public boolean has_loop(List<Node> nodes){
        for(Node n:nodes)
            n.nodeColor=NodeColor.WHITE;
        if(nodes.size()==0)
            return false;
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).nodeColor==NodeColor.WHITE){
                LinkedList<Node> nodeStack=new LinkedList<Node>();
                nodeStack.add(nodes.get(i));
                // System.out.println("Starting new DFS at : "+nodes.get(i).label);
                while(nodeStack.isEmpty()==false){
                    Node current=nodeStack.peekLast();
                    // System.out.println("peeked Last of stack: "+current.label);
                    if(current.nodeColor==NodeColor.WHITE){
                        current.nodeColor=NodeColor.GREY;
                        // System.out.println(current.label+" is white");
                    }
                    else{
                        // System.out.println(current.label+" is grey");
                        current.nodeColor=NodeColor.BLACK;
                        nodeStack.removeLast();
                        continue;
                    }
                    for(Node n:current.get_inputs()){
                        // System.out.println("Checking Neighbour of "+current.label+" : "+n.label);
                        if(n.nodeColor==NodeColor.GREY){
                            // System.out.println(n.label+" is grey");
                            return true;
                        }
                        else if(n.nodeColor==NodeColor.WHITE){
                            nodeStack.addLast(n);
                            // System.out.println(n.label+" is white");
                        }
                    }

                }
            }
        }

        return false;
    }
}

