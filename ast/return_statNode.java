package ast;
import utl.position;
public class return_statNode extends statementNode {
    public expressionNode nd;
    public return_statNode(position pos, expressionNode nd) {
        super(pos);
        this.nd = nd;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}