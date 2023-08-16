package ast;
import utl.position;
import utl.Type;
abstract public class expressionNode extends ASTNode {
    public Type nodeType;
    public expressionNode(position pos) {
        super(pos);
    }
    abstract public void accept(ASTVisitor visitor);
}
