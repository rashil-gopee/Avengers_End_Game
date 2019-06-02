package Model.Tree;

import Model.Command.Command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Node implements Serializable {
    int id;
    Command command;

    public ArrayList<Node> getChild() {
        return child;
    }

    ArrayList<Node> child;

    public Node(int id,Command command)
    {
        this.id=id;
        this.command=command;
        child = new ArrayList<Node>();
    }

    public Command getCommand() {
        return command;
    }

    public int getId() {
        return id;
    }

    public void addChild(Node child)
    {
        this.child.add(child);
    }

    public int childCount()
    {
        return child.size();
    }

    public Node getChild(int i) {
        return child.get(i);
    }

    public String getDescription() {

        return command.getClass().toString();
    }
}
