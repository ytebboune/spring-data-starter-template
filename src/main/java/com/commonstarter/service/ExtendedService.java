package com.commonstarter.service;

import java.util.Collection;
import java.util.Optional;

/**
 * @Author : Xavier PHILIPPONNEAU
 * @param <E>
 * @param <ID>
 */
public interface ExtendedService<E, ID> {

    Collection<E> findAll();

    Optional<E> findById(ID id);
}
