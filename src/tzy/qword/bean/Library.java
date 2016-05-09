package tzy.qword.bean;

import java.sql.Date;

public class Library {

  Long createdTime;
  
  String libraryName;
  
  String introdu;
  
public Long getCreatedTime() {
	return createdTime;
}

public void setCreatedTime(Long createdTime) {
	this.createdTime = createdTime;
}

public String getIntrodu() {
	return introdu;
}

public void setIntrodu(String introdu) {
	this.introdu = introdu;
}

public String getLibraryName() {
	return libraryName;
}

public void setLibraryName(String libraryName) {
	this.libraryName = libraryName;
}
	
}
