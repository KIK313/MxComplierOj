package ast;
import utl.position;
public class assign_exprNode extends expressionNode {
    public expressionNode ls,rs;
    public assign_exprNode(position pos, expressionNode ls, expressionNode rs) {
        super(pos);
        this.ls = ls;
        this.rs = rs;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
