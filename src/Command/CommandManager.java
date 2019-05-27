package Command;

import Model.Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class CommandManager implements Serializable
{
    private  Stack commandStack = new Stack<>();

    public void ExecuteCommand(Command cmd)
    {
        cmd.Execute();
        commandStack.push(cmd);

    }


    public void Undo(int undo)
    {
        for(int i=0;i<undo;i++) {
            if (commandStack.size() > 0) {
                UndoableCommand cmd = (UndoableCommand) commandStack.pop();
                cmd.Undo();
            }
        }
    }

    public void playMoves(Game game) {
        ArrayList replayList = new ArrayList(commandStack);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(replayList.size());
                for(int i=0;i<replayList.size();i++)
                {
                    UndoableCommand cmd = (UndoableCommand)replayList.get(i);
                    cmd.redo();
                    game.notifyModelChangedListeners();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

}