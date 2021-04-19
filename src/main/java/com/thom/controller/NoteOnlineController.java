package com.thom.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.thom.entity.Account;
import com.thom.entity.Note;
import com.thom.service.AccountService;
import com.thom.service.NoteService;

@Controller
@RequestMapping(value = "/")
public class NoteOnlineController {

	@Autowired
	private NoteService noteService;
	@Autowired
	private AccountService accountService;

	@GetMapping("get-all")
	public List<Note> getAllNote(@PathVariable Long id) {
		return noteService.getAllNote(id);
	}

	@GetMapping("/seach")
	public String getNote(@RequestParam("password") String password, Model model, HttpServletRequest request) {
		Optional<Account> accountOptional;
		if (!password.equals("")) {
			accountOptional = accountService.login(password);

			if (accountOptional.isPresent()) {

				model.addAttribute("account", accountOptional.get());
				model.addAttribute("listNote", accountOptional.get().getNotes());
				if(accountOptional.get().getNotes().isEmpty())
					model.addAttribute("note", "Chưa có gì hết");
			}
			else
			{
				model.addAttribute("note", "Sai pass rồi");
			}
		}
		else
			model.addAttribute("note", "Nhập rỗng nữa là coi chừng");
		return "index";
	}

	@GetMapping
	public String home(Model model, HttpServletRequest request) {
		//model.addAttribute("note", "Chưa nhập note");
		return "index";
	}
}
