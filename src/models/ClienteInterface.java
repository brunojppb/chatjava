/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author brunopaulino
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface ClienteInterface extends Remote{

	public String getNome() throws RemoteException;

	public void setNome(String nome) throws RemoteException;
	
	public List<String> getMensagensPrivadas() throws RemoteException;
	
	public void setMensagensPrivadas(List<String> mensagensPrivadas) throws RemoteException;
	
	public void receberMensagemPrivada(String msg) throws RemoteException;
        
        public void setClientesLogados(List<String> nomes) throws RemoteException;
        
        public void setDelegate(InterfaceController delegate) throws RemoteException;
}
