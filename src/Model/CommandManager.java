package Model;

import java.util.ArrayList;
import java.util.Stack;

class CommandManager
{
    private  Stack commandStack = new Stack<>();

    public void ExecuteCommand(Command cmd)
    {
        cmd.Execute();
        commandStack.push(cmd);

    }


    public void Undo()
    {
        if (commandStack.size() > 0)
        {
            UndoableCommand cmd = (UndoableCommand)commandStack.pop();
            cmd.Undo();
        }
    }

    public void playMoves() {
        ArrayList replayList = new ArrayList(commandStack);
        for(int i=replayList.size()-1;i>0;i--)
        {
            System.out.println(replayList.get(i).toString());
        }

    }
}