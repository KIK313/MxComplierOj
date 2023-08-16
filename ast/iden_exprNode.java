package ast;
import utl.position;
public class iden_exprNode extends expressionNode {
    public String name;
    public iden_exprNode(position pos, String s) {
        super(pos);
        name = s;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
