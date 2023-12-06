package tn.tekup.rh.achat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.tekup.rh.achat.entities.Facture;
import tn.tekup.rh.achat.entities.Fournisseur;

import java.util.Date;
import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

	
	@Query("SELECT f FROM Facture f where f.fournisseur=:fournisseur and f.archivee=false")
	public List<Facture> getFactureByFournisseur(@Param("fournisseur") Fournisseur fournisseur);

	
	@Query("SELECT sum(f.montantFacture) FROM Facture f where  f.dateCreationFacture between :startDate"
			+ " and :endDate and f.archivee=false")
	float getTotalFacturesEntreDeuxDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Modifying
	@Query("update Facture f set f.archivee=true where f.idFacture=?1")
	void updateFacture(Long id);
	
}
