package utl;

import java.util.List;
import ast.func_defNode;
public class funcClass {
    public Type returnType;
    public String name;
    public func_defNode nd;
    public List<Type> parameterList;
    public funcClass(Type tp, String s, List<Type> lis, func_defNode nd) {
        this.returnType = tp;
        this.name = s;
        this.parameterList = lis;
        this.nd = nd;
    }
}
