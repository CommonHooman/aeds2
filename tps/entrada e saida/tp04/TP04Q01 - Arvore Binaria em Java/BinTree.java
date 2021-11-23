import java.lang.*;
import java.io.*;
import java.util.*;

public class BinTree {

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception{
        BinaryTree tree = new BinaryTree();
        Serie data;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        int operationQnty;

        // Preenche a arvore com todas as series vindas antes do 1o "FIM"
        while(isFim(line) == false){
            data = new Serie();
            data.readClass(line);
            tree.insert(data);

            line = in.readLine();
        }
        operationQnty = Integer.parseInt(in.readLine());

        for(int i = 0; i < operationQnty; i++){
            line = in.readLine();

            // Operacao de insercao
            if(line.charAt(0) == 'I'){
                data = new Serie();
                data.readClass(line.substring(2));
                tree.insert(data);
            }else{ // Operacao de remocao
                tree.remove(line.substring(2));
            }
        }
    }
}

class BinaryTree{
    Node root;

    BinaryTree(){
        root = null;
    }

    BinaryTree(Node root){
        this.root = root;
    }

    public Node insert(Serie data){
        return insert(data, root);
    }

    // Insere um No (Serie) de forma ordenada, usando como parametro o nome da serie
    public Node insert(Serie data, Node node){
        if(node == null){
            node = new Node(data);
        }else if(data.getName().compareTo(node.data.getName()) > 0){
            node.right = insert(data, node.right);
        }else if(data.getName().compareTo(node.data.getName()) < 0){
            node.left = insert(data, node.left);
        }else{
            System.out.println("ERROR: Element already exists");
        }

        return node;
    }

    public Node search_nomeSerie(String nomeSerie){
        return search_nomeSerie(root, nomeSerie);
    }

    public Node search_nomeSerie(Node node, String nomeSerie){
        if(node == null)
            return null;

        if(node.data.getName().compareTo(nomeSerie) == 0)
            return node;
        else if(node.data.getName().compareTo(nomeSerie) > 0)
            return search_nomeSerie(node.left, nomeSerie);
        else
            return search_nomeSerie(node.right, nomeSerie);
    }

    public void remove(String nomeSerie){
        root = remove(nomeSerie, root);
    }

    public Node remove(String nomeSerie, Node node){

        // Nao encontrou a serie a ser removida -> fazer nada
        if(node == null){
        
        // No procurado esta a direita do no atual
        }else if(node.data.getName().compareTo(nomeSerie) < 0){
            node.right = remove(nomeSerie, node.right);
        
        // No procurado esta a esquerda do no atual
        }else if(node.data.getName().compareTo(nomeSerie) > 0){
            node.left = remove(nomeSerie, node.left);

        // Encontrou -> sem no a direita
        }else if(node.right == null){
            node = node.left;

        // Encontrou -> sem no a esquerda
        }else if(node.left == null){
            node = node.right;

        // Encontrou -> nos em ambos os lados
        }else{
            node.left = swapMaxSubtree(node, node.left);
        }

        return node;
    }

    private Node swapMaxSubtree(Node removed, Node j){

        // Encontrou o maior no da subarvore
        if(j.right == null){
            removed.data = j.data; // Substitui o conteudo de cada no
            j = j.left;
        
        // Ainda existem nos maiores (a direita)
        }else{
            j.right = maxSubtree(removed, j.right);
        }

        return j;
    }

}

class Node{
    Serie data;
    Node left, right;

    Node(Serie data){
        this.data = data;
        left = right = null;
    }
}

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