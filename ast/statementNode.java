package ast;
import utl.position;
abstract public class statementNode extends ASTNode {
    public statementNode(position pos) {
        super(pos);
    }

    abstract public void accept(ASTVisitor visitor);
}
