package ast;
import utl.position;
public class varinitNode extends ASTNode {
    public String name;
    public expressionNode nd;
    public varinitNode(position pos, String s, expressionNode nd) {
        super(pos);
        this.nd = nd;
        this.name = s;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
