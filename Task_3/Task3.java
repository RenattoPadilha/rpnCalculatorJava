import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.io.*;

public class Task3 {
  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  public static void main(String args[]) throws Exception {

    File exprRPN = new File("Task_3/teste.txt");
    Stack<Double> stack = new Stack<Double>();
    List<Token3> listaToken = new ArrayList<>();
    BufferedReader br = new BufferedReader(new FileReader(exprRPN));

    boolean error = false;
    String valorAtual;
    Token3 token;

    while ((valorAtual = br.readLine()) != null) {
      //isNumber
      if (Regex.isNum(valorAtual)){
        token = new Token3(TokenType3.NUM, valorAtual);
        listaToken.add(token);
      //analisando se e um operando valido
      } else if (Regex.isOP(valorAtual)) {
        //analisando qual operando foi inserido
        if (valorAtual.equals("*")) {
          token = new Token3(TokenType3.STAR, valorAtual);
        } else if (valorAtual.equals("/")) {
          token = new Token3(TokenType3.SLASH, valorAtual);
        } else if (valorAtual.equals("+")) {
          token = new Token3(TokenType3.PLUS, valorAtual);
        } else {
          token = new Token3(TokenType3.MINUS, valorAtual);
        }
        listaToken.add(token);
      } else {
        error = true;
        System.err.println("Unexpected character: '" + valorAtual + "'");
      }

    }
    if (!error){
      while (listaToken.size() != 0) {
        token = listaToken.remove(0);
        System.out.println(token.toString());
  
        // Verificando se é um operador
        if (token.lexeme.equals("*")) {
          double valor2 = stack.pop();
          double valor1 = stack.pop();
  
          stack.push(valor1 * valor2);
        } else if (token.lexeme.equals("/")) {
          double valor2 = stack.pop();
          double valor1 = stack.pop();
  
          stack.push(valor1 / valor2);
        } else if (token.lexeme.equals("+")) {
          double valor2 = stack.pop();
          double valor1 = stack.pop();
  
          stack.push(valor1 + valor2);
        } else if (token.lexeme.equals("-")) {
          double valor2 = stack.pop();
          double valor1 = stack.pop();
  
          stack.push(valor1 - valor2);
  
        }else {
          stack.push(Double.parseDouble(token.lexeme));
        }
      }
      System.out.println(stack.pop());
    }
    }
    
}