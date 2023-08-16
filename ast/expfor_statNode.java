package ast;
import utl.position;
public class expfor_statNode extends statementNode {
    public expressionNode nd, con, stp;
    public statementNode stat;
    public expfor_statNode(position pos, expressionNode nd, expressionNode con, expressionNode stp, statementNode st) {
        super(pos);
        this.nd = nd;
        this.con = con;
        this.stp = stp;
        this.stat = st;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}