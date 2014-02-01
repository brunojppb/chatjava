/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author brunopaulino
 */
public interface InterfaceController extends Remote{
    public void atualizarContatos(List<String> nomes) throws RemoteException;
}
