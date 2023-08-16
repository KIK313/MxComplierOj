package ast;
import utl.position;
public class paren_exprNode extends expressionNode {
    public expressionNode son;
    public paren_exprNode(position pos, expressionNode son) {
        super(pos);
        this.son = son;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
