package com.commonstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author : Xavier PHILIPPONNEAU
 * @param <E>
 * @param <ID>
 */
@NoRepositoryBean
public interface ExtendedRepository<E, ID> extends JpaRepository<E, ID> {
}
