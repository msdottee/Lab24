package co.grandcircus.PartiesPizzaLab;

import java.util.Collection;
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
	public String votePage(Model model) {
		List<PartyOption> partyOptions = partyOptionRepository.findAll();
		model.addAttribute("partyOptions", partyOptions);
		return "vote";
	}
	
	@RequestMapping("/addvote")
	public String addVote(@RequestParam Long id) {
		partyOptionRepository.addVote(id);	
		return "redirect:/vote";
	}
	
	@PostMapping("/addOption") 
	public String addOption(PartyOption partyOption) {
		partyOptionRepository.save(partyOption);
		
		return "redirect:/vote";
	}
	
	@GetMapping("/review")
	public String listPopularPartyOptions(Model model) {
		Collection<PartyOption> partyOptions = partyOptionRepository.listPopularPartyOptions();
		model.addAttribute("partyOptions", partyOptions);
		return "/review";
	}
}
