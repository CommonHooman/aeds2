import java.io.*;
import java.util.*;

public class Serie {
    String nome;
    String formato;
    String duracao;
    String pais_orig;
    String idioma;
    String emissora;
    String transmissao;
    int temps;
    int eps;

                                                //----- CONSTRUTORES -----//
    public Serie(){ 
        nome = "";
        formato = "";
        duracao = "";
        pais_orig = "";
        idioma = "";
        emissora = "";
        transmissao = "";
        temps = 0;
        eps = 0;
    }

    public Serie(String nome, String formato, String duracao, String pais_orig, String idioma, String emissora, String transmissao, int temps, int eps){ 
        this.nome = nome;
        this.formato = formato;
        this.duracao = duracao;
        this.pais_orig = pais_orig;
        this.idioma = idioma;
        this.emissora = emissora;
        this.transmissao = transmissao;
        this.temps = temps;
        this.eps = eps;
    }

                                                //----- GETTERS & SETTERS -----//
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDuracao() {
        return duracao;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getPaisOrig() {
        return pais_orig;
    }
    public void setPaisOrig(String pais_orig) {
        this.pais_orig = pais_orig;
    }

    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEmissora() {
        return emissora;
    }
    public void setEmissora(String emissora) {
        this.emissora = emissora;
    }

    public String getTransmissao() {
        return transmissao;
    }
    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public int getEps() {
        return eps;
    }
    public void setEps(int eps) {
        this.eps = eps;
    }

    public int getTemps() {
        return temps;
    }
    public void setTemps(int temps) {
        this.temps = temps;
    }

                                                //----- METODOS -----//
    //Retorna um objeto Serie com todos os atributos da Serie original
    protected Serie clone(){
        Serie resul = new Serie();

        resul.nome = this.nome;
        resul.formato = this.formato;
        resul.duracao = this.duracao;
        resul.pais_orig = this.pais_orig;
        resul.idioma = this.idioma;
        resul.emissora = this.emissora;
        resul.transmissao = this.transmissao;
        resul.temps = this.temps;
        resul.eps = this.eps;

        return resul;
    }

    //Printa todos os atributos da Serie
    private void imprimir(){
        System.out.println(nome + " " + formato + " " + duracao + " " + pais_orig + " " + idioma + " " + emissora + " " + transmissao + " " + temps + " " + eps);
    }

    //Remove tudo contido entre < e >, incluindo os proprios <>
    public String removeTags(String linha){
        String conteudo = "";

        for(int i = 0; i < linha.length(); i++){
            if(linha.charAt(i) == '<'){
                while(linha.charAt(i) != '>') i++;
            }else if(linha.charAt(i) == '&' && linha.charAt(i+1) == 'n'){
                i += 5;
            }else if(linha.charAt(i) == '&' && linha.charAt(i+1) == '#'){
                i += 5;
            }else{
                conteudo += linha.charAt(i);
            }
        }

        return conteudo;
    }

    //Preenche os valores de cada atributo do objeto Serie
    public void ler(String nome_serie){
        try {
            BufferedReader html = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/series/" + nome_serie)));
            String linha = html.readLine();

            //Acha o nome da serie a partir do nome de seu arquivo
            for(int i = 0; nome_serie.charAt(i) != '.'; i++){
                if(nome_serie.charAt(i) == '_')
                    this.nome += " ";
                else
                    this.nome += nome_serie.charAt(i);
            } 

            //Acha os outros atributos desejados da serie
            while(linha.contains("</html>") == false){
                linha = html.readLine();

                if(linha.contains(">Formato<")){
                    linha = html.readLine(); 
                    this.formato = removeTags(linha);

                }else if( linha.contains("\">Duração<") ){
                    linha = html.readLine(); 
                    this.duracao = removeTags(linha);

                }else if(linha.contains(">País de origem<")){
                    linha = html.readLine(); 
                    this.pais_orig = removeTags(linha);

                }else if(linha.contains(">Idioma original<")){
                    linha = html.readLine(); 
                    this.idioma = removeTags(linha);

                }else if(linha.contains(">Emissora de televisão original<")){
                    linha = html.readLine(); 
                    this.emissora = removeTags(linha);

                }else if(linha.contains(">Transmissão original<")){
                    linha = html.readLine(); 
                    this.transmissao = removeTags(linha);

                }else if(linha.contains(">N.º de temporadas<")){
                    linha = html.readLine(); 
                    this.temps = Integer.parseInt(removeTags(linha).replaceAll("\\(.*?\\)", "").trim().replaceAll("[^\\d.]", ""));

                }else if(linha.contains("\">N.º de episódios<")){
                    linha = html.readLine(); 
                    this.eps = Integer.parseInt(removeTags(linha).replaceAll("\\(.*?\\)", "").trim().replaceAll("[^\\d.]", ""));
                }
            }

            html.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

                                                //----- MAIN -----//
    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        //Valor predefinido de 61 series (linhas no pub.in), para declarar com valor indefinido seria necessario um ArrayList
        Serie[] catalogo = new Serie[61];
        String[] entrada = new String[1000];
        int num_linha = 0;

        //Recebe os nomes dos arquivos contendo os htmls das series
        do{
            entrada[num_linha] = MyIO.readLine();
        }while(isFim(entrada[num_linha++]) == false);
        num_linha--;

        //Preence o vetor de series + preenche e imprime cada serie
        for(int i = 0; i < num_linha; i++){
            catalogo[i] = new Serie();
            catalogo[i].ler(entrada[i]);
            catalogo[i].imprimir();
        }
    }
    
};