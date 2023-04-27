package com.learnjdbc.service;


import com.learnjdbc.model.SupplierModel;

import java.util.List;

public interface ISupplierService {
	boolean save(SupplierModel supplierModel);

	boolean update(SupplierModel supplierModel);

	boolean delete(long[] ids);

	List<SupplierModel> getAll();
}
