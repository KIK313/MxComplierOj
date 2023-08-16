package ast;
import utl.position;
public class leftAddExprNode extends expressionNode {

    public String op;
    public expressionNode nd;
    public leftAddExprNode(position pos, String op, expressionNode nd) {
        super(pos);
        this.nd = nd;
        this.op = op;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
