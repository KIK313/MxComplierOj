package ast;
import utl.position;
import utl.Type;
public class main_defNode extends ProgramComp{
    public Type tp;
    public suiteNode nd;
    public main_defNode(position pos, suiteNode nd) {
        super(pos);
        this.nd = nd;
        this.tp = new Type("int");
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
