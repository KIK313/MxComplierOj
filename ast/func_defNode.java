package ast;
import utl.Type;
import utl.position;
public class func_defNode extends ProgramComp {
    public Type tp;
    public String name;
    public suiteNode nd;
    public paralistNode ls;
    public func_defNode(position pos, Type tp, String s, suiteNode nd, paralistNode o) {
        super(pos);
        this.tp = tp;
        this.name = s;
        this.nd = nd;
        this.ls = o;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
