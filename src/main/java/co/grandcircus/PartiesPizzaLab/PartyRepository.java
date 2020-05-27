package co.grandcircus.PartiesPizzaLab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PartyRepository extends JpaRepository<Party, Long> {

//	List<Party> findByCategory(String category);
//	
//	
//	List<Party> findByNameContainingIgnoreCase(String name);
	

}
