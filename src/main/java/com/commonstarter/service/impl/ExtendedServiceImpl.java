package com.commonstarter.service.impl;

import com.commonstarter.repository.ExtendedRepository;
import com.commonstarter.service.ExtendedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;

/**
 * @Author : Xavier PHILIPPONNEAU
 * @param <E>
 * @param <ID>
 */
public abstract class ExtendedServiceImpl<E, ID> implements ExtendedService<E, ID> {

    protected Logger LOGGER;

    protected ExtendedRepository<E, ID> repository;

    @PostConstruct
    private void setup(){
        // works because getClass() sends back child class
        LOGGER = LoggerFactory.getLogger(getClass());
        this.repository = getRepository();
    }

    protected abstract ExtendedRepository<E, ID> getRepository();

    @Override
    @Transactional(readOnly = true)
    public Collection<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(ID id) {
        return repository.findById(id);
    }
}
