package co.grandcircus.PartiesPizzaLab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaPartiesController {

	@Autowired
	private PartyRepository partyRepository;
	
	@Autowired
	private PartyOptionRepository partyOptionRepository;
	
	@RequestMapping("/")
	public String listParties(Model model) {
		List<Party> parties = partyRepository.findAll();
		model.addAttribute("parties", parties);
			
		return "homepage";
	}
	
	@RequestMapping("/vote")
	public String listVotePage(@RequestParam Long id, Model model) {
		model.addAttribute("partyOptions", partyOptionRepository.findByPartyId(id));
		model.addAttribute("party", partyRepository.findById(id).orElse(null));
		return "vote";
	}
	
	@RequestMapping("/addvote")
	public String addVote(@RequestParam Long id, @RequestParam Long partyId) {
		partyOptionRepository.addVote(id);	
		return "redirect:/vote?id=" + partyId;
	}
	
	@PostMapping("/addOption") 
	public String addOption(@RequestParam Long party, PartyOption partyOption) {
		Party retrievedParty = partyRepository.findById(party).orElse(null);
		partyOption.setParty(retrievedParty);
		partyOptionRepository.save(partyOption);
		
		return "redirect:/vote?id=" + party;
	}
	
	@GetMapping("/review")
	public String listPopularPartyOptions(@RequestParam Long id, Model model) {
		model.addAttribute("partyOptions", partyOptionRepository.listPopularPartyOptionsAndFindById(id));
		return "review";
	}
}
