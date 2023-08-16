package ast;
import utl.position;
public class empty_statNode extends statementNode {
    public empty_statNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
