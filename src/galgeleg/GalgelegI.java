package galgeleg;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface GalgelegI extends java.rmi.Remote {
    void nulstil() throws java.rmi.RemoteException;

    void logStatus() throws java.rmi.RemoteException;

    void gætBogstav(String bogstav) throws java.rmi.RemoteException;

    int getAntalForkerteBogstaver() throws java.rmi.RemoteException;

    String getSynligtOrd() throws java.rmi.RemoteException;

    boolean erSpilletSlut() throws java.rmi.RemoteException;

    boolean erSpilletVundet() throws java.rmi.RemoteException;

    boolean erSpilletTabt() throws java.rmi.RemoteException;

    void login(String brugernavn, String adgangskode) throws java.rmi.RemoteException, NotBoundException, MalformedURLException;

    boolean isLoggedIn() throws java.rmi.RemoteException;

    void setLoggedIn(boolean loggedIn) throws java.rmi.RemoteException;

    void hentOrdFraDr() throws Exception;

    String getOrdet() throws RemoteException;
}
