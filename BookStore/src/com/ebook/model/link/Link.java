package com.ebook.model.link;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Link")
public class Link {
	private String url;
	private String rel;
	private String type;
	
	 public Link() {}
	
	public Link(String url,String rel, String type) {
		
		this.url = url;
		this.rel = rel;
		this.type = type;
	}
	
	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}