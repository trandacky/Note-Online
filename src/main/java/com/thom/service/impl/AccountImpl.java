package com.thom.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thom.entity.Account;
import com.thom.repository.AccountRepository;
import com.thom.service.AccountService;
import com.thom.service.dto.AccountDTO;
import com.thom.service.dto.AccountDTOUpdate;
import com.thom.service.dto.PasswordDTO;

@Service
public class AccountImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	@Transactional(readOnly = true)
	public Account getInfo(Long id) {

		return accountRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Account> login(String password) {
		return accountRepository.findByPasswordLike(password);

	}

	@Override
	@Transactional
	public Account updateInfo(AccountDTOUpdate accountdto) {
		Account account;
		Optional<Account> accountOptional = accountRepository.findById(accountdto.getId());
		if (accountOptional.isPresent()) {
			account = accountOptional.get();
			account.setUpdateDate(ZonedDateTime.now().toInstant());
			account.setBirthDay(accountdto.getBirthDay());
			account.setName(accountdto.getName());

		} else
			return null;
		return accountRepository.save(account);
	}

	@Override
	@Transactional
	public Account createAccount(AccountDTO accountdto) {
		Account account = new Account();

		try {
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(accountdto.getBirthDay());
			account.setBirthDay(date1.toInstant());
		} catch (ParseException e) {
			return new Account();
		}

		account.setName(accountdto.getName());
		account.setPassword(accountdto.getPassword());
		return accountRepository.save(account);
	}

	@Override
	@Transactional
	public Account createDefaultAccount() {
		Account account = new Account();
		account.setName("thom");
		account.setPassword("12082000");
		return accountRepository.save(account);
	}

	@Override
	public Account changePassword(PasswordDTO passwordDTO) {
		Optional<Account> optional= accountRepository.findById(passwordDTO.getAccountId());
		if(optional.isPresent())
		{
			Account account= optional.get();
			account.setPassword(passwordDTO.getPassword());
			account.setUpdateDate(ZonedDateTime.now().toInstant());
			return accountRepository.save(account);
		}
		return new Account();
	}

	@Override
	public List<Account> getAll() {
		
		return accountRepository.findAll();
	}
}
