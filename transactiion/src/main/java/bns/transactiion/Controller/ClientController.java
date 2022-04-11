package bns.transactiion.Controller;

import bns.transactiion.DTO.ClientDto;
import bns.transactiion.Services.IClientService;
import bns.transactiion.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import bns.transactiion.Repository.ClientRepository;
import java.util.List;
import org.modelmapper.ModelMapper;


@RestController
public class ClientController {
    @Autowired
    IClientService clientService;
    @Autowired
    ClientRepository clientrepo;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/retrieve-all-clients")
    public List<Client> getAllClients()
    {
        List<Client> liste = clientService.retrieveAllClients();
        return liste;
    }

    //recherche a partir du service
    @GetMapping ("/retrieve-client/{client-CIN}")
    public Client retrieveClientByCIN(@PathVariable ("client-CIN") int ClientCIN)
    {
        return clientService.getClientByCIN(ClientCIN);
    }

    @GetMapping ("/retrieve-client/{client-password}")
    public Client retrieveClientByPassport(@PathVariable ("client-password") String ClientPassport)
    {
        return clientService.getClientByPasseport(ClientPassport);
    }

    // recherche a partir du repository
    @GetMapping ("/retrieve-client/{client-RNE}")
    public Client retrieveClientByRNE(@PathVariable ("client-RNE") String ClientRNE)
    {
        return clientrepo.findByRne(ClientRNE);
    }


    @PostMapping ("/add-client")
    @ResponseBody
    public long addClient(@RequestBody ClientDto clientdto)
    {
        Client client = modelMapper.map(clientdto, Client.class);
        return clientService.ajouterClient(client);
    }

    @PutMapping("/modify-client")
    public Client modifyClient(@RequestBody Client client )
    {
        return clientService.mettreAjourClient(client);
    }

    @DeleteMapping("remove-client/{client-CIN}")
    public void removeClientByCIN(@PathVariable("client-CIN") int ClientCIN)
    {
        clientService.deleteClientByCIN(ClientCIN);
    }

    @DeleteMapping("remove-client/{client-password}")
    public void removeClientByPassport(@PathVariable("client-password") String ClientPassport)
    {
        clientService.deleteClientByPasseport(ClientPassport);
    }

    @DeleteMapping("remove-client/{client-RNE}")
    public void removeClientByRNE(@PathVariable("client-RNE") String ClientRNE)
    {
        clientrepo.deleteClientByRNE(ClientRNE);
    }

}
