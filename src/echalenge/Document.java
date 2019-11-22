package echalenge;

public class Document {

	private String documentName;

	public Document(String documentName) {
		super();
		this.documentName = documentName;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@Override
	public String toString() {
		return documentName;
	}
	
}
