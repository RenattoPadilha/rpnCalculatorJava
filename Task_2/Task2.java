import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.io.*;

public class Task2 {
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

    File exprRPN = new File("Task_2/teste.txt");
    Stack<Double> stack = new Stack<Double>();
    List<Token2> listaToken = new ArrayList<>();
    BufferedReader br = new BufferedReader(new FileReader(exprRPN));

    boolean error = false;
    String valorAtual;
    Token2 token;

    while ((valorAtual = br.readLine()) != null) {
      //isNumber
      if (isNumeric(valorAtual)){
        token = new Token2(TokenType2.NUM, valorAtual);
        listaToken.add(token);
      //analisando operando *
      } else if (valorAtual.equals("*")) {
        token = new Token2(TokenType2.STAR, valorAtual);
        listaToken.add(token);
        //analisando operando /
      } else if (valorAtual.equals("/")) {
        token = new Token2(TokenType2.SLASH, valorAtual);
        listaToken.add(token);
        //analisando operando +
      } else if (valorAtual.equals("+")) {
        token = new Token2(TokenType2.PLUS, valorAtual);
        listaToken.add(token);
        //analisando operando -
      } else if (valorAtual.equals("-")) {
        token = new Token2(TokenType2.MINUS, valorAtual);
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
  
        }/* else if (token.lexeme.equals("^")) {
          double valor2 = stack.pop();
          double valor1 = stack.pop();
  
          stack.push(Math.pow(valor1, valor2));
  
          // Verificando se é um operando
        } */ else {
          stack.push(Double.parseDouble(token.lexeme));
        }
      }
      System.out.println(stack.pop());
    }
    }
    
}