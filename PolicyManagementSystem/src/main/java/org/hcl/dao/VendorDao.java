package org.hcl.dao;

import org.hcl.entities.Vendor;

public interface VendorDao {
	public boolean insert(Vendor vendor);
	public Vendor verifyVendor(Vendor vendor);
}
