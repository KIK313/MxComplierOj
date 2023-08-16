package utl.error;
import utl.position;
public class semanticError extends error {
    public semanticError(String msg, position pos) {
        super("SemanticError: " + msg, pos);
    }
}
