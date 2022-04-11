package bns.transactiion.Services;

import bns.transactiion.Entities.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bns.transactiion.Repository.ClientRepository;

import java.util.List;

@Slf4j
@Service
public class ClientServiceImpl implements IClientService{

    @Autowired
    ClientRepository clientrepo;


    @Override
    public List<Client> retrieveAllClients() {
        return (List<Client>) clientrepo.findAll();
    }

    @Override
    public Client getClientByCIN(int ClientCIN) {

        return clientrepo.findByCin(ClientCIN);
    }

    @Override
    public Client getClientByPasseport(String ClientPasseport) {
        return clientrepo.findByPasseport(ClientPasseport);
    }



    @Override
    public long ajouterClient(Client client) {
        log.info("debut ajout");
        try {
            clientrepo.save(client);
            log.info("l'ajout est realise avec succés, fin methode ajouterClient");
        }
        catch (Exception e){
            log.error("erreur d'ajout");
        }
        return client.getId();
    }

    @Override
    public Client mettreAjourClient(Client client) {
        return clientrepo.save(client);
    }

    @Override
    public String deleteClientByCIN(int ClientCIN) {
        String msg="";
        try {
            log.info("Finding Client with CIN = %d"+ClientCIN);
            clientrepo.deleteClientByCIN(ClientCIN);
            log.info("Client Deleted Successfuly ");
            msg="Delete Done";
        }catch (Exception e){
            log.error("The client with CIN = %d does not Exist"+ClientCIN);
            msg="error";
        }


        return msg;
    }

    @Override
    public String deleteClientByPasseport(String ClientPasseport) {

        String msg="";
        try {
            log.info("Finding Client with Passeport = %s"+ClientPasseport);
            clientrepo.deleteClientByPasseport(ClientPasseport);
            log.info("Client Deleted Successfuly ");
            msg="Delete Done";
        }catch (Exception e){
            log.error("The client with Passeport = %s does not Exist"+ClientPasseport);
            msg="error";
        }


        return msg;
    }
}
