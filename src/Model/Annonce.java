package Model;

public class Annonce {
   public int annonce_id;
   public String titre;
   public String content;
   public String date_ajoute;
   public int adminID;
   
   public Annonce() {
		super();
		
	}
 
   
public Annonce(int annonce_id, String titre, String content, String date_ajoute, int adminID) {
	super();
	this.annonce_id = annonce_id;
	this.titre = titre;
	this.content = content;
	this.date_ajoute = date_ajoute;
	this.adminID = adminID;
}


public Annonce(String titre, String content, String date_ajoute, int adminID) {
	super();
	this.titre = titre;
	this.content = content;
	this.date_ajoute = date_ajoute;
	this.adminID = adminID;
}


public int getAnnonce_id() {
	return annonce_id;
}


public void setAnnonce_id(int annonce_id) {
	this.annonce_id = annonce_id;
}


public String getTitre() {
	return titre;
}


public void setTitre(String titre) {
	this.titre = titre;
}


public String getContent() {
	return content;
}


public void setContent(String content) {
	this.content = content;
}


public String getDate_ajoute() {
	return date_ajoute;
}


public void setDate_ajoute(String date_ajoute) {
	this.date_ajoute = date_ajoute;
}


public int getAdminID() {
	return adminID;
}


public void setAdminID(int adminID) {
	this.adminID = adminID;
}
   
   
   
   
}


