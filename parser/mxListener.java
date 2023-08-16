package parser;// Generated from mx.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mxParser}.
 */
public interface mxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(mxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(mxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#program_comp}.
	 * @param ctx the parse tree
	 */
	void enterProgram_comp(mxParser.Program_compContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#program_comp}.
	 * @param ctx the parse tree
	 */
	void exitProgram_comp(mxParser.Program_compContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(mxParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(mxParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#def_type_class}.
	 * @param ctx the parse tree
	 */
	void enterDef_type_class(mxParser.Def_type_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#def_type_class}.
	 * @param ctx the parse tree
	 */
	void exitDef_type_class(mxParser.Def_type_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#class_constructor}.
	 * @param ctx the parse tree
	 */
	void enterClass_constructor(mxParser.Class_constructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#class_constructor}.
	 * @param ctx the parse tree
	 */
	void exitClass_constructor(mxParser.Class_constructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def(mxParser.Func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def(mxParser.Func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#parameterlist}.
	 * @param ctx the parse tree
	 */
	void enterParameterlist(mxParser.ParameterlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#parameterlist}.
	 * @param ctx the parse tree
	 */
	void exitParameterlist(mxParser.ParameterlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(mxParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(mxParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_stat(mxParser.Block_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_stat(mxParser.Block_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exp_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExp_stat(mxParser.Exp_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exp_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExp_stat(mxParser.Exp_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code def_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDef_stat(mxParser.Def_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code def_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDef_stat(mxParser.Def_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continue_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinue_stat(mxParser.Continue_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continue_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinue_stat(mxParser.Continue_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreak_stat(mxParser.Break_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreak_stat(mxParser.Break_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stat(mxParser.Return_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stat(mxParser.Return_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stat(mxParser.While_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stat(mxParser.While_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code deffor_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeffor_stat(mxParser.Deffor_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code deffor_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeffor_stat(mxParser.Deffor_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expfor_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpfor_stat(mxParser.Expfor_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expfor_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpfor_stat(mxParser.Expfor_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(mxParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(mxParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code empty_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_stat(mxParser.Empty_statContext ctx);
	/**
	 * Exit a parse tree produced by the {@code empty_stat}
	 * labeled alternative in {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_stat(mxParser.Empty_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#variable_def}.
	 * @param ctx the parse tree
	 */
	void enterVariable_def(mxParser.Variable_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#variable_def}.
	 * @param ctx the parse tree
	 */
	void exitVariable_def(mxParser.Variable_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#varinit}.
	 * @param ctx the parse tree
	 */
	void enterVarinit(mxParser.VarinitContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#varinit}.
	 * @param ctx the parse tree
	 */
	void exitVarinit(mxParser.VarinitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen_expr(mxParser.Paren_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen_expr(mxParser.Paren_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code func_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunc_expr(mxParser.Func_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code func_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunc_expr(mxParser.Func_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNew_expr(mxParser.New_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNew_expr(mxParser.New_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(mxParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(mxParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iden_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIden_expr(mxParser.Iden_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iden_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIden_expr(mxParser.Iden_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rightadd_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRightadd_expr(mxParser.Rightadd_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rightadd_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRightadd_expr(mxParser.Rightadd_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code biexpr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBiexpr(mxParser.BiexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code biexpr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBiexpr(mxParser.BiexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tri_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTri_expr(mxParser.Tri_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tri_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTri_expr(mxParser.Tri_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArray_expr(mxParser.Array_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArray_expr(mxParser.Array_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot_expr(mxParser.Not_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot_expr(mxParser.Not_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class_call_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterClass_call_expr(mxParser.Class_call_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class_call_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitClass_call_expr(mxParser.Class_call_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterClass_expr(mxParser.Class_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitClass_expr(mxParser.Class_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_expr(mxParser.Literal_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_expr(mxParser.Literal_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leftadd_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLeftadd_expr(mxParser.Leftadd_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leftadd_expr}
	 * labeled alternative in {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLeftadd_expr(mxParser.Leftadd_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterNew_expression(mxParser.New_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitNew_expression(mxParser.New_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new_basic}
	 * labeled alternative in {@link mxParser#new_type}.
	 * @param ctx the parse tree
	 */
	void enterNew_basic(mxParser.New_basicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new_basic}
	 * labeled alternative in {@link mxParser#new_type}.
	 * @param ctx the parse tree
	 */
	void exitNew_basic(mxParser.New_basicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new_class}
	 * labeled alternative in {@link mxParser#new_type}.
	 * @param ctx the parse tree
	 */
	void enterNew_class(mxParser.New_classContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new_class}
	 * labeled alternative in {@link mxParser#new_type}.
	 * @param ctx the parse tree
	 */
	void exitNew_class(mxParser.New_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#func_call_list}.
	 * @param ctx the parse tree
	 */
	void enterFunc_call_list(mxParser.Func_call_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#func_call_list}.
	 * @param ctx the parse tree
	 */
	void exitFunc_call_list(mxParser.Func_call_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basic_type}
	 * labeled alternative in {@link mxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBasic_type(mxParser.Basic_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basic_type}
	 * labeled alternative in {@link mxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBasic_type(mxParser.Basic_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class_type}
	 * labeled alternative in {@link mxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterClass_type(mxParser.Class_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class_type}
	 * labeled alternative in {@link mxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitClass_type(mxParser.Class_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#basictype}.
	 * @param ctx the parse tree
	 */
	void enterBasictype(mxParser.BasictypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#basictype}.
	 * @param ctx the parse tree
	 */
	void exitBasictype(mxParser.BasictypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(mxParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(mxParser.LiteralContext ctx);
}