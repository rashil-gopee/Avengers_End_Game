package Composite;

import Command.*;
import Model.Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class CommandComposite extends Command implements Serializable {
    private Stack<Command> commandStack = new Stack<>();

    public void add(Command command){
        commandStack.push(command);
    }

    public void addChild(Command command){
        Command lastCommand = commandStack.lastElement();
        if (lastCommand instanceof CommandComposite)
            ((CommandComposite)lastCommand).add(command);
    }

    /**
     * This method is used to execute the command and push the command in
     * a stack so as to undo later.
     * @param cmd this is the command to be executed
     * @return boolean This returns if the command was successfully executed or not.
     */
    public boolean ExecuteCommand(Command cmd)
    {
        boolean move=cmd.execute();
        if(move) {
            commandStack.push(cmd);
            return true;
        }
        return false;

    }

    /**
     * This method is used to undo the commands both players have played.
     * @param undo this is the number of commands to be undone.
     * @return void
     */
    public void undoCommand(int undo)
    {
        for(int i=0;i<undo;i++) {
            if (commandStack.size() > 0) {
                Command cmd = commandStack.pop();
                cmd.undo();
            }
        }
    }

    /**
     * This method is used to undo the commands both players have played.
     * @param game this is the number of commands to be undone.
     * @return void
     */
    public void playMoves(Game game) {
        ArrayList<Command> replayList = new ArrayList(commandStack);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<replayList.size();i++)
                {
                    Command cmd = replayList.get(i);
                    cmd.redo();
                    game.notifyModelChangedListeners();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

    /**
     * This method is used to redo a list of commands from the start setup
     * to allow user to move to any gameplay position at any time.
     * @param commands this is arraylist of commands to be redone.
     * @return void
     */
    public void playNodeMoves(ArrayList commands) {
        for(int i=0;i<commands.size();i++)
        {
            UndoableCommand cmd = (UndoableCommand)commands.get(i);
            cmd.redo();
        }

    }

    public boolean execute(){
        for (Command command: commandStack) {
            command.execute();
        }
        return true;
    }

    @Override
    public void undo() {
        for (int i = commandStack.size(); i-- > 0; ) {
           (commandStack.get(i)).undo();
        }
    }

    @Override
    public void redo() {
        for (Command command: commandStack) {
            command.redo();
        }
    }
}
