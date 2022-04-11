package bns.transactiion.Services;

import java.util.List;
import bns.transactiion.Entities.Client;

public interface IClientService {
    List<Client> retrieveAllClients();
    public Client getClientByCIN(int ClientCIN);
    public Client getClientByPasseport(String ClientPasseport);
    public long ajouterClient(Client client);
    public Client mettreAjourClient(Client client);
    public String deleteClientByCIN(int ClientCIN);
    public String deleteClientByPasseport(String ClientPasseport);
}
