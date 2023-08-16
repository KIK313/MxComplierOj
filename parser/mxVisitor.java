package parser;// Generated from mx.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link mxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface mxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(mxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#program_comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_comp(mxParser.Program_compContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#class_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_def(mxParser.Class_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#def_type_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_type_class(mxParser.Def_type_classContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#class_constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_constructor(mxParser.Class_constructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_def(mxParser.Func_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#parameterlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterlist(mxParser.ParameterlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(mxParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_stat(mxParser.Block_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exp_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_stat(mxParser.Exp_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code def_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_stat(mxParser.Def_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continue_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_stat(mxParser.Continue_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stat(mxParser.Break_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stat(mxParser.Return_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(mxParser.While_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code deffor_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeffor_stat(mxParser.Deffor_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expfor_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpfor_stat(mxParser.Expfor_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(mxParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code empty_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_stat(mxParser.Empty_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#variable_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_def(mxParser.Variable_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#varinit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarinit(mxParser.VarinitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen_expr(mxParser.Paren_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code func_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_expr(mxParser.Func_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_expr(mxParser.New_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_expr(mxParser.Assign_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iden_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIden_expr(mxParser.Iden_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rightadd_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightadd_expr(mxParser.Rightadd_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code biexpr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBiexpr(mxParser.BiexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tri_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTri_expr(mxParser.Tri_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_expr(mxParser.Array_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_expr(mxParser.Not_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_call_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_call_expr(mxParser.Class_call_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_expr(mxParser.Class_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_expr(mxParser.Literal_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leftadd_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftadd_expr(mxParser.Leftadd_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#new_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_expression(mxParser.New_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new_basic}
	 * labeled alternative in {@link mxParser#new_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_basic(mxParser.New_basicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new_class}
	 * labeled alternative in {@link mxParser#new_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_class(mxParser.New_classContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#func_call_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call_list(mxParser.Func_call_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basic_type}
	 * labeled alternative in {@link mxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasic_type(mxParser.Basic_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_type}
	 * labeled alternative in {@link mxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_type(mxParser.Class_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#basictype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasictype(mxParser.BasictypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(mxParser.LiteralContext ctx);
}