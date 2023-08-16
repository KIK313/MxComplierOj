package ast;
import utl.position;
import java.util.List;

public class ProgramNode extends ASTNode {
    public List<ProgramComp> lis;
    public ProgramNode(position pos, List<ProgramComp> ls) {
        super(pos);
        this.lis = ls;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
