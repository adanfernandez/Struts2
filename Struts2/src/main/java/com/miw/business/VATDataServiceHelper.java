package com.miw.business;

import java.util.List;

import com.miw.infrastructure.Factories;
import com.miw.model.VAT;

public class VATDataServiceHelper {

	public List<VAT> getVATs() throws Exception {
		return (Factories.dataServices.getVATDataService()).getVATs();
	}
	
	public VAT getVatByTaxGroup(int taxGroup) {
		return (Factories.dataServices.getVATDataService()).getVATByTaxGroup(taxGroup);
	}
}
