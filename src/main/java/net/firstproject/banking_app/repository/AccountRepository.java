package net.firstproject.banking_app.repository;

import net.firstproject.banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, Long> {

}
