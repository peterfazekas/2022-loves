package hu.targetshooting;

import hu.targetshooting.controller.ShotService;
import hu.targetshooting.model.service.DataApi;
import hu.targetshooting.model.service.DataParser;
import hu.targetshooting.model.service.FileReader;

public class App {

    private final ShotService service;

    private App() {
        DataApi dataApi = new DataApi(
                new FileReader("verseny.txt"),
                new DataParser());
        service = new ShotService(dataApi.getData());
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat");
        System.out.println("Az egymást követően többszőr találó versenyzők: " +
                service.getTwoSuccessShotIds());
        System.out.println("3. feladat");
        System.out.println("A legtöbb lövést leadó versenyző rajtszáma: " +
                service.getLongestShotSequenceId());
    }
}
