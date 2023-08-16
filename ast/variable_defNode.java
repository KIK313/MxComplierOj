package ast;
import utl.Type;
import utl.position;

import java.util.List;

public class variable_defNode extends ProgramComp{
    public Type tp;
    public List<varinitNode> lis;
    public variable_defNode(position pos, Type tp, List<varinitNode> ls) {
        super(pos);
        this.tp = tp;
        this.lis = ls;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
