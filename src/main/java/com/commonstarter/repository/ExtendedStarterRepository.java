package com.commonstarter.repository;

import com.commonstarter.model.common.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author : Xavier PHILIPPONNEAU
 * @param <E>
 */
@NoRepositoryBean
public interface ExtendedStarterRepository<E extends BaseEntity> extends ExtendedRepository<E, Long> {
}
