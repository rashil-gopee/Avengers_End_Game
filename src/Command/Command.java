package Command;

public abstract class Command
{
    public abstract boolean execute();
    public abstract void undo();
    public abstract void redo();
}