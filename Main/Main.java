package Main;

import java.io.FileNotFoundException;

import Node.Node;
import Node.Gate.And;
import Node.Gate.Not;
import Node.Gate.Or;
import Node.IO.Input.Input;
import Node.IO.Output.Output;
import TextSimulate.TextSimulate;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TextSimulate textSimulate=new TextSimulate();
        textSimulate.simulate();
    }
}
