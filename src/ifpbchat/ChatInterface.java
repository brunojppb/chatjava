/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifpbchat;

/**
 *
 * @author brunopaulino
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface ChatInterface extends Remote{
	public String registrarCliente(String cli) throws RemoteException;
	public void enviarMensagemPrivada(String remetente, String destino, String mensagem) throws RemoteException;
	public void enviarMensagemPublica(String remetente, String mensagem) throws RemoteException;
	public List<String> getMensagensPublicas() throws RemoteException;
        public List<String> getClientesCadastrados() throws RemoteException;
}
