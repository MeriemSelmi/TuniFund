package tn.startupfactoy.tunifund.domain;

public class Image {

	private String id;
	private String label;
	private String link;
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(String id, String label, String link) {
		super();
		this.id = id;
		this.label = label;
		this.link = link;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
