package ast;
import utl.position;
public class continue_statNode extends statementNode {
    public continue_statNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
