package ast;
import utl.position;
public class if_statNode extends statementNode {
    public expressionNode con;
    public statementNode thenst, elsest;
    public if_statNode(position pos, expressionNode con, statementNode t, statementNode e) {
        super(pos);
        this.con = con;
        this.thenst = t;
        this.elsest = e;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
