package com.thom.service;

import java.util.List;
import java.util.Optional;

import com.thom.entity.Account;
import com.thom.service.dto.AccountDTO;
import com.thom.service.dto.AccountDTOUpdate;
import com.thom.service.dto.PasswordDTO;

public interface AccountService {

	Account getInfo(Long id);

	Optional<Account> login(String password);

	Account updateInfo(AccountDTOUpdate account);

	Account createAccount(AccountDTO account);

	Account createDefaultAccount();

	Account changePassword(PasswordDTO passwordDTO);

	List<Account> getAll();

}
