package co.grandcircus.PartiesPizzaLab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="partyoptions")
public class PartyOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private int votes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = 0;
	}
	
	@Override
	public String toString() {
		return "PartyOption [id=" + id + ", name=" + name + ", description=" + description + ", votes=" + votes + "]";
	}
}
