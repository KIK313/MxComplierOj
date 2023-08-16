package ast;
import utl.position;
public class deffor_statNode extends statementNode {
    public variable_defNode nd;
    public expressionNode con,stp;
    public statementNode stat;
    public deffor_statNode(position pos, variable_defNode nd, expressionNode con, expressionNode stp, statementNode st) {
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
