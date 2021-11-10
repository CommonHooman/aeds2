import java.lang.*;

public class Van {
    static Aluno[] array = new Aluno[1000];


    public static void sortVan() {

        for(int i = 0; i < array.length - 1; i++){
            int menor = i;

            for(int j = i+1; j < array.length -1 ; j++){
                if(array[menor].distancia < array[j].distancia){
                    menor = j;
                }else if(array[menor].distancia == array[j].distancia){
                    if(array[menor].regiao > array[j].regiao){
                        menor = j;
                    }else if(array[menor].regiao == array[j].regiao){
                        if(array[menor].nome.compareToIgnoreCase(array[j].nome) > 0){
                            menor = j;
                        }
                    }
                }
            }

            Aluno tmp = array[menor];
            array[menor] = array[i];
            array[i] = tmp;
        }

    }

    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        int qnt_linhas = Integer.parseInt(MyIO.readLine());

        //Recebe as linhas de entrada, processa elas na funcao e printa o resultado
        for(int i = 0; i < qnt_linhas; i++)
            array[i] = new Aluno(MyIO.readLine());

        sortVan();

        for(int i = 0; i < qnt_linhas; i++)
            System.out.println(array[i].nome);
    }
}

class Aluno{
    String nome;
    char regiao;
    float distancia;

    Aluno(String linha){
        int i;
        this.nome = "";

        for(i = 0; linha.charAt(i) != ' '; i++)
            this.nome += linha.charAt(i);
        
        i++;
        this.regiao = linha.charAt(i);
        i+=2;

        this.distancia = Integer.parseInt(linha.substring(i));
    }

    // Aluno(){
    //     this.nome = "";
    //     this.regiao = '';
    //     this.distancia = 0;
    // }

    // Aluno clone(){
    //     Aluno tmp = new Aluno();

    // }

}
