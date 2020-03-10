package galgeleg;

import java.rmi.Naming;

public class GalgelegServer {
    public static void main(String[] arg) throws Exception {
        System.setProperty("java.rmi.server.hostname", "ec2-3-21-41-28.us-east-2.compute.amazonaws.com");
        java.rmi.registry.LocateRegistry.createRegistry(9927);
        GalgelegI spil = new GalgelegImpl();

        spil.hentOrdFraDr();
        Naming.rebind("rmi://localhost:9927/galgelegtjeneste", spil);
        System.out.println("Galgelegtjeneste registreret.");
    }
}
