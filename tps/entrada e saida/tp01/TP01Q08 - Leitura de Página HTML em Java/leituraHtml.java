import java.io.*;
import java.net.*;

class leituraHtml{

    //Peguei da pasta de ajuda em Java do Git, nao sei fazer oq ta escrito aqui, so sei usar o resultado
    public static String getHtml(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here
        }

        return resp;
    }

    public static String readHtml(String html){
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        int a_ag = 0, e_ag = 0, i_ag = 0, o_ag = 0, u_ag = 0;
        int a_gra = 0, e_gra = 0, i_gra = 0, o_gra = 0, u_gra = 0;
        int a_til = 0, o_til = 0;
        int a_circ = 0, e_circ = 0, i_circ = 0, o_circ = 0, u_circ = 0;
        int consoantes = 0;
        int br = 0, table = 0;

        for(int j = 0; j < html.length(); j++){
            switch(html.charAt(j)){
                case 'a':
                    a++;
                    break;
                case 'e':
                    e++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'u':
                    u++;
                    break;
                case '�':
                    a_ag++;
                    break;
                case '�':
                    e_ag++;
                    break;
                case '�':
                    i_ag++;
                    break;
                case '�':
                    o_ag++;
                    break;
                case '�':
                    u_ag++;
                    break;
                case '�':
                    a_gra++;
                    break;
                case '�':
                    e_gra++;
                    break;
                case '�':
                    i_gra++;
                    break;
                case '�':
                    o_gra++;
                    break;
                case '�':
                    u_gra++;
                    break;
                case '�':
                    a_til++;
                    break;
                case '�':
                    o_til++;
                    break;
                case '�':
                    a_circ++;
                    break;
                case '�':
                    e_circ++;
                    break;
                case '�':
                    i_circ++;
                    break;
                case '�':
                    o_circ++;
                    break;
                case '�':
                    u_circ++;
                    break;
                case '<':
                    if(html.charAt(j+1) == 'b' && html.charAt(j+2) == 'r' && html.charAt(j+3) == '>'){
                        br++;
                        j+=3;
                    }else if(html.charAt(j+1) == 't' && html.charAt(j+2) == 'a' && html.charAt(j+3) == 'b' && html.charAt(j+4) == 'l' && html.charAt(j+5) == 'e' && html.charAt(j+6) == '>'){
                        table++;
                        j+=6;
                    }
                    break;
                default:
                    if(!(html.charAt(j) == 'a' || html.charAt(j) == 'e' || html.charAt(j) == 'i' || html.charAt(j) == 'o' || html.charAt(j) == 'u' || !((html.charAt(j) >= 97 && html.charAt(j) <= 122)))){
                        consoantes++;
                    }
                    break;
            }
        }

        return "a("+a+") e("+e+") i("+i+") o("+o+") u("+u+") �("+a_ag+") �("+e_ag+") �("+i_ag+") �("+o_ag+") �("+u_ag+") �("+a_gra+") �("+e_gra+") �("+i_gra+") �("+o_gra+") �("+u_gra+") �("+a_til+") �("+o_til+") �("+a_circ+") �("+e_circ+") �("+i_circ+") �("+o_circ+") �("+u_circ+") consoante("+consoantes+") <br>("+br+") <table>("+table+")";
    }

    //Checa se o input deve ser terminado
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

   public static void main(String[] args) {
        String[] entrada = new String[2000];
        int num_linha = 0;
        String html;

        do{
            entrada[num_linha] = MyIO.readLine();
        }while(isFim(entrada[num_linha++]) == false);
        num_linha--;

        for(int i = 1; i < num_linha; i += 2){
            html = getHtml(entrada[i]);
            System.out.println(readHtml(html) + " " + entrada[i-1]);
        }
   }
}
