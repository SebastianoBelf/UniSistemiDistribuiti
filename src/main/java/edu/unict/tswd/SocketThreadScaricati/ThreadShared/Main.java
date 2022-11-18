package edu.unict.tswd.SocketThreadScaricati.ThreadShared;

public class Main {

        public static void main(String[] args) throws InterruptedException {
            SharedArea area = new SharedArea();
            GenerateNumber tE = new GenerateNumber(true,area);
            GenerateNumber tO = new GenerateNumber(false,area);

            tE.start();
            tO.start();

            tO.join();
            tE.join();

            System.out.println(area.get());
        }
}
