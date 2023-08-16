package utl;
import ast.typeNode;

import java.util.Objects;

public class Type {
    public boolean isBool = false;
    public boolean isInt = false;
    public boolean isString = false;
    public boolean isThis = false;
    public boolean isClass = false;
    public boolean isVoid = false;
    public boolean isNull = false;
    public boolean isAssign = false;
    public String typename;
    public int dim = 0;
    public Type() {

    }
    public Type(typeNode nd) {
        this.dim = nd.dim;
        this.typename = nd.name;
    }
    public Type(String name) {
        this.typename = name;
        this.dim = 0;
    }
    public Type(String name, int dim){
        this.typename = name;
        this.dim = dim;
    }
    public Type(Type other) {
        this.typename = other.typename;
        this.isBool = other.isBool;
        this.dim = other.dim;
        this.isClass = other.isClass;
        this.isVoid = other.isVoid;
        this.isThis = other.isThis;
        this.isInt = other.isInt;
        this.isNull = other.isNull;
        this.isAssign = other.isAssign;
        this.isString = other.isString;
    }
    public boolean equal(Type other) {
        if (this.dim == other.dim && Objects.equals(this.typename, other.typename)) return true;
        if (Objects.equals(this.typename, "null")) {
            if (((!Objects.equals(other.typename,"int"))&&(!Objects.equals(other.typename, "bool"))
                    &&(!Objects.equals(other.typename, "string"))&&(!Objects.equals(other.typename, "this")))||other.dim > 0)
                return true;
            return false;
        }
        if (Objects.equals(other.typename, "null")) {
            if (((!Objects.equals(this.typename,"int"))&&(!Objects.equals(this.typename, "bool"))
                    &&(!Objects.equals(this.typename, "string"))&&(!Objects.equals(this.typename,"this")))||this.dim > 0)
                return true;
            return false;
        }
        return false;
    }
}
