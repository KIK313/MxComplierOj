package frontend;
import ast.*;
import ast.ASTVisitor;
import utl.Scope;
import utl.Type;
import utl.error.semanticError;
import utl.globalScope;
import utl.funcClass;
import utl.classBuild;

import javax.lang.model.element.TypeElement;
import java.util.Objects;

public class SemanticChecker implements ASTVisitor {
    public String currentClass = null;
    public String currentFunc = null;
    public globalScope gScope;
    public boolean isReturn = false;
    public int loopCnt;
    public boolean isInMain;
    public Scope currentScope;
    public boolean canOpen = false;
    public SemanticChecker(globalScope g) {
        this.gScope = g;
        currentScope = g;
        loopCnt = 0;
    }
    public void visit(ProgramNode it) {
        for(int i = 0; i < it.lis.size(); i++) {
            it.lis.get(i).accept(this);
        }
    }
    public void visit(class_defNode it) {
        currentScope = new Scope(currentScope);
        currentClass = it.name;
        for (int i = 0; i < it.varLis.size(); i++) {
            it.varLis.get(i).accept(this);
        }
        if (it.nd != null) it.nd.accept(this);
        for (int i = 0; i < it.funcLis.size(); i++) {
            it.funcLis.get(i).accept(this);
        }
        currentScope = currentScope.parentScope;
        currentClass = null;
    }
    public void visit(variable_defNode it) {
        if (!gScope.types.contains(it.tp.typename)) throw new semanticError("Un exist type", it.pos);
        if (Objects.equals(it.tp.typename, "void")) throw new semanticError("void variable type", it.pos);
        for (int i = 0; i < it.lis.size(); i++) {
            varinitNode nd = it.lis.get(i);
            nd.accept(this);
            if (nd.nd != null) {
                if (!it.tp.equal(nd.nd.nodeType)) throw new semanticError("Un match type in definition", nd.pos);
            }
            if (currentScope.containsVariable(nd.name, false)) throw new semanticError("Redefinition of variable", nd.pos);
            if (gScope.getFunc(nd.name) != null) throw new semanticError("Bad variable name same as function", nd.pos);
            if (currentClass != null) {
                if (gScope.classes.get(currentClass).methods.containsKey(nd.name))
                    throw new semanticError("Bad variable name same as method", nd.pos);
            }
            currentScope.defVariable(nd.name, it.tp, nd.pos);
        }
    }
    public void visit(main_defNode it) {
        currentScope = new Scope(currentScope);
        isInMain = true;
        currentFunc = "main";
        it.nd.accept(this);
        currentFunc = null;
        isInMain = false;
        currentScope = currentScope.parentScope;
    }
    public void visit(class_constructorNode it) {
        currentScope = new Scope(currentScope);
        currentFunc = it.name;
        it.nd.accept(this);
        currentFunc = null;
        currentScope = currentScope.parentScope;
    }
    public void visit(func_defNode it) {
        currentScope = new Scope(currentScope);
        currentFunc = it.name;
        if (it.ls != null) it.ls.accept(this);
        canOpen = false;
        isReturn = false;
        it.nd.accept(this);
        if ((!it.tp.equal(new Type("void")))&&(!isReturn)) throw new semanticError("function should have return", it.pos);
        currentFunc = null;
        currentScope = currentScope.parentScope;
    }
    public void visit(suiteNode it) {
        boolean flag = canOpen;
        if (canOpen) {
            currentScope = new Scope(currentScope);
        }
        boolean is = false;
        for (int i = 0; i < it.lis.size(); i++) {
            canOpen = true;
            isReturn = false;
            it.lis.get(i).accept(this);
            if (isReturn) is = true;
        }
        if (flag) {
            currentScope = currentScope.parentScope;
        }
        isReturn = is;
    }
    public void visit(exp_statNode it) {
        it.nd.accept(this);
    }
    public void visit(def_statNode it) {
        it.nd.accept(this);
    }
    public void visit(continue_statNode it) {
        if (loopCnt == 0) throw new semanticError("continue under no loop condition", it.pos);
    }
    public void visit(break_statNode it) {
        if (loopCnt == 0) throw new semanticError("break under no loop condition", it.pos);
    }
    public void visit(return_statNode it) {
        isReturn = true;
        if (currentFunc == null) throw new semanticError("return under no function condition", it.pos);
        if (Objects.equals(currentFunc, currentClass)) {
            if (it.nd != null) throw new semanticError("the return type should be null", it.pos);
            return;
        }
        funcClass f = null;
        if (currentClass == null) f = gScope.getFunc(currentFunc);
        else f = gScope.getClass(currentClass).getMethod(currentFunc);
        Type tp = f.returnType;
        if (Objects.equals(tp.typename, "void")) {
            if (it.nd != null) throw new semanticError("wrong return type in void function", it.pos);
        } else {
            it.nd.accept(this);
            if (!it.nd.nodeType.equal(f.returnType)) throw new semanticError("Wrong return type in non void function", it.pos);
        }
    }
    public void visit(deffor_statNode it) {
        currentScope = new Scope(currentScope);
        loopCnt++;
        if (it.nd != null) it.nd.accept(this);
        if (it.con != null) {
            it.con.accept(this);
            if (!it.con.nodeType.equal(new Type("bool"))) throw new semanticError("condition in defFor is not bool", it.pos);
        }
        if (it.stp != null) it.stp.accept(this);
        canOpen = false;
        it.stat.accept(this);
        loopCnt--;
        currentScope = currentScope.parentScope;
    }
    public void visit(expfor_statNode it) {
        currentScope = new Scope(currentScope);
        loopCnt++;
        if (it.nd != null) it.nd.accept(this);
        if (it.con != null) {
            it.con.accept(this);
            if (!it.con.nodeType.equal(new Type("bool"))) throw new semanticError("condition in expFor is not bool", it.pos);
        }
        if (it.stp != null) it.stp.accept(this);
        canOpen = false;
        it.stat.accept(this);
        loopCnt--;
        currentScope = currentScope.parentScope;
    }
    public void visit(if_statNode it) {
        currentScope = new Scope(currentScope);
        boolean flag = canOpen;
        boolean is = true;
        it.con.accept(this);
        if (!it.con.nodeType.equal(new Type("bool"))) throw new semanticError("condition in if is not bool", it.pos);
        isReturn = false;
        canOpen = false;
        it.thenst.accept(this);
        currentScope = currentScope.parentScope;
        is = is && isReturn;
        isReturn = false;
        if (it.elsest != null) {
            currentScope = new Scope(currentScope);
            canOpen = false;
            it.elsest.accept(this);
            currentScope = currentScope.parentScope;
            is = is && isReturn;
        } else is = false;
        canOpen = flag;
        isReturn = is;
    }
    public void visit(while_statNode it) {
        currentScope = new Scope(currentScope);
        loopCnt++;
        it.con.accept(this);
        if (!it.con.nodeType.equal(new Type("bool"))) throw new semanticError("condition in while is not bool", it.pos);
        canOpen = false;
        it.nd.accept(this);
        loopCnt--;
        currentScope = currentScope.parentScope;
    }
    public void visit(paralistNode it) {
        for (int i = 0; i < it.tpLis.size(); i++) {
            //if (gScope.functions.get(it.name.get(i)) != null) throw new semanticError("terrible function parameter name", it.pos);
            currentScope.defVariable(it.name.get(i), it.tpLis.get(i), it.pos);
        }
    }
    public void visit(iden_exprNode it) {
        Type tp = currentScope.getType(it.name, true);
        if (tp == null) throw new semanticError("undefined variable in expr", it.pos);
        it.nodeType = tp;
        it.nodeType.isAssign = true;
    }
    public void visit(literal_exprNode it) {
        if (it.nodeType.equal(new Type("this"))) {
            if (currentClass == null) throw new semanticError("this can't be used outside class", it.pos);
            it.nodeType = new Type(new String(currentClass));
        }
    }
    public void visit(class_call_exprNode it) {
        it.nd.accept(this);
        if (it.nd.nodeType.dim > 0) {
            if (Objects.equals(it.funcname, "size") && it.funcCallLis == null) it.nodeType = new Type("int");
            else throw new semanticError("Array can't be used in class call", it.pos);
        } else {
            classBuild u = gScope.getClass(it.nd.nodeType.typename);
            if (u == null) throw new semanticError("Can not find this class", it.pos);
            funcClass f = u.getMethod(it.funcname);
            if (f == null) throw new semanticError("Can not find this method in class", it.pos);
            if (it.funcCallLis == null) {
                if (f.parameterList.size() != 0) throw new semanticError("unmatched argument size", it.pos);
            } else {
                if (it.funcCallLis.lis.size() != f.parameterList.size()) throw new semanticError("unmatched argument size", it.pos);
                for (int i = 0; i < f.parameterList.size(); i++) {
                    expressionNode nd = it.funcCallLis.lis.get(i);
                    nd.accept(this);
                    if (!nd.nodeType.equal(f.parameterList.get(i))) throw new semanticError("unmatched argument type", it.pos);
                }
            }
            it.nodeType = f.returnType;
        }
    }
    public void visit(class_exprNode it) {
        it.nd.accept(this);
        if (it.nd.nodeType.dim > 0) throw new semanticError("the array pointer can't use class members", it.pos);
        classBuild c = gScope.getClass(it.nd.nodeType.typename);
        if (c == null) throw new semanticError("can't find the class name", it.pos);
        Type tp = c.getType(it.name);
        if (tp == null) throw new semanticError("can't find class member", it.pos);
        it.nodeType = new Type(tp);
        it.nodeType.isAssign = true;
    }
    public void visit(array_exprNode it) {
        it.nd.accept(this);
        if (it.nd.nodeType.dim < 1) throw new semanticError("array dimension wrong", it.pos);
        if (it.nd instanceof new_exprNode) throw new semanticError("wrong new expression array", it.pos);
        it.id.accept(this);
        if (!it.id.nodeType.equal(new Type("int"))) throw new semanticError("array id is not int", it.pos);
        it.nodeType = new Type(it.nd.nodeType);
        it.nodeType.dim--;
    }
    public void visit(func_exprNode it) {
        funcClass f = null;
        if (currentClass == null) {
            f = gScope.getFunc(it.funcname);
        } else {
            f = gScope.getClass(currentClass).methods.get(it.funcname);
            if (f == null) f = gScope.getFunc(it.funcname);
        }
        if (f == null) throw new semanticError("NonExist function", it.pos);
        if (it.nd == null) {
            if (f.parameterList.size() != 0) throw new semanticError("Unmatched argument size", it.pos);
        } else {
            if (f.parameterList.size() != it.nd.lis.size())
                throw new semanticError("Unmatched argument size", it.pos);
            for (int i = 0; i < it.nd.lis.size(); i++) {
                expressionNode nd = it.nd.lis.get(i);
                nd.accept(this);
                if (!nd.nodeType.equal(f.parameterList.get(i)))
                    throw new semanticError("Unmatched argument type", it.pos);
            }
        }
        it.nodeType = new Type(f.returnType);
        it.nodeType.isAssign = false;
    }
    public void visit(paren_exprNode it) {
        it.son.accept(this);
        it.nodeType = it.son.nodeType;
    }
    public void visit(rightAddExprNode it) {
        it.nd.accept(this);
        if (!it.nd.nodeType.isAssign) throw new semanticError("the expression cannot be ++  or --", it.pos);
        if (!it.nd.nodeType.equal(new Type("int"))) throw new semanticError("the expression with ++ or -- is not int", it.pos);
        it.nodeType = new Type(it.nd.nodeType);
        it.nodeType.isAssign = false;
    }
    public void visit(leftAddExprNode it) {
        it.nd.accept(this);
        if (!it.nd.nodeType.isAssign) throw new semanticError("the expression can't be ++  or --", it.pos);
        if (!it.nd.nodeType.equal(new Type("int"))) throw new semanticError("the expression with ++ or -- is not int", it.pos);
        it.nodeType = it.nd.nodeType;
    }
    public void visit(not_exprNode it) {
        it.nd.accept(this);
        if (Objects.equals(it.op, "!")) {
            if (!it.nd.nodeType.equal(new Type("bool"))) throw new semanticError("the expression behind ! is not bool", it.pos);
        }
        if (Objects.equals(it.op, "-")) {
            if (!it.nd.nodeType.equal(new Type("int"))) throw new semanticError("the expression behind - is not int", it.pos);
        }
        if (Objects.equals(it.op, "~")) {
            if (!it.nd.nodeType.equal(new Type("int"))) throw new semanticError("the expression behind ~ is not int", it.pos);
        }
        it.nodeType = it.nd.nodeType;
    }
    public void visit(new_exprNode it) {
        it.nd.accept(this);
        it.nodeType = it.nd.tp; if(!gScope.types.contains(it.nd.tp.typename)) throw new semanticError("un exist type in new expr", it.pos);
        for (int i = 0; i < it.nd.lis.size(); i++) {
            expressionNode nd = it.nd.lis.get(i);
            nd.accept(this);
            if (!nd.nodeType.equal(new Type("int"))) throw new semanticError("the index in array must be int", nd.pos);
        }
    }
    public void visit(biexprNode it) {
        it.ls.accept(this); it.rs.accept(this);
        if (!it.ls.nodeType.equal(it.rs.nodeType)) throw new semanticError("unmatched type in biExpr", it.pos);
        switch (it.op) {
            case "*", "/", "%", "-", "<<", ">>", "&", "^", "|"  -> {
                if (!it.ls.nodeType.equal(new Type("int"))) throw new semanticError("type should be int", it.pos);
                it.nodeType = it.ls.nodeType;
            }
            case "<", ">", "<=", ">=" -> {
                if (!(it.ls.nodeType.equal(new Type("int")) || (it.ls.nodeType.equal(new Type("string")))))
                    throw new semanticError("type should be int", it.pos);
                it.nodeType = new Type("bool");
            }
            case "+" -> {
                if (!(it.ls.nodeType.equal(new Type("int")) ||it.ls.nodeType.equal(new Type("string"))))
                    throw new semanticError("add wrong", it.pos);
                it.nodeType = it.ls.nodeType;
            }
            case "==", "!=" -> {
                it.nodeType = new Type("bool");
            }
            case "&&", "||" -> {
                if (!it.ls.nodeType.equal(new Type("bool"))) throw new semanticError("bool wrong", it.pos);
                it.nodeType = it.ls.nodeType;
            }
        }
    }
    public void visit(tri_exprNode it) {
        it.con.accept(this);
        if (!it.con.nodeType.equal(new Type("bool"))) throw new semanticError("condition in tri expression must be bool", it.pos);
        it.ls.accept(this); it.rs.accept(this);
        if (!it.ls.nodeType.equal(it.rs.nodeType)) throw new semanticError("tri expression return types don't match", it.pos);
        it.nodeType = it.ls.nodeType;
    }
    public void visit(assign_exprNode it) {
        it.ls.accept(this);
        it.rs.accept(this);
        if (!it.ls.nodeType.isAssign) throw new semanticError("left expression can't be assigned", it.pos);
        if (Objects.equals(it.rs.nodeType.typename, "null")) {
            if (it.ls.nodeType.dim == 0 &&
                    (it.ls.nodeType.equal(new Type("int"))||it.ls.nodeType.equal(new Type("bool"))||it.ls.nodeType.equal(new Type("string")))) throw new semanticError("null can't assign non array", it.pos);
            it.nodeType = new Type(it.ls.nodeType); it.nodeType.isAssign = false;
        } else {
            if (!it.ls.nodeType.equal(it.rs.nodeType)) throw new semanticError("left and right expression don't match", it.pos);
            it.nodeType = new Type(it.rs.nodeType); it.nodeType.isAssign = false;
        }
    }
    public void visit(varinitNode it) {
        if (it.nd != null) {
            it.nd.accept(this);
        }
    }

    public void visit(new_typeNode it) {}
    public void visit(empty_statNode it) {}
    public void visit(typeNode it) {}
    public void visit(func_call_listNode it) {}
}
