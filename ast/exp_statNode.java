package ast;
import utl.position;
public class exp_statNode extends statementNode {
    public expressionNode nd;
    public exp_statNode(position pos, expressionNode nd) {
        super(pos);
        this.nd = nd;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
