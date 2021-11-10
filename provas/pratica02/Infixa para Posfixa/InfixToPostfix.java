import java.util.Stack;

public class InfixToPostfix {

    public static int prioridade(char op){
        
        if(op == '+' || op =='-')
            return 1;
        
        else if(op == '*' || op =='/')
            return 2;

        else if(op == '^')
            return 3;
        
        //Caso o char nao seja um operador valido
        return -1;
    }
    
    //Transforma uma expressao na forma infixa para a forma posfixa
    public static String infixToPostfix(String infix){
        String postfix = "";
        
        //Pilha que vai armazenar os operadores contidos na expressao
        Stack<Character> pilha = new Stack<>();
         
        for (int i = 0; i < infix.length(); i++){
            char caractere = infix.charAt(i);
            
            //Caso o caracter seja uma variavel da expressao
            if (Character.isLetterOrDigit(caractere)){
                postfix += caractere;

            }else if (caractere == '('){ //Inicio de uma parte da expressao com prioridade (parenteses)
                pilha.push(caractere);

            }else if (caractere == ')'){ //Fim da prioridade

                while(!pilha.isEmpty() && pilha.peek() != '('){
                    postfix += pilha.pop();
                }

                pilha.pop();
            }else{ //O caractere eh um operador
                
                while (!pilha.isEmpty() && prioridade(caractere) <= prioridade(pilha.peek())){
                    postfix += pilha.pop();
                }

                pilha.push(caractere);
            }
        }
      
        //Retira todos os operadores que sobraram na pilha
        while (!pilha.isEmpty())
            postfix += pilha.pop();

        return postfix;
    }

    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        String entrada = "", saida  = "";
        int qnt_linhas = Integer.parseInt(MyIO.readLine());
        int num_linha = 0;

        //Recebe as linhas de entrada, processa elas na funcao e printa o resultado
        for(int i = 0; i < qnt_linhas; i++){
            entrada = MyIO.readLine();
            saida = infixToPostfix(entrada);
            MyIO.println(saida);
        }
    }
}