package tn.iit.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.iit.dao.UserDao;
import tn.iit.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("allUsers", userDao.getAll());
		return "/user/list";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		User user = userDao.getById(id);
		if (user != null) {
			userDao.remove(user);
		}
		return "redirect:/user/list";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String setupAddForm(Model model) {
		model.addAttribute("action", "addUser");
		return "/user/form";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String setupUpdateForm(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("user", userDao.getById(id));
		model.addAttribute("action", "updateUser");
		return "/user/form";

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String add(@ModelAttribute User user) {
		user.setRole("ROLE_ADMIN");
		userDao.add(user);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/update/updateUser", method = RequestMethod.POST)
	public String update(@ModelAttribute User user) {
		user.setRole("ROLE_ADMIN");
		userDao.update(user);

		return "redirect:/user/list";
	}

}
