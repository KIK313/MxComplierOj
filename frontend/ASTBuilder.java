package frontend;
import ast.*;
import parser.mxParser;
import parser.mxBaseVisitor;
import utl.Type;
import utl.error.semanticError;
import utl.position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ASTBuilder extends mxBaseVisitor<ASTNode> {


    @Override
    public ASTNode visitParen_expr(mxParser.Paren_exprContext ctx) {
        return new paren_exprNode(new position(ctx), (expressionNode)visit(ctx.expression()));
    }
    @Override
    public ASTNode visitFunc_expr(mxParser.Func_exprContext ctx) {
        func_call_listNode u = null;
        if (ctx.func_call_list() != null) u = (func_call_listNode) visit(ctx.func_call_list());
        return new func_exprNode(new position(ctx), ctx.Identifier().getText(), u);
    }
    @Override
    public ASTNode visitNew_expr(mxParser.New_exprContext ctx) {
        return new new_exprNode(new position(ctx), (new_typeNode)visit(ctx.new_expression().new_type()));
    }
    @Override
    public ASTNode visitAssign_expr(mxParser.Assign_exprContext ctx) {
        return new assign_exprNode(new position(ctx),
                (expressionNode)visit(ctx.l), (expressionNode)visit(ctx.r));
    }
    @Override
    public ASTNode visitIden_expr(mxParser.Iden_exprContext ctx) {
        return new iden_exprNode(new position(ctx), ctx.getText());
    }
    @Override
    public ASTNode visitRightadd_expr(mxParser.Rightadd_exprContext ctx) {
        return new rightAddExprNode(new position(ctx),
                ctx.op.getText(), (expressionNode)visit(ctx.expression()));
    }
    @Override
    public ASTNode visitBiexpr(mxParser.BiexprContext ctx) {
        return new biexprNode(new position(ctx),
                ctx.op.getText(), (expressionNode)visit(ctx.l), (expressionNode)visit(ctx.r));
    }

    @Override
    public ASTNode visitTri_expr(mxParser.Tri_exprContext ctx) {
        return new tri_exprNode(new position(ctx),
                (expressionNode)visit(ctx.expression(0)), (expressionNode)visit(ctx.expression(1)), (expressionNode)visit(ctx.expression(2)));
    }
    @Override
    public ASTNode visitArray_expr(mxParser.Array_exprContext ctx) {
        return new array_exprNode(new position(ctx),
                (expressionNode)visit(ctx.expression(0)), (expressionNode)visit(ctx.expression(1)));
    }
    @Override
    public ASTNode visitNot_expr(mxParser.Not_exprContext ctx) {
        return new not_exprNode(new position(ctx),
                ctx.op.getText(), (expressionNode)visit(ctx.expression()));
    }
    @Override
    public ASTNode visitClass_call_expr(mxParser.Class_call_exprContext ctx) {
        func_call_listNode u = null;
        if (ctx.func_call_list() != null) u = (func_call_listNode) visit(ctx.func_call_list());
        return new class_call_exprNode(new position(ctx),
                (expressionNode)visit(ctx.expression()), ctx.Identifier().getText(), u);
    }
    @Override
    public ASTNode visitClass_expr(mxParser.Class_exprContext ctx) {
        return new class_exprNode(new position(ctx),
                (expressionNode)visit(ctx.expression()), ctx.Identifier().getText());
    }
    @Override
    public ASTNode visitLiteral_expr(mxParser.Literal_exprContext ctx) {
        return new literal_exprNode(new position(ctx),
                ctx.literal().getText());
    }
    @Override
    public ASTNode visitLeftadd_expr(mxParser.Leftadd_exprContext ctx) {
        return new leftAddExprNode(new position(ctx),
                ctx.op.getText(), (expressionNode)visit(ctx.expression()));
    }
    @Override
    public ASTNode visitNew_basic(mxParser.New_basicContext ctx) {
        List<expressionNode> ls = new ArrayList<>();
        for(mxParser.ExpressionContext o : ctx.expression()) {
            ls.add((expressionNode)visit(o));
        }
        return new new_typeNode(new position(ctx),
                new Type(ctx.basictype().getText(), ctx.LeftBracket().size()) , ls);
    }
    @Override
    public ASTNode visitNew_class(mxParser.New_classContext ctx) {
        List<expressionNode> ls = new ArrayList<>();
        for(mxParser.ExpressionContext o : ctx.expression()) {
            ls.add((expressionNode) visit(o));
        }
        return new new_typeNode(new position(ctx),
                new Type(ctx.Identifier().getText(), ctx.LeftBracket().size()), ls);
    }
    @Override
    public ASTNode visitFunc_call_list(mxParser.Func_call_listContext ctx) {
        List<expressionNode> ls = new ArrayList<>();
        for(mxParser.ExpressionContext o : ctx.expression()) {
            ls.add((expressionNode) visit(o));
        }
        return new func_call_listNode(new position(ctx),
                ls);
    }
    @Override
    public ASTNode visitBlock_stat(mxParser.Block_statContext ctx) {
        return visitSuite(ctx.suite());
    }
    @Override
    public ASTNode visitSuite(mxParser.SuiteContext ctx) {
        List<statementNode> ls = new ArrayList<>();
        for(mxParser.StatementContext o : ctx.statement()) {
            ls.add((statementNode)visit(o));
        }
        return new suiteNode(new position(ctx), ls);
    }
    @Override
    public ASTNode visitExp_stat(mxParser.Exp_statContext ctx) {
        return new exp_statNode(new position(ctx), (expressionNode)visit(ctx.expression()));
    }
    @Override
    public ASTNode visitDef_stat(mxParser.Def_statContext ctx) {
        return new def_statNode(new position(ctx), (variable_defNode)visit(ctx.variable_def()));
    }
    @Override
    public ASTNode visitContinue_stat(mxParser.Continue_statContext ctx) {
        return new continue_statNode(new position(ctx));
    }
    @Override
    public ASTNode visitBreak_stat(mxParser.Break_statContext ctx) {
        return new break_statNode(new position(ctx));
    }
    @Override
    public ASTNode visitReturn_stat(mxParser.Return_statContext ctx) {
        expressionNode nd = null;
        if (ctx.expression() != null) {
            nd = (expressionNode)visit(ctx.expression());
        }
        return new return_statNode(new position(ctx), nd);
    }
    @Override
    public ASTNode visitWhile_stat(mxParser.While_statContext ctx) {
        return new while_statNode(new position(ctx),
                (expressionNode)visit(ctx.expression()), (statementNode)visit(ctx.statement()));
    }
    @Override
    public ASTNode visitDeffor_stat(mxParser.Deffor_statContext ctx) {
        variable_defNode nd = null;
        if (ctx.init != null) {
            nd = (variable_defNode) visit(ctx.init);
        }
        expressionNode pd = null;
        if (ctx.con != null) {
            pd = (expressionNode) visit(ctx.con);
        }
        expressionNode stp = null;
        if (ctx.stp != null) {
            stp = (expressionNode) visit(ctx.stp);
        }
        return new deffor_statNode(new position(ctx), nd, pd, stp, (statementNode) visit(ctx.statement()));
    }

    @Override
    public ASTNode visitExpfor_stat(mxParser.Expfor_statContext ctx) {
        expressionNode nd = null;
        if (ctx.init != null) {
            nd = (expressionNode) visit(ctx.init);
        }
        expressionNode pd = null;
        if (ctx.con != null) {
            pd = (expressionNode) visit(ctx.con);
        }
        expressionNode stp = null;
        if (ctx.stp != null) {
            stp = (expressionNode) visit(ctx.stp);
        }
        return new expfor_statNode(new position(ctx), nd, pd, stp, (statementNode) visit(ctx.statement()));
    }
    @Override
    public ASTNode visitIf_stat(mxParser.If_statContext ctx) {
        expressionNode nd = (expressionNode) visit(ctx.con);
        statementNode thenst = (statementNode) visit(ctx.thenst);
        statementNode elst = null;
        if (ctx.elst != null) {
            elst = (statementNode) visit(ctx.elst);
        }
        return new if_statNode(new position(ctx), nd, thenst, elst);
    }
    @Override
    public ASTNode visitEmpty_stat(mxParser.Empty_statContext ctx) {
        return new empty_statNode(new position(ctx));
    }
    @Override
    public ASTNode visitProgram(mxParser.ProgramContext ctx) {
        List<ProgramComp> ls = new ArrayList<>();
        for(mxParser.Program_compContext o : ctx.program_comp()) {
            ls.add((ProgramComp) visit(o));
        }
        int cnt = 0; int id = 0; position pos = null; suiteNode sn = null;
        for(int i = 0; i < ls.size(); i++) {
            ProgramComp nd = ls.get(i);
            if (nd instanceof func_defNode) {
                if (Objects.equals(((func_defNode) nd).name, "main")) {
                    if (((func_defNode)nd).ls != null)
                        if (((func_defNode) nd).ls.tpLis.size() > 0) throw new semanticError("Bad main", nd.pos);
                    if (!Objects.equals( ((func_defNode) nd).tp.typename, "int")) {
                        throw new semanticError("Bad main", nd.pos);
                    }
                    cnt++; id = i; pos = nd.pos; sn = ((func_defNode)nd).nd;
                }
            }
        }
        if (cnt != 1) throw new semanticError("More or Less int main()", new position(ctx));
        main_defNode nd = new main_defNode(pos, sn);
        ls.set(id, nd);
        return new ProgramNode(new position(ctx), ls);
    }
    @Override
    public ASTNode visitProgram_comp(mxParser.Program_compContext ctx) {
        if (ctx.class_def() != null) return visit(ctx.class_def());
        if (ctx.func_def() != null) return visit(ctx.func_def());
        return visit(ctx.variable_def());
    }
    @Override
    public ASTNode visitClass_def(mxParser.Class_defContext ctx) {
        List<func_defNode> ls = new ArrayList<>();
        for(mxParser.Func_defContext o : ctx.func_def()) {
            ls.add((func_defNode) visit(o));
        }
        List<variable_defNode> lss = new ArrayList<>();
        for(mxParser.Def_type_classContext o : ctx.def_type_class()) {
            lss.add((variable_defNode) visit(o));
        }
        if (ctx.class_constructor().size() > 1) {
            throw new semanticError("Multiple Definition of Constructor", new position(ctx));
        }
        class_constructorNode nd = null;
        if (ctx.class_constructor().size() > 0 ) {
            nd = (class_constructorNode) visit(ctx.class_constructor(0));
        }
        return new class_defNode(new position(ctx), ctx.Identifier().getText(), ls, lss, nd);
    }
    @Override
    public ASTNode visitClass_constructor(mxParser.Class_constructorContext ctx) {
        return new class_constructorNode(new position(ctx), (suiteNode) visit(ctx.suite()), ctx.Identifier().getText());
    }
    @Override
    public ASTNode visitDef_type_class(mxParser.Def_type_classContext ctx) {
        List<varinitNode> lis = new ArrayList<>();
        for(int i = 0; i < ctx.Identifier().size(); i++) {
            lis.add(new varinitNode(new position(ctx), ctx.Identifier(i).getText(), null));
        }
        return new variable_defNode(new position(ctx), new Type((typeNode) visit(ctx.type())), lis);
    }
    @Override
    public ASTNode visitParameterlist(mxParser.ParameterlistContext ctx) {
        List<Type> ls = new ArrayList<>();
        List<String> name = new ArrayList<>();
        for(int i = 0; i < ctx.Identifier().size(); i++) {
            ls.add(new Type((typeNode) visit(ctx.type(i))));
            name.add(ctx.Identifier(i).getText());
        }
        return new paralistNode(new position(ctx), ls, name);
    }

    @Override
    public ASTNode visitVariable_def(mxParser.Variable_defContext ctx) {
        List<varinitNode> ls = new ArrayList<>();
        typeNode tp = (typeNode) visit(ctx.type());
        for(mxParser.VarinitContext o : ctx.varinit()) {
            ls.add((varinitNode) visit(o));
        }
        return new variable_defNode(new position(ctx), new Type(tp), ls);
    }
    @Override
    public ASTNode visitVarinit(mxParser.VarinitContext ctx) {
        String s;
        expressionNode nd = null;
        s = ctx.Identifier().getText();
        if (ctx.expression() != null) {
            nd = (expressionNode) visit(ctx.expression());
        }
        return new varinitNode(new position(ctx), s, nd);
    }
    @Override
    public ASTNode visitFunc_def(mxParser.Func_defContext ctx) {
        paralistNode nd = null;
        if (ctx.parameterlist() != null) nd = (paralistNode) visit(ctx.parameterlist());
        return new func_defNode(new position(ctx), new Type((typeNode)visit(ctx.type())), ctx.Identifier().getText(),
                (suiteNode)visit(ctx.suite()), nd);
    }
    @Override
    public ASTNode visitBasic_type(mxParser.Basic_typeContext ctx) {
        return new typeNode(new position(ctx), ctx.basictype().getText(), ctx.LeftBracket().size());
    }
    @Override
    public ASTNode visitClass_type(mxParser.Class_typeContext ctx) {
        return new typeNode(new position(ctx), ctx.Identifier().getText(), ctx.LeftBracket().size());
    }
    @Override
    public ASTNode visitBasictype(mxParser.BasictypeContext ctx) {
        return new typeNode(new position(ctx), ctx.getText(), 0);
    }
    @Override
    public ASTNode visitLiteral(mxParser.LiteralContext ctx) {
        return new literal_exprNode(new position(ctx), ctx.getText());
    }
}
