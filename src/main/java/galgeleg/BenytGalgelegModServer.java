package galgeleg;

import java.rmi.Naming;
import java.util.Scanner;

public class BenytGalgelegModServer {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String brugernavn;
        String adgangskode;

        /**
        TODO-Note: This works with the Server running on Amazon Server
        */
        GalgelegI spil = (GalgelegI) Naming.lookup("rmi://ec2-user@ec2-3-21-41-28.us-east-2.compute.amazonaws.com:9927/galgelegtjeneste");
        spil.setLoggedIn(false); //Not perfect solution but it was a quick one!

        while (!spil.isLoggedIn()) {
            System.out.println("Hey, indtast dit brugernavn!");
            brugernavn = scan.nextLine();
            System.out.println("Du intastede brugernavnet:::" + brugernavn + ":::");
            System.out.println("Hey, nu skal du indtaste din adgangskode!");
            adgangskode = scan.nextLine();
            System.out.println("Du intastede adgangskoden:::" + adgangskode + ":::");
            spil.login(brugernavn, adgangskode);
        }
        System.out.println("Nice, du er logged in");



        spil.nulstil();
        spil.logStatus();
        System.out.println("Spillet er startet.");
        while (!spil.erSpilletSlut()) {
            System.out.println("" + spil.getAntalForkerteBogstaver());
            System.out.println("" + spil.getSynligtOrd());
            System.out.println("Indtast dit gæt nedenfor - venligst kun a-z+æøå : ingen input check impl. endnu");
            spil.gætBogstav(scan.nextLine());
            spil.logStatus();
        }
        if (spil.erSpilletVundet()) {
            System.out.println("Tillykke, du vandt!");
        } else System.out.println("Du tabte, prøv igen eller hold en pause.");
    }
}

