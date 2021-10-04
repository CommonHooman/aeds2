import java.io.*;

public class QuadroMedalhas {
    public String linha;
    public int ouro;
    public int prata;
    public int bronze;
    public String nome;


    QuadroMedalhas(){
        linha = "";
        ouro = 0;
        prata = 0;
        bronze = 0;
        nome = "";
    }

    public int getOuro(){
        int achou = 0, i;
        int numOuro;

        for(i = 0; achou != 1 && i < nome.length(); i++){
            if(linha.charAt(i) == ' ')
                achou++;
        }

        if(linha.charAt(i+1) >= 48 && linha.charAt(i+1) <= 57){
            numOuro = (int)(linha.charAt(i)) * 10;
            numOuro += (int)(linha.charAt(i+1));
        }else{
            numOuro = (int)(linha.charAt(i));
        }

        return numOuro;
    }

    public int getPrata(){
        int achou = 0, i;
        int numPrata;

        for(i = 0; achou != 2 && i < nome.length(); i++){
            if(linha.charAt(i) == ' ')
                achou++;
        }

        if(linha.charAt(i+1) >= 48 && linha.charAt(i+1) <= 57){
            numPrata = (int)(linha.charAt(i)) * 10;
            numPrata += (int)(linha.charAt(i+1));
        }else{
            numPrata = (int)(linha.charAt(i));
        }

        return numPrata;
    }

    public int getBronze(){
        int achou = 0, i;
        int numBronze;

        for(i = 0; achou != 3 && i < nome.length(); i++){
            if(linha.charAt(i) == ' ')
                achou++;
        }

        if(linha.charAt(i+1) >= 48 && linha.charAt(i+1) <= 57){
            numBronze = (int)(linha.charAt(i)) * 10;
            numBronze += (int)(linha.charAt(i+1));
        }else{
            numBronze = (int)(linha.charAt(i)) - 48;
        }

        return numBronze;
    }

    public String getNome(){
        int fimNome = 0;
        String name = "";

        for(int i = 0; fimNome != 1 && i < linha.length(); i++){
            if(linha.charAt(i) != ' '){
                name += linha.charAt(i);
            }else{
                fimNome++;
            }
        }

        return name;
    }

    // public void swap(QuadroMedalhas a, QuadroMedalhas b){
    //     QuadroMedalhas temp = new QuadroMedalhas(a);

    //     a = b.clone();
    //     b = temp.clone();

    //     free(temp);
    // }

    public static void bubbleSortMedalhas(QuadroMedalhas[] entrada, int n){
        String temp;
        int swap;
        int i, j;
        MyIO.println(entrada[0].getOuro() + " - " + entrada[1].getPrata() + " - " + entrada[2].getBronze());
        for (i = 0; i < n - 1; i++){
            swap = 0;

            for (j = 0; j < n - i - 1; j++){
                if (entrada[j].getOuro() < entrada[j + 1].getOuro()){
                    swap = 1;
                    temp = entrada[j].linha;
                    entrada[j].linha = entrada[j+1].linha;
                    entrada[j + 1].linha = temp;
                }else if(entrada[j].getOuro() == entrada[j + 1].getOuro()){
                    if(entrada[j].getPrata() < entrada[j + 1].getPrata()){
                        swap = 1;
                        temp = entrada[j].linha;
                        entrada[j].linha = entrada[j+1].linha;
                        entrada[j + 1].linha = temp;
                    }else if(entrada[j].getPrata() == entrada[j + 1].getPrata()){
                        if(entrada[j].getBronze() < entrada[j + 1].getBronze()){
                            swap = 1;
                            temp = entrada[j].linha;
                            entrada[j].linha = entrada[j+1].linha;
                            entrada[j + 1].linha = temp;
                        }else if(entrada[j].getBronze() == entrada[j + 1].getBronze()){
                            if(entrada[j].getNome().charAt(0) < entrada[j + 1].getNome().charAt(0)){
                                swap = 1;
                                temp = entrada[j].linha;
                                entrada[j].linha = entrada[j+1].linha;
                                entrada[j + 1].linha = temp;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        int qntEntradas;
        String input;

        qntEntradas = MyIO.readInt();
        QuadroMedalhas[] pais = new QuadroMedalhas[qntEntradas];

        for(int i = 0; i < qntEntradas; i++){
            pais[i] = new QuadroMedalhas();
            input = MyIO.readLine();
            pais[i].linha = input;
            // pais[i].findOuro();
            // pais[i].findPrata();
            // pais[i].findBronze();
            // pais[i].findNome();
        }

        bubbleSortMedalhas(pais, qntEntradas);

        for(int i = 0; i < qntEntradas; i++){
            MyIO.println(pais[i].linha);
        }
    }
}
