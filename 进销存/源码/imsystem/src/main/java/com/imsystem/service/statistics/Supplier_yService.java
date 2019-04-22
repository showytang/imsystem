package com.imsystem.service.statistics;

import java.util.List;

import com.imsystem.domain.Supplier;

public interface Supplier_yService {
	List<Supplier> querySupplier_yByStore(String sid);
}
