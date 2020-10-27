package org.hcl.services;

import javax.transaction.Transactional;

import org.hcl.dao.VendorDao;
import org.hcl.entities.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDao dao;

	@Override
	@Transactional
	public boolean insertVendor(Vendor vendor) {
		boolean b = dao.insert(vendor);
		return b;
	}

	@Override
	@Transactional
	public Vendor verifyVendor(Vendor vendor) {
		return dao.verifyVendor(vendor);
	}

}
