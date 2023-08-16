package ast;
import utl.position;
public class new_exprNode extends expressionNode {
    public new_typeNode nd;
    public new_exprNode(position pos, new_typeNode node) {
        super(pos);
        this.nd = node;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
