package frontend;

import ast.*;
import utl.Type;
import utl.classBuild;
import utl.error.semanticError;
import utl.globalScope;
import utl.funcClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SymbolCollector implements ASTVisitor {
    private globalScope gScope;
    public SymbolCollector(globalScope g) {
        this.gScope = g;
    }
    public void visit(ProgramNode it) {
        classBuild str = new classBuild(new HashMap<>(), new HashMap<>());
        List<Type> ls = new ArrayList<>(); ls.add(new Type("string"));
        funcClass f1 = new funcClass(new Type("void"), "print", ls, null);
        gScope.addFunc("print", f1, null);
        funcClass f2 = new funcClass(new Type("void"), "println", ls, null);
        gScope.addFunc("println", f2, null);
        ls = new ArrayList<>(); ls.add(new Type("int"));
        funcClass F3 = new funcClass(new Type("int"), "ord", ls, null);
        str.addMethod("ord", F3, it.pos);
        funcClass f3 = new funcClass(new Type("void"), "printInt", ls, null);
        gScope.addFunc("printInt", f3, null);
        funcClass f4 = new funcClass(new Type("void"), "printlnInt", ls, null);
        gScope.addFunc("printlnInt", f4, null);
        funcClass f5 = new funcClass(new Type("string"), "toString", ls, null);
        gScope.addFunc("toString", f5, null);
        ls = new ArrayList<>();
        funcClass F1 = new funcClass(new Type("int"), "length", ls, null);
        str.addMethod("length", F1, it.pos);
        funcClass F2 = new funcClass(new Type("int"), "parseInt", ls, null);
        str.addMethod("parseInt", F2, it.pos);
        funcClass f6 = new funcClass(new Type("string"), "getString", ls, null);
        gScope.addFunc("getString", f6, null);
        funcClass f7 = new funcClass(new Type("int"), "getInt", ls, null);
        gScope.addFunc("getInt", f7, null);
        ls = new ArrayList<>(); ls.add(new Type("int")); ls.add(new Type("int"));
        funcClass F4 = new funcClass(new Type("string"), "substring", ls, null);
        str.addMethod("substring", F4, it.pos);
        gScope.addClass("string", str ,it.pos);
        for(int i = 0; i < it.lis.size(); i++) {
            if (it.lis.get(i) instanceof class_defNode) {
                class_defNode nd = (class_defNode) it.lis.get(i);
                gScope.addType(nd.name, it.pos);
            }
        }
        for(int i = 0; i < it.lis.size(); i++) {
            if (it.lis.get(i) instanceof class_defNode) {
                it.lis.get(i).accept(this);
            }
            if (it.lis.get(i) instanceof func_defNode) {
                it.lis.get(i).accept(this);
            }
            if (it.lis.get(i) instanceof main_defNode) {
                it.lis.get(i).accept(this);
            }
        }
    }
    public void visit(class_defNode it) {
        if (gScope.functions.containsKey(it.name)) throw new semanticError("Bad class name same as function", it.pos);
        classBuild nd = new classBuild(new HashMap<>(), new HashMap<>());
        for (int i = 0; i < it.varLis.size(); i++) {
            variable_defNode u = it.varLis.get(i);
            if (Objects.equals(u.tp.typename, "void")) throw new semanticError("Void Error", it.pos);
            for(int j = 0; j < u.lis.size(); j++) {
                nd.defVariable(u.lis.get(j).name, u.tp, it.pos);
            }
        }
        for (int i = 0; i < it.funcLis.size(); i++) {
            func_defNode u = it.funcLis.get(i);
            if (Objects.equals(u.name, it.name)) throw new semanticError("Bad Function name", u.pos);
            if (nd.members.containsKey(u.name)) throw new semanticError("Bad Function name", u.pos);
            if (u.ls != null) {
                funcClass f = new funcClass(u.tp, u.name, u.ls.tpLis, u);
                nd.addMethod(u.name, f, u.pos);
            } else {
                List<Type> ls = new ArrayList<>();
                funcClass f = new funcClass(u.tp, u.name, ls, u);
                nd.addMethod(u.name, f, u.pos);
            }
        }
        if (it.nd != null) {
            if (!Objects.equals(it.nd.name, it.name)) throw new semanticError("Wrong Constructor Name", it.nd.pos);
            nd.nd = it.nd;
        }
        gScope.addClass(it.name, nd, it.pos);
    }
    public void visit(variable_defNode it) {}
    public void visit(main_defNode it){
        funcClass f = new funcClass(it.tp, "main", null, null);
        gScope.addFunc("main", f, it.pos);
        // to do
    }
    public void visit(class_constructorNode it){}
    public void visit(func_defNode it) {
        if (gScope.classes.containsKey(it.name)) throw new semanticError("Bad function name same as class", it.pos);
        if (it.ls != null) {
            for (int i = 0; i < it.ls.tpLis.size(); i++) {
                Type tp = it.ls.tpLis.get(i);
                if (tp.typename == "void") throw new semanticError("Void Error", it.pos);
            }
            funcClass f = new funcClass(it.tp, it.name, it.ls.tpLis, it);
            gScope.addFunc(it.name, f, it.pos);
        } else {
            List<Type> o = new ArrayList<>();
            funcClass f = new funcClass(it.tp, it.name, o, it);
            gScope.addFunc(it.name, f, it.pos);
        }
    }
    public void visit(suiteNode it){}
    public void visit(statementNode it){}
    public void visit(exp_statNode it){}
    public void visit(def_statNode it){}
    public void visit(continue_statNode it){}
    public void visit(break_statNode it){}
    public void visit(return_statNode it){}
    public void visit(deffor_statNode it){}
    public void visit(expfor_statNode it){}
    public void visit(if_statNode it){}
    public void visit(while_statNode it){}
    public void visit(paralistNode it){}
    public void visit(empty_statNode it){}
    public void visit(varinitNode it){}
    public void visit(iden_exprNode it){}
    public void visit(literal_exprNode it){}
    public void visit(class_call_exprNode it){}
    public void visit(class_exprNode it){}
    public void visit(array_exprNode it){}
    public void visit(func_exprNode it){}
    public void visit(paren_exprNode it){}
    public void visit(rightAddExprNode it){}
    public void visit(leftAddExprNode it){}
    public void visit(not_exprNode it){}
    public void visit(new_exprNode it){}
    public void visit(biexprNode it){}
    public void visit(tri_exprNode it){}
    public void visit(assign_exprNode it){}
    public void visit(expressionNode it){}
    public void visit(new_typeNode it){}
    public void visit(func_call_listNode it){}
    public void visit(typeNode it){}
}
