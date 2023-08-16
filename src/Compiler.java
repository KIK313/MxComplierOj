package src;
import java.io.InputStream;
import java.io.FileInputStream;

import ast.ProgramNode;
import frontend.SemanticChecker;
import frontend.SymbolCollector;
import utl.error.error;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import parser.*;
import utl.mxErrorListener;
import frontend.ASTBuilder;
import utl.globalScope;
public class Compiler {
        public static void main(String[] args) throws Exception{
            if (args.length == 0) {
                System.out.println("Usage: java Compiler <filename>");
                return;
            } else if (args[0].equals("-fsyntax-only")) {
                System.out.println("Semantic check");
                InputStream input = System.in;
                try {
                    mxLexer lexer = new mxLexer(CharStreams.fromStream(input));
                    lexer.removeErrorListeners();
                    lexer.addErrorListener(new mxErrorListener());
                    mxParser parser = new mxParser(new CommonTokenStream(lexer));
                    parser.removeErrorListeners();
                    parser.addErrorListener(new mxErrorListener());
                    ParseTree parseTreeRoot = parser.program();
                    ASTBuilder astBuilder = new ASTBuilder();
                    ProgramNode nd = (ProgramNode) astBuilder.visit(parseTreeRoot);
                    globalScope gScope = new globalScope(null);
                    new SymbolCollector(gScope).visit(nd);
                    new SemanticChecker(gScope).visit(nd);
                } catch (error er) {
                    System.err.println(er.toString());
                    throw new RuntimeException();
                }


                return;
            } else if (args[0].equals("-S")) {
                System.out.println("Generate assembly code");
                return;
            } else {
                System.out.println("Unknown option");
                return;
            }
        }
}
