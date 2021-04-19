package com.thom.service.impl;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thom.entity.Account;
import com.thom.repository.AccountRepository;
import com.thom.service.AccountService;
import com.thom.service.dto.AccountDTO;
import com.thom.service.dto.AccountDTOUpdate;

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
			account.setUpdateDate(Instant.now());
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
		account.setBirthDay(accountdto.getBirthDay());
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
}
