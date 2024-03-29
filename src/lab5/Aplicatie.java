package lab5;

import java.util.Scanner;

public class Aplicatie {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a Plan object
        Plan plan = new Plan("Plan Dezvoltare 2024");

        // Creating an Angajat object and assigning as the plan's responsabil
        Angajat angajat = new Angajat("Ion Popescu", 3000);
        plan.asignareResponsabil(angajat);

        while (true) {
            System.out.println("Introduceti comanda (e - adauga etapa, s - salveaza plan, a - afiseaza plan, o - iesire):");
            String command = scanner.nextLine();

            switch (command) {
                case "e":
                    // Add a new stage to the plan
                    System.out.println("Introduceti denumirea etapei:");
                    String denumire = scanner.nextLine();
                    System.out.println("Introduceti luna de start:");
                    String lunaStart = scanner.nextLine();
                    System.out.println("Introduceti luna de sfarsit:");
                    String lunaSfarsit = scanner.nextLine();
                    plan.adaugareEtapa(denumire, lunaStart, lunaSfarsit);
                    break;
                case "s":
                    // Save the plan to a file
                    plan.salveazaInFisier("plan_info.txt");
                    System.out.println("Planul a fost salvat in fisier.");
                    break;
                case "a":
                    // Display all information about the plan
                    plan.afisare();
                    break;
                case "o":
                    // Exit the loop
                    System.out.println("Iesire din program.");
                    return;
                case "d":
                    // Remove a stage from the plan
                    System.out.println("Introduceti indexul etapei de sters:");
                    int index;
                    try {
                        index = Integer.parseInt(scanner.nextLine());
                        plan.stergeEtapa(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Va rugam introduceti un numar valid.");
                    }
                    break;
                default:
                    System.out.println("Comanda necunoscuta. Incercati din nou.");
            }
        }
    }
}
