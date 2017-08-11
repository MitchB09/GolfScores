package com.realsocres.dao;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ContextConfiguration
@EnableJpaRepositories
@TestPropertySource("classpath:test.properties")
public class DaoTestBaseClass extends AbstractTransactionalTestNGSpringContextTests {
	
}
