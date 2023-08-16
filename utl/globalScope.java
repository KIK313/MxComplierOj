package utl;

import utl.error.semanticError;
import utl.error.syntaxError;

import java.util.HashMap;
import java.util.HashSet;

public class globalScope extends Scope {
    public HashMap<String, funcClass> functions;
    public HashMap<String, classBuild> classes;
    public HashSet<String> types;
    public globalScope(Scope parentScope) {
        super(parentScope);
        functions = new HashMap<>();
        classes = new HashMap<>();
        types = new HashSet<>();
        types.add("int"); types.add("bool"); types.add("void"); types.add("string");
    }
    public void addFunc(String name, funcClass f, position pos) {
        if (functions.containsKey(name)) throw new semanticError("Function Redefinition", pos);
        functions.put(name, f);
    }
    public void addClass(String name, classBuild f, position pos) {
        if (classes.containsKey(name)) throw new semanticError("Class Redefinition", pos);
        classes.put(name, f);
    }
    public void addType(String name, position pos) {
        if (classes.containsKey(name)) throw new syntaxError("Type Redefinition", pos);
        types.add(name);
    }
    public funcClass getFunc(String name) {
        if (functions.containsKey(name)) return functions.get(name);
        return null;
    }
    public classBuild getClass(String name) {
        if (classes.containsKey(name)) return classes.get(name);
        return null;
    }
}