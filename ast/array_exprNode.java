package ast;
import utl.position;
public class array_exprNode extends expressionNode {
    public expressionNode nd, id;
    public array_exprNode(position pos, expressionNode nd, expressionNode id) {
        super(pos);
        this.nd = nd;
        this.id = id;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
