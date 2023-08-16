package ast;
import utl.position;
public class while_statNode extends statementNode {
    public expressionNode con;
    public statementNode nd;
    public while_statNode(position pos, expressionNode con, statementNode s) {
        super(pos);
        this.con = con;
        this.nd = s;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
