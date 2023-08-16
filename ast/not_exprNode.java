package ast;
import utl.position;
public class not_exprNode extends expressionNode {
    public String op;
    public expressionNode nd;
    public not_exprNode(position pos, String op, expressionNode nd) {
        super(pos);
        this.nd = nd;
        this.op = op;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
