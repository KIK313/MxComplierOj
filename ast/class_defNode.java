package ast;
import utl.position;

import java.util.List;

public class class_defNode extends ProgramComp{
    public List<func_defNode> funcLis;
    public List<variable_defNode> varLis;
    public class_constructorNode nd = null;
    public String name;
    public class_defNode(position pos, String s, List<func_defNode> ls, List<variable_defNode> ll, class_constructorNode nd) {
        super(pos);
        this.funcLis = ls;
        this.name = s;
        this.funcLis = ls;
        this.varLis = ll;
        this.nd = nd;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
