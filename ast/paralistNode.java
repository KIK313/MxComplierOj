package ast;
import utl.Type;
import utl.position;

import java.util.List;

public class paralistNode extends ASTNode {
    public List<Type> tpLis;
    public List<String> name;
    public paralistNode(position pos, List<Type> ls, List<String> s) {
        super(pos);
        this.tpLis = ls;
        this.name = s;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
