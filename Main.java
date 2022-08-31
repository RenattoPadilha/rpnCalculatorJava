import java.util.Stack;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        
      File exprRPN = new File("teste.txt");
      Stack<Double> stack = new Stack<Double>();
      BufferedReader br = new BufferedReader(new FileReader(exprRPN));
      
      String valorAtual;
      
      while((valorAtual = br.readLine()) != null){
        
        //Verificando se é um operador
        if (valorAtual.equals("*")){
          double valor2 = stack.pop();
          double valor1 = stack.pop();
          
          stack.push (valor1 * valor2);
        } else if (valorAtual.equals("/")){
          double valor2 = stack.pop();
          double valor1 = stack.pop();
          
          stack.push (valor1 / valor2);
        } else if (valorAtual.equals("+")){
          double valor2 = stack.pop();
          double valor1 = stack.pop();
          
          stack.push (valor1 + valor2);
        } else if (valorAtual.equals("-")){
          double valor2 = stack.pop();
          double valor1 = stack.pop();
          
          stack.push (valor1 - valor2);
          
        } else if (valorAtual.equals("^")){
          double valor2 = stack.pop();
          double valor1 = stack.pop();
          
          stack.push (Math.pow (valor1, valor2));
          
        //Verificando se é um operando
        } else {
          stack.push (Double.parseDouble(valorAtual));
        }    
      }
      System.out.println(stack.pop());
    }
}