package utl;

import utl.error.semanticError;

import java.util.HashMap;
import ast.class_constructorNode;
public class classBuild {
    public HashMap<String, Type> members;
    public HashMap<String, funcClass> methods;
    public class_constructorNode nd;
    public classBuild(HashMap<String, Type> mb, HashMap<String, funcClass> mt) {
        this.members = mb;
        this.methods = mt;
    }
    public void defVariable(String name, Type tp, position pos) {
        if (members.containsKey(name)) throw new semanticError("Variable Redefinition", pos);
        members.put(name, tp);
    }
    public void addMethod(String name, funcClass f, position pos) {
        if (methods.containsKey(name)) throw new semanticError("Class Function Redefinition", pos);
        methods.put(name, f);
    }
    public Type getType(String name) {
        if (members.containsKey(name)) return members.get(name);
        return null;
    }
    public funcClass getMethod(String name) {
        if (methods.containsKey(name)) return methods.get(name);
        return null;
    }
}