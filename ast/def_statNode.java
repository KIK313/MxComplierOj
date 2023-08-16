package ast;
import utl.position;
public class def_statNode extends statementNode{
    public variable_defNode nd;
    public def_statNode(position pos, variable_defNode nd) {
        super(pos);
        this.nd = nd;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
