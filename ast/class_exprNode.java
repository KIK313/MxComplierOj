package ast;
import utl.position;
public class class_exprNode extends expressionNode {
    public expressionNode nd;
    public String name;
    public class_exprNode(position pos, expressionNode nd, String s) {
        super(pos);
        this.nd = nd;
        this.name = s;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
