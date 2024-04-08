package io.github.wayneh000.playthroughtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.wayneh000.playthroughtracker.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
