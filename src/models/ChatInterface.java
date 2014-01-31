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


public interface ChatInterface extends Remote{
	public String registrarCliente(String cli) throws RemoteException;
	public String enviarMensagemPrivada(String remetente, String destino, String mensagem) throws RemoteException;
	public String enviarMensagemPublica(String remetente, String mensagem) throws RemoteException;
	public List<String> getMensagensPublicas() throws RemoteException;
        public List<ClienteInterface> getClientesCadastrados() throws RemoteException;
}
