package ast;
import utl.position;
public class typeNode extends ASTNode {
    public String name = null;
    public int dim = 0;
    public typeNode(position pos, String s, int dim) {
        super(pos);
        this.name = s;
        this.dim = dim;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
