package ast;
import utl.position;
public class class_call_exprNode extends expressionNode {
    public expressionNode nd;
    public func_call_listNode funcCallLis;
    public String funcname;
    public class_call_exprNode(position pos, expressionNode nd, String ss, func_call_listNode lis) {
        super(pos);
        this.nd = nd;
        funcname = ss;
        this.funcCallLis = lis;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
