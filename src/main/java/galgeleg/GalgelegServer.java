package main.java.galgeleg;

import io.javalin.Javalin;

import java.rmi.Naming;

public class GalgelegServer {
    public static void main(String[] arg) throws Exception {
        System.setProperty("java.rmi.server.hostname", "http://localhost:8080");
        java.rmi.registry.LocateRegistry.createRegistry(9927);
        Javalin app = Javalin.create()
                .port(8080)
                .start();
        app.get("/getword", GalgelegRest.restGetOrdet);
        app.get("/postguess", GalgelegRest.restGæt);
        app.get("/login", GalgelegRest.restLogin);
        GalgelegImpl spil = new GalgelegImpl();
        spil.hentOrdFraDr();
        Naming.rebind("rmi://localhost:9927/galgelegtjeneste", spil);
        System.out.println("Galgelegtjeneste registreret.");
    }
}
