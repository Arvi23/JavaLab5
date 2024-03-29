package lab5;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Plan {
    static final int NR_MAX_ETAPE = 30;
    private String denumire;
    private Etapa[] etape;
    private int nrEtape;
    private Angajat responsabil;

    // Parameterized constructor
    public Plan(String denumire) {
        this.denumire = denumire;
        this.nrEtape = 0;
        this.etape = new Etapa[NR_MAX_ETAPE];
    }

    // Operation to add a new stage
    public void adaugareEtapa(String denumire, String luna_start, String luna_sfarsit) {
        if (nrEtape < NR_MAX_ETAPE) {
            Etapa e = new Etapa(denumire, luna_start, luna_sfarsit); // Create a new Etapa object
            this.etape[nrEtape++] = e; // Add it to the array and increment the stage count
        } else {
            System.out.println("Nu se pot adauga mai multe etape. Limita maxima este de " + NR_MAX_ETAPE + ".");
        }
    }

    // Assign a responsible employee
    public void asignareResponsabil(Angajat responsabil) {
        this.responsabil = responsabil;
    }
    public void afisare() {
        System.out.println("Plan: " + denumire);

        // Display the responsible employee's details
        if (responsabil != null) {
            System.out.println("Responsabil:");
            responsabil.afisare();
        } else {
            System.out.println("Niciun responsabil asignat.");
        }

        // Display details of each stage
        System.out.println("Etape:");
        for (int i = 0; i < nrEtape; i++) {
            etape[i].afisare();
        }
    }

    public void salveazaInFisier(String numeFisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier))) {
            writer.write("Plan: " + denumire + "\n");

            if (responsabil != null) {
                writer.write("Responsabil: " + responsabil.getNume() + ", Salariu: " + responsabil.getSalariu() + "\n");
            } else {
                writer.write("Niciun responsabil asignat.\n");
            }

            for (int i = 0; i < nrEtape; i++) {
                writer.write("Etapa " + (i + 1) + ": " + etape[i].getDenumire() + ", Start: " + etape[i].getLuna_start() + ", Sfarsit: " + etape[i].getLuna_sfarsit() + "\n");
            }
        } catch (IOException e) {
            System.out.println("A aparut o eroare la scrierea in fisier: " + e.getMessage());
        }
    }
    public void stergeEtapa(Integer i) {
        if (i >= 0 && i < nrEtape) {
            for (int j = i; j < nrEtape - 1; j++) {
                etape[j] = etape[j + 1];
            }
            etape[nrEtape - 1] = null; // Remove the last element after shifting
            nrEtape--; // Decrease the number of stages
        } else {
            System.out.println("Index invalid.");
        }
    }


    // Getters and setters for denumire
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    // Getters for etape and nrEtape
    public Etapa[] getEtape() {
        return etape;
    }

    public int getNrEtape() {
        return nrEtape;
    }
    public Angajat getResponsabil() {
        return responsabil;
    }
}
