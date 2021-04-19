package com.thom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thom.entity.Account;
import com.thom.service.AccountService;
import com.thom.service.dto.AccountDTO;
import com.thom.service.dto.AccountDTOUpdate;
import com.thom.service.dto.PasswordDTO;

@RestController
@RequestMapping(value="/api/account")
public class AccountController {
	@Autowired
	private AccountService  accountService;
	
	@GetMapping("/get-info/{id}")
	public Account getInfo(@PathVariable Long id)
	{
		return accountService.getInfo(id);
	}
	
	@GetMapping("/login/{password}")
	public Account getInfo(@PathVariable String password)
	{
		Optional<Account> optional=accountService.login(password);
		 if(optional.isPresent())
			 return optional.get();
		 return new Account();
	}
	@PutMapping("/update-info")
	public Account updateInfo(@RequestBody AccountDTOUpdate account)
	{
		return accountService.updateInfo(account);
	}
	@PutMapping("change-password")
	public Account changePassword(@RequestBody PasswordDTO passwordDTO)
	{
		return accountService.changePassword(passwordDTO);
	}
	@PostMapping("/create-account")
	public Account createAccount(@RequestBody AccountDTO account)
	{
		return accountService.createAccount(account);
	}
	@GetMapping("/create-default-account")
	public Account createDefaultAccount()
	{
		return accountService.createDefaultAccount();
	}
	@GetMapping("/get-all-account")
	public List<Account> getAll()
	{
		return accountService.getAll();
	}
}
