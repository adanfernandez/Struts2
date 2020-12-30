package com.miw.persistence.vat;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.miw.model.VAT;
import com.miw.persistence.Dba;

public class VATDAO implements VATDataService  {

	protected Logger logger = Logger.getLogger(getClass());

	public List<VAT> getVATs() throws Exception {

		List<VAT> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			resultList = em.createQuery("Select a From VAT a", VAT.class).getResultList();

			logger.debug("Result list: "+ resultList.toString());

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return resultList;
	}
	
	public VAT getVATByTaxGroup(int taxGroup) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			VAT vat = em.createQuery("SELECT v FROM VAT v WHERE v.taxGroup = ?", VAT.class)
					.setParameter(1, taxGroup)
					.getSingleResult();
			return vat;
		} catch(Exception e) {
			return null;
		} finally {
			dba.closeEm();
		}
	}
}