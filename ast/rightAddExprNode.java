package ast;
import utl.position;
public class rightAddExprNode extends expressionNode {
    public String op;
    public expressionNode nd;
    public rightAddExprNode(position pos, String s, expressionNode node) {
        super(pos);
        op = s;
        nd = node;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}