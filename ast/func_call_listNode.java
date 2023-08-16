package ast;
import utl.position;

import java.util.List;

public class func_call_listNode extends ASTNode {
    public List<expressionNode> lis;
    public func_call_listNode(position pos, List<expressionNode> lis)
    {
        super(pos);
        this.lis = lis;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
