package ast;
import utl.position;
public class tri_exprNode extends expressionNode {
    public expressionNode con, ls, rs;
    public tri_exprNode(position pos, expressionNode con, expressionNode ls, expressionNode rs) {
        super(pos);
        this.con = con;
        this.ls = ls;
        this.rs = rs;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
