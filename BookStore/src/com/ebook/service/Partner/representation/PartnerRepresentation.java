package com.ebook.model.service.Partner.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerRepresentation  {
	private String partnerID;
	private String partnerName;
	private String partnerInfo;
	
	public PartnerRepresentation(){
		
	}

	public String getPartnerID() {
		return partnerID;
	}
	
	public void setPartnerID(String id) {
		this.partnerID = id;
	}
	
	public String getPartnerName() {
		return partnerName;
	}
	
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getPartnerInfo() {
		return partnerInfo;
	}

	public void setPartnerInfo(String partnerInfo) {
		this.partnerInfo = partnerInfo;
	}

}

