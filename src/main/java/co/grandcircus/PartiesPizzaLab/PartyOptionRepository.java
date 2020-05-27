package co.grandcircus.PartiesPizzaLab;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PartyOptionRepository extends JpaRepository<PartyOption, Long> {
	
	@Query(value = "UPDATE PartyOption p SET p.votes = p.votes + 1 WHERE p.id = :id")
	@Modifying
	@Transactional //needed this because JPA requires updates to take place in a transaction
	public void addVote(Long id);

	@Query(value = "SELECT p FROM PartyOption p WHERE p.votes > 0 AND p.party.id = :id ORDER BY p.votes DESC")
	public Collection<PartyOption> listPopularPartyOptionsAndFindById(Long id); 
	
	public Collection<PartyOption> findByPartyId(Long id);
}
