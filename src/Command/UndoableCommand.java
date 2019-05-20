package Command;

public abstract class UndoableCommand extends Command {
    public abstract void Undo();
    public abstract void redo();
}