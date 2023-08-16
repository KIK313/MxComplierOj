package utl.error;
import utl.position;
public class syntaxError extends error {
    public syntaxError(String msg, position pos) {
        super("Syntax Error: " + msg, pos);
    }
}
