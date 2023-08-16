package ast;
import utl.position;
import utl.Type;

import java.util.Objects;

public class literal_exprNode extends expressionNode {
    public String s;
    public literal_exprNode(position pos, String tp) {
        super(pos);
        this.s = tp;
        if (Objects.equals(tp, "false")) this.nodeType = new Type("bool");
        else if (Objects.equals(tp, "true")) this.nodeType = new Type("bool");
        else if (Objects.equals(tp ,"null")) this.nodeType = new Type("null");
        else if (Objects.equals(tp, "this")) this.nodeType = new Type("this");
        else if (tp.charAt(0) >= '0' && tp.charAt(0) <= '9') this.nodeType = new Type("int");
        else this.nodeType = new Type("string");
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
