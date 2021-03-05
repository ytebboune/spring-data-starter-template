package com.commonstarter.service.impl;

import com.commonstarter.model.common.BaseEntity;
import com.commonstarter.service.ExtendedStarterService;

/**
 * @Author : Xavier PHILIPPONNEAU
 * @param <T>
 */
public abstract class ExtendedStarterServiceImpl<T extends BaseEntity>
        extends ExtendedServiceImpl<T, Long> implements ExtendedStarterService<T> {

}
