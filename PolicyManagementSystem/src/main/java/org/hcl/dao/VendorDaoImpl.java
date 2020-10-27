package org.hcl.dao;

import org.hcl.entities.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class VendorDaoImpl implements VendorDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public boolean insert(Vendor vendor) {
		boolean isInserted=false;
		Session session=factory.openSession();
		Integer i=(Integer)session.save(vendor);
		if(i==vendor.getVendorId())
			isInserted=true;
		session.close();
		return isInserted;
	}

	@Override
	public Vendor verifyVendor(Vendor vendor) {
		Session session = factory.getCurrentSession();
		System.out.println(vendor.getUserName());
		System.out.println(vendor.getPassword());
		String query = "from org.hcl.entities.Vendor v where v.userName=:userName and v.password=:password";
		Vendor verifiedVendor = (Vendor) session.createQuery(query).setParameter("userName", vendor.getUserName())
				.setParameter("password", vendor.getPassword()).uniqueResult();
		if (verifiedVendor != null) {
			System.out.println(verifiedVendor.getUserName());
			return verifiedVendor;
		}else {
		return null; 
		}
	}

}
