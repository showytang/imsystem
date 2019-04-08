package com.imsystem.service.statistics;

import com.imsystem.domain.Store;

public interface StoreService {
    Store selectByPrimaryKey(String id);
}
