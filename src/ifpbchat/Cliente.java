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
        private List<String>clientesLogados;
        private InterfaceController delegate;

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
        
        public void receberMensagem(String msg) throws RemoteException{
		this.delegate.atualizarMensagens(msg);
	}
        
        public void setClientesLogados(List<String> nomes) throws RemoteException{
            this.clientesLogados = nomes;
            this.delegate.atualizarContatos(nomes);
        }
        
        public void setDelegate(InterfaceController delegate) throws RemoteException{
            this.delegate = delegate;
        }
}
