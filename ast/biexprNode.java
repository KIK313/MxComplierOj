package ast;
import utl.position;
public class biexprNode extends expressionNode {
    public String op;
    public expressionNode ls, rs;
    public biexprNode(position pos, String op, expressionNode ls, expressionNode rs) {
        super(pos);
        this.op = op;
        this.ls = ls;
        this.rs = rs;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
