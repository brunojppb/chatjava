
package ifpbchat;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class Chat extends UnicastRemoteObject implements ChatInterface{
	private static final long serialVersionUID = 1L;
	private List<ClienteInterface> clientes;
	private List<String>mensagensPublicas;

	public Chat() throws RemoteException{
		this.clientes = new ArrayList<ClienteInterface>();
		this.mensagensPublicas = new ArrayList<String>();
	}

	public String registrarCliente(String cli) throws RemoteException{
		ClienteInterface c;
		try {
			 c = (ClienteInterface) Naming.lookup(cli);
			 if(!clientes.isEmpty()){
					for(ClienteInterface cliente : clientes){
						if(cliente.getNome().equals(cli)){
							return "Cliente ja registrado";
						}
					}
				}
			 this.clientes.add(c);
                         for(ClienteInterface cl : clientes){
                             cl.setClientesLogados(this.getClientesCadastrados());
                         }
		} catch (Exception e) {
			System.out.println("Erro: :( " + e.getMessage());
		}
		return "Cliente Registrado com sucesso";
	}

	@Override
	public void enviarMensagemPrivada(String remetente, String destino, String mensagem) throws RemoteException{
		if(!this.clientes.isEmpty()){
			for(ClienteInterface c : clientes){
				if(c.getNome().equals(destino)){
					c.receberMensagem(remetente + ": " + mensagem);
				}
					
			}
		}
	}

	@Override
	public void enviarMensagemPublica(String remetente, String mensagem) throws RemoteException{
		if(!this.clientes.isEmpty()){
			for(ClienteInterface c : clientes)
                            c.receberMensagem(remetente + ": " + mensagem);
		}
	}
	
	public List<String> getMensagensPublicas() throws RemoteException{
		return this.mensagensPublicas;
	}
        
        public List<String> getClientesCadastrados() throws RemoteException{
            List<String> nomes = new ArrayList<String>();
            for(ClienteInterface c : clientes){
                nomes.add(c.getNome());
            }
            return nomes;
        }
	
}
