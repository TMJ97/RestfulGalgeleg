package galgeleg;

import java.rmi.Naming;

public class GalgelegServer {
    public static void main(String[] arg) throws Exception {
//        System.setProperty("java.rmi.server.hostname", "dist.saluton.dk"); // TODO-NOTE: COMMENT THIS OUT IF RUNNING LOCALLY
        java.rmi.registry.LocateRegistry.createRegistry(9927);
        GalgelegI spil = new GalgelegImpl();
        spil.hentOrdFraDr();
        Naming.rebind("rmi://localhost:9927/galgelegtjeneste", spil);
        System.out.println("Galgelegtjeneste registreret.");
    }
}
