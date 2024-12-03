package com.dailySync.account.repository;

import com.dailySync.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query ("SELECT a FROM Account a WHERE FUNCTION('YEAR', a.accountDate) = :year AND FUNCTION('MONTH', a.accountDate) = :month AND user_id = :userId")
    List<Account> findByUserIdAndYearAndMonth(@Param ("year") int year, @Param ("month") int month, @Param ("userId") Long userId);

    List<Account> findByUser_IdAndAccountDate(Long userId, LocalDate accountDate);
}
