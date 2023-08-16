package ast;
import utl.position;
public class class_constructorNode extends ASTNode{
    public suiteNode nd;
    public String name;
    public class_constructorNode(position pos, suiteNode nd, String s) {
        super(pos);
        this.nd = nd;
        this.name = s;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
