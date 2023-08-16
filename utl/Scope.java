package utl;

import utl.error.semanticError;

import java.util.HashMap;

public class Scope {
    public HashMap<String, Type> members;
    public Scope parentScope;
    public Scope(Scope parentScope) {
        members = new HashMap<>();
        this.parentScope = parentScope;
    }
    public Scope parentScope() {
        return parentScope;
    }
    public void defVariable(String name, Type tp, position pos) {
        if (members.containsKey(name)) throw new semanticError("Variable Redefinition",pos);
        members.put(name, tp);
    }
    public Type getType(String name, boolean lookUp) {
        if (members.containsKey(name)) return members.get(name);
        if (parentScope != null && lookUp) return parentScope.getType(name, true);
        return null;
    }
    public boolean containsVariable(String name, boolean lookUp) {
        if (members.containsKey(name)) return true;
        if (parentScope != null && lookUp) return parentScope.containsVariable(name, true);
        return false;
    }
}
