package ast;
import utl.position;

import java.util.List;
import utl.Type;
public class new_typeNode extends ASTNode {
    public Type tp;
    public List<expressionNode> lis;
    public new_typeNode(position pos, Type nd, List<expressionNode> son) {
        super(pos);
        this.tp = nd;
        this.lis = son;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
