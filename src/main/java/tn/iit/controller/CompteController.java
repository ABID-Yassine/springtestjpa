package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tn.iit.dao.CompteDao;
import tn.iit.dao.UserDao;
import tn.iit.entities.Compte;

@Controller
@RequestMapping("/compte")
public class CompteController {

	@Autowired
	private CompteDao compteDao;

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("allComptes", compteDao.findAll());
		return "/compte/list";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		Compte compte = compteDao.findById(id).get();
		if (compte != null) {
			compteDao.delete(compte);
		}
		return "redirect:/compte/list";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String setupAddForm(Model model) {
		model.addAttribute("users", userDao.getAll());
		model.addAttribute("action", "addCompte");
		return "/compte/form";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String setupUpdateForm(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("compte", compteDao.findById(id).get());
		model.addAttribute("users", userDao.getAll());
		model.addAttribute("action", "updateCompte");
		return "/compte/form";

	}

	@RequestMapping(value = "/addCompte", method = RequestMethod.POST)
	public String add(@ModelAttribute Compte compte, @RequestParam Long idUser) {
		compte.setUser(userDao.getById(idUser));
		compteDao.saveAndFlush(compte);
		return "redirect:/compte/list";
	}

	@RequestMapping(value = "/update/updateCompte", method = RequestMethod.POST)
	public String update(@ModelAttribute Compte compte,@RequestParam Long idUser) {
		compte.setUser(userDao.getById(idUser));
		compteDao.saveAndFlush(compte);
		return "redirect:/compte/list";
	}

}
