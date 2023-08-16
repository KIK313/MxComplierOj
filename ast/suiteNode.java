package ast;
import utl.position;

import java.util.List;

public class suiteNode extends statementNode {
    public List<statementNode> lis;
    public suiteNode(position pos, List<statementNode> ls) {
        super(pos);
        this.lis = ls;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
