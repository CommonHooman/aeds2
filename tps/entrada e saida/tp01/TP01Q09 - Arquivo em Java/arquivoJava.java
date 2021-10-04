import java.io.File;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class arquivoJava {

    public static void main(String[] args) throws Exception {
        int num_linhas;
        double num;
        RandomAccessFile entrada = new RandomAccessFile("entrada.txt", "rw");
        num_linhas = MyIO.readInt();

        for(int i = 0; i < num_linhas; i++){
            entrada.seek(i * 8);
            entrada.writeDouble(MyIO.readDouble());
        }

        entrada = new RandomAccessFile("entrada.txt", "r");
        num = entrada.readDouble();
        for(int i = num_linhas-1 ; i >= 0; i--){
            entrada.seek(i * 8);
            num = entrada.readDouble();

            if(num % 1 == 0)
                MyIO.println((int)(num));
            else
                MyIO.println(num);
        }
        
        entrada.close();
    }

    // public static void main(String[] args) throws Exception {
    //     try {
    //         int n = MyIO.readInt();
    //         RandomAccessFile put = new RandomAccessFile("out.txt", "rw");
    //         for (int i = 0; i < n; i++) {
    //             put.seek(i * 8);
    //             put.writeDouble(MyIO.readDouble());
    //         }
    //         put.close();

    //         RandomAccessFile raf = new RandomAccessFile("out.txt", "r");
    //         double printa = raf.readDouble();
    //         for (int i = n-1 ; i >= 0; i--) {
    //             raf.seek(i * 8);
    //             printa = raf.readDouble();
    //             if (printa % 1 == 0) {
    //                 MyIO.println((int) printa);
    //             } else
    //                 MyIO.println(printa);
    //         }
    //         raf.close();
    //     } catch (Exception EstourouMemoria) {
    //         MyIO.println("ERROR :X");
    //     }
    // }
}
