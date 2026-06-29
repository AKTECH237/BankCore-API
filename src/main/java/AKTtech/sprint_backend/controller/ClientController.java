package AKTtech.sprint_backend.controller;

import AKTtech.sprint_backend.model.Client;
import AKTtech.sprint_backend.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // GET tous les clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // GET un client par ID
    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    // POST créer un client
    @PostMapping
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.createClient(client);
    }

    // PUT modifier un client
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable String id,@Valid  @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    // DELETE supprimer un client
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
}