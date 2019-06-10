package principal;

import java.util.concurrent.Semaphore;

public class Aviao {
    public static void main(String[] args) {
        int permissoes = 2;
        Semaphore semaphore = new Semaphore(permissoes);

        for (int cont = 0; cont < 6; cont++) {
            Thread t = new ThreadAviao(cont, semaphore);
            t.start();
        }
    }
}
