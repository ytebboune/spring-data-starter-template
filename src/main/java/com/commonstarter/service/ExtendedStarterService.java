package com.commonstarter.service;

import com.commonstarter.model.common.BaseEntity;

/**
 * @Author : Xavier PHILIPPONNEAU
 * @param <T>
 */
public interface ExtendedStarterService<T extends BaseEntity> extends ExtendedService<T, Long> {
}
