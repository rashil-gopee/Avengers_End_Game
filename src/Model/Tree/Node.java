package Model.Tree;

import Command.Command;

import java.util.Vector;

public class Node {
    int id;
    Command command;
    Vector<Node> child;

    public Node(int id,Command command)
    {
        this.id=id;
        this.command=command;
        child = new Vector<Node>();
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
}
