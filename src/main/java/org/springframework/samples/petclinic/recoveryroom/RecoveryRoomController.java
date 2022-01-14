package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	
	private RecoveryRoomService recoveryRoomService;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}
    
	@ModelAttribute("types")
	public List<RecoveryRoomType> PopulateTypes(){
		return recoveryRoomService.getAllRecoveryRoomTypes();
	}
	
	@GetMapping("/create")
	public String initRecoveryRoomCreationForm(ModelMap model) {
		RecoveryRoom rr = new RecoveryRoom();
		model.addAttribute("recoveryRoom", rr);
		return "recoveryroom/createOrUpdateRecoveryRoomForm";
	}
	
	@PostMapping("/create")
	public String initRecoveryRoomCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) {
		if(result.hasErrors()) {
			return "recoveryroom/createOrUpdateRecoveryRoomForm";
		} else {
			recoveryRoomService.save(recoveryRoom);
		}
		
		return "welcome";
	}
	
	
}
