package com.ebook.model.link;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Link")
public class Link {
	private String relation;
	private String url;
	private String MediaType;
	
	public String getRealtion() {
		return relation;
	}

	public void setRealtion(String realtion) {
		this.relation = realtion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMediaType() {
		return MediaType;
	}

	public void setMediaType(String mediaType) {
		MediaType = mediaType;
	}
	
}