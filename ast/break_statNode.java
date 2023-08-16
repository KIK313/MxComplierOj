package ast;
import utl.position;
public class break_statNode extends statementNode {
    public break_statNode(position pos) {
        super(pos);
    }
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
