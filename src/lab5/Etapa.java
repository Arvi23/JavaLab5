package lab5;

public class Etapa {
    private String denumire;
    private String luna_start;
    private String luna_sfarsit;

    // Parameterized constructor
    public Etapa(String denumire, String luna_start, String luna_sfarsit) {
        this.denumire = denumire;
        this.luna_start = luna_start;
        this.luna_sfarsit = luna_sfarsit;
    }

    public void afisare() {
        System.out.println("Etapa: " + denumire);
        System.out.println("Start: " + luna_start);
        System.out.println("Sfarsit: " + luna_sfarsit);
    }

    // Getters and setters for denumire, luna_start, and luna_sfarsit
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getLuna_start() {
        return luna_start;
    }

    public void setLuna_start(String luna_start) {
        this.luna_start = luna_start;
    }

    public String getLuna_sfarsit() {
        return luna_sfarsit;
    }

    public void setLuna_sfarsit(String luna_sfarsit) {
        this.luna_sfarsit = luna_sfarsit;
    }
}
