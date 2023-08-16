package ast;
import  utl.position;
public abstract class ProgramComp extends ASTNode{
    public ProgramComp(position pos) {
        super(pos);
    }
    public abstract void accept(ASTVisitor visitor);
}
