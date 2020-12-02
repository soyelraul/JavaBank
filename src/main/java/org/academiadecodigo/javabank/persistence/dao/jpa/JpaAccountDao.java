package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAccountDao extends GenericJpaDao<AbstractAccount> implements AccountDao {

    public JpaAccountDao() {
        super(AbstractAccount.class);
    }
}