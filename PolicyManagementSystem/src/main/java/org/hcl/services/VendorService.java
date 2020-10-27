package org.hcl.services;

import org.hcl.entities.Vendor;

public interface VendorService {
	public boolean insertVendor(Vendor vendor);
	public Vendor verifyVendor(Vendor vendor);

}
