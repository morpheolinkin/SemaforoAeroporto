package principal;

import java.util.concurrent.Semaphore;

public class ThreadAviao extends Thread{
    private int idThread; //Refente ao número do avião
    private static final int DISTANCIA_TOTAL = 100;
    private static int cont = 0; //Relacionado a pista da direira ou da esquerda
    private Semaphore semaphore;

    public ThreadAviao(int idThread, Semaphore semaphore) {
        this.idThread = idThread;
        this.semaphore = semaphore;

    }

    private void aviaoAndando(){
        int distanciaPercorrida = 0;

        while (distanciaPercorrida < DISTANCIA_TOTAL){
            int rodada = (int) (Math.random() * 50) + 10;

            distanciaPercorrida += rodada;

            System.out.println("O avião #" + idThread +
                    " já percorreu " + distanciaPercorrida + " metros.");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void pista(){
        if (cont % 2 == 0){
            System.out.println("O avião #" + idThread + " está na pista da direita!");
            cont++;
        }else {
            System.out.println("O avião #" + idThread + " está na pista da esquerda!");
            cont++;
        }
    }

    private void manobra(){
        System.out.println("O avião #" + idThread + " está manobrando!");

        int tempo = (int) (Math.random() * 300) + 400;

        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void taxiar(){
        System.out.println("O avião #" + idThread + " está taxiando!");

        int tempo = (int) (Math.random() * 200) + 300;

        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void posicioando(){
        System.out.println("O avião #" + idThread + " está posicioando!");

        int tempo = (int) (Math.random() * 100) + 300;

        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void acelerar(){
        System.out.println("O avião #" + idThread + " está acelerando!");

        int tempo = (int) (Math.random() * 300) + 200;

        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void decolar(){
        System.out.println("O avião #" + idThread + " está decolando!");

        int tempo = (int) (Math.random() * 400) + 300;

        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void afastar(){
        System.out.println("O avião #" + idThread + " está se afastando!");

        int tempo = (int) (Math.random() * 200) + 400;

        try {
            Thread.sleep(tempo);
            System.out.println("\no avião #" + idThread +
                    " já se afastou, pode entrar o próximo!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            aviaoAndando();
            pista();
            manobra();
            taxiar();
            posicioando();
            acelerar();
            decolar();
            afastar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }


    }
}
