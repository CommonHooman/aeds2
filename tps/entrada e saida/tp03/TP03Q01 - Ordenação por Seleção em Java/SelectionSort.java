import java.io.*;
import java.util.*;
import java.lang.*;

public class SelectionSort {

    public static void selectionSort(ListaSeq lista){

        for(int i = 0; i < lista.getSize(); i++){
            int menor = i;
            for(int j = i+1; j < lista.getSize(); j++){
                if(lista.array[menor].getCountry().trim().compareToIgnoreCase(lista.array[j].getCountry().trim()) > 0){
                    menor = j;
                }else if(lista.array[menor].getCountry().trim().compareToIgnoreCase(lista.array[j].getCountry().trim()) == 0){
                    if(lista.array[menor].getName().trim().compareToIgnoreCase(lista.array[j].getName().trim()) > 0)
                        menor = j;
                }
            }
            swap(menor, i, lista.array);
        }
    }

    public static void swap(int a, int b, Serie array[]){
        Serie tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args){
        ListaSeq lista = new ListaSeq();
        String linha = MyIO.readLine();
        Serie obj;

        //Preenche a lista com todas as series vindas antes do 1o "FIM"
        while(isFim(linha) == false){
            obj = new Serie();
            obj.readClass(linha);
            lista.inserirFim(obj);

            linha = MyIO.readLine();
        }
        //lista.print();
        selectionSort(lista);

        lista.print();
    }
}

class ListaSeq {
    public Serie array[];
    private int size;

    /* CONSTRUTORES */
    ListaSeq(){
        array = new Serie[100]; //Tamanho default da lista = 100
        size = 0;
    }
    
    ListaSeq(int capacity){
        array = new Serie[capacity]; //Tamanho definido manualmente
        size = 0;
    }

    ListaSeq(Serie obj){
        array = new Serie[100];
        array[0] = obj;
        size = 1;
    }

    /* METODOS DE INSERCAO */
    //Insere na primeira posicao da lista e reorganiza todas as celulas seguintes
    public void inserirInicio(Serie obj){
        for(int i = size; i > 0 ; i--)
            array[i] = array[i-1];

        array[0] = obj;
        size++;
    }

    //Insere na ultima posicao da lista
    public void inserirFim(Serie obj){
        array[size] = obj;
        size++;
    }

    //Insere em uma posicao especificada da lista
    public void inserir(Serie obj, int index){
        if(index == 0){
            inserirInicio(obj);
        }else if(index == this.size){
            inserirFim(obj);
        }else{
            int i;

            for(i = size; i > index; i--)
                array[i] = array[i-1];

            array[i] = obj;
            size++;
        }
    }

    /* METODOS DE REMOCAO */
    //Remove a primeira celula da lista e retorna a celula removida
    public Serie removerInicio(){
        Serie removed = array[0];

        for(int i = 0; i < size; i++)
            array[i] = array[i+1];

        size--;

        return removed;
    }

    //Remove logicamente a ultima celula da lista e retorna a celula removida
    public Serie removerFim(){
        Serie removed = array[size - 1];

        size--;

        return removed;
    }

    //Remove a celula na posicao espeficada da lista
    public Serie remover(int index){
        Serie removed;

        if(index == 0){
            removed = removerInicio();
        }else if(index == this.size - 1){
            removed = removerFim();
        }else{
            removed = array[index];

            for(int i = index; i < size; i++)
                array[i] = array[i + 1];

            size--;
        }

        return removed;
    }

    /* METODOS MISCELANEOS */
    //Get de size (afinal este eh um atributo privado e bemm essencial para o funcionamento da classe)
    public int getSize() { return this.size; }

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public void print(){
        for(int i = 0; i < size; i++){
            array[i].printClass();
        }
    }
}

/* Classe Serie (pegada do Felipe <3) */
class Serie{
    private String name;
    private String format;
    private String duration;
    private String country;
    private String language;
    private String broadcaster;
    private String streaming;
    private int seasons;
    private int episodes;

    /* CONSTRUTORES */
    public Serie(){
        name = "";
        format = "";
        duration = "";
        country = "";
        language = "";
        broadcaster = "";
        streaming = "";
        seasons = 0;
        episodes = 0;
    }

    public Serie(String name, String format, String duration, String country, String language, String broadcaster, String streaming, int seasons, int episodes){
        this.name = name;
        this.format = format;
        this.duration = duration;
        this.country = country;
        this.language = language;
        this.broadcaster = broadcaster;
        this.streaming = streaming;
        this.seasons = seasons;
        this.episodes = episodes;
    }

    /* SETS */
    public void setName(String name){ this.name = name; }
    public void setFormat(String format){ this.format = format; }
    public void setDuration(String duration){ this.duration = duration; }
    public void setCountry(String country){ this.country = country; }
    public void setLanguage(String language){ this.language = language; }
    public void setBroadcaster(String broadcaster){ this.broadcaster = broadcaster; }
    public void setStreaming(String streaming){ this.streaming = streaming; }
    public void setSeasons(int seasons){ this.seasons = seasons; }
    public void setEpisodes(int episodes){ this.episodes = episodes; }

    /* GETS */
    public String getName(){ return this.name; }
    public String getFormat(){ return this.format; }
    public String getDuration(){ return this.duration; }
    public String getCountry(){ return this.country; }
    public String getLanguage(){ return this.language; }
    public String getBroadcaster(){ return this.broadcaster; }
    public String getStreaming(){ return this.streaming; }
    public int getSeasons(){ return this.seasons; }
    public int getEpisodes(){ return this.episodes; }

    /* METODOS */
    //método para clonar a classe
    public Serie clone(){
        Serie resp = new Serie();
        resp.name = this.name;
        resp.format = this.format;
        resp.duration = this.duration;
        resp.country = this.country;
        resp.language = this.language;
        resp.broadcaster = this.broadcaster;
        resp.streaming = this.streaming;
        resp.seasons = this.seasons;
        resp.episodes = this.episodes;
        return resp;
    }

    //método para printar a classe
    public void printClass(){
        System.out.println(this.name + " " + this.format + " " + this.duration + " " + this.country + " " + this.language + " " + this.broadcaster + " " +
        this.streaming + " " + this.seasons + " " + this.episodes);
    }

    //método para tratar a linha, deixar apenas números e converter o retorno de String para Integer
    public int justInt(String line){
        String resp = "";

        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ //caso o caracter seja um número ele é concatenado a variável resp
                resp += line.charAt(i);
            } else { //caso seja outro caracter, o i recebe o valor da condição de parada e o método de repetição é encerrado
                i = line.length();
            }
        }

        return Integer.parseInt(resp); //conversão da string resp para número inteiro a ser retornado
    }

    //método para a remoção das tags da linha lida do arquivo para retornar apenas o que é desejado
    public String removeTags(String line){
        String resp = "";
        int i = 0;

        while(i < line.length()){ //enquanto i for menor que o tamanho da String linha
            if(line.charAt(i) == '<'){ // é testado para verificar se o contador i ainda está dentro das tags
                i++;
                while(line.charAt(i) != '>') i++; //ao encontrar o sinal de fechamento das tags o laço de repetição é encerrado
            } else if(line.charAt(i) == '&'){ //mesmo tratamento de cima mas para outras exceções presentes em alguns outros arquivos
                i++;
                while(line.charAt(i) != ';') i++;
            } else { //o que estiver fora das tags é concatenado a String resp a ser retornada
                resp += line.charAt(i);
            }
            i++;
        }
        
        return resp;
    }

    //método para tratar o nome do arquivo e retornar o nome da série
    public String searchName(String fileName){
        String resp = "";

        for(int i = 0; i < fileName.length(); i++){
            if(fileName.charAt(i)  == '_'){ //caso o caracter na posição i seja igual ao '_' a variável resp recebe um espaço em branco
                resp += ' ';
            } else { //caso não tenha espaço em branco o caracter é concatenado à string resp
                resp += fileName.charAt(i);
            }
        }

        return resp.substring(0, resp.length()-5); //retorno da substring resp retirando os 5 últimos caracteres relacionados à extensão do arquivo
    }

    //método para leitura do arquivo .html e tratamento das linhas
    public void readClass(String fileName){
        String file = "/tmp/series/" + fileName;

        try {
            FileReader fileReader = new FileReader(file); //declaração da variável fileReader que será recebida pelo bufferedReader
            BufferedReader br = new BufferedReader(fileReader); //declaração do bufferedReader para leitura do arquivo

            this.name = searchName(fileName);

            while(!br.readLine().contains("Formato"));
            this.format = removeTags(br.readLine());

            while(!br.readLine().contains("Duração"));
            this.duration = removeTags(br.readLine());

            while(!br.readLine().contains("País de origem"));
            this.country = removeTags(br.readLine());

            while(!br.readLine().contains("Idioma original"));
            this.language = removeTags(br.readLine());

            while(!br.readLine().contains("Emissora de televisão"));
            this.broadcaster = removeTags(br.readLine());

            while(!br.readLine().contains("Transmissão original"));
            this.streaming = removeTags(br.readLine());

            while(!br.readLine().contains("N.º de temporadas"));
            this.seasons = justInt(removeTags(br.readLine()));

            while(!br.readLine().contains("N.º de episódios"));
            this.episodes = justInt(removeTags(br.readLine()));

            br.close();

        //Tratamento de exceções
        } catch(FileNotFoundException e) {
            System.out.println("Unable to open file '" + fileName + "'");                
        } catch(IOException e) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }
}