package models;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class Servidor {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("Chat", new Chat());
			System.out.println("Servidor Iniciado");
		} catch (Exception e) {
		}
	}
}

