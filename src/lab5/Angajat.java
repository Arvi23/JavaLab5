package lab5;

public class Angajat extends Persoana {
    private int salariu;

    // Parameterized constructor
    public Angajat(String nume, int salariu) {
        super(nume); // Initialize the inherited field 'nume'
        this.salariu = salariu; // Initialize the field specific to 'Angajat'
    }

    // afisare method to display personal data
    public void afisare() {
        System.out.println("Nume: " + getNume() + ", Salariu: " + salariu);
    }

    // Getter and setter for salariu
    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    // Additional methods as needed
}
