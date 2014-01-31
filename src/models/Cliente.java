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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class Cliente extends UnicastRemoteObject implements ClienteInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private List<String>mensagensPrivadas;

	public Cliente(String nome) throws RemoteException{
		this.nome = nome;
		this.mensagensPrivadas = new ArrayList<String>();
	}

	public String getNome() throws RemoteException{
		return nome;
	}

	public void setNome(String nome) throws RemoteException{
		this.nome = nome;
	}

	public List<String> getMensagensPrivadas() throws RemoteException{
		return mensagensPrivadas;
	}

	public void setMensagensPrivadas(List<String> mensagensPrivadas) throws RemoteException{
		this.mensagensPrivadas = mensagensPrivadas;
	}
	
	public void receberMensagemPrivada(String msg) throws RemoteException{
		this.mensagensPrivadas.add(msg);
	}
        
}
