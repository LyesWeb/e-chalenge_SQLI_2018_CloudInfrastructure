package echalenge;

import java.util.ArrayList;
import java.util.List;

public class Store {

	private String storeName;
	private List<Document> documents;

	public Store(String storeName) {
		super();
		this.storeName = storeName;
		this.documents = new ArrayList<Document>();
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public void addDocument(String documentName) {
		this.documents.add(new Document(documentName));
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		String str = storeName+":";
		if(this.documents.size()==0) return str += "empty";
		int i = 0;
		for(Document document:this.documents) {
			if(i==this.documents.size()-1) 
			str += document.toString();
			else str += document.toString()+", ";
			i++;
		}
		return str;
	}
	
}
