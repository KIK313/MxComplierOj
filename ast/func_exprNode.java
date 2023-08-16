package ast;
import utl.position;
public class func_exprNode extends expressionNode {
    public String funcname;
    public func_call_listNode nd;
    public func_exprNode(position pos, String name, func_call_listNode node) {
        super(pos);
        this.funcname = name;
        this.nd = node;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
