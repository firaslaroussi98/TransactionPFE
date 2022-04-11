package bns.transactiion.Repository;

import bns.transactiion.Entities.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmetteurRepository extends JpaRepository<Emetteur, Long> {

    Emetteur findByIdemetteur(String idemetteur);

}
