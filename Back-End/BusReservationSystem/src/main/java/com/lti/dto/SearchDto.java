package com.lti.dto;

public class SearchDto {
  private String src;
 private String dest;
 private String fromTime;
 private String toTime;
 private String typeOfUser;
public String getSrc() {
	return src;
}
public void setSrc(String src) {
	this.src = src;
}
public String getDest() {
	return dest;
}
public void setDest(String dest) {
	this.dest = dest;
}
public String getFromTime() {
	return fromTime;
}
public void setFromTime(String fromTime) {
	this.fromTime = fromTime;
}
public String getToTime() {
	return toTime;
}
public void setToTime(String toTime) {
	this.toTime = toTime;
}
public String getTypeOfUser() {
	return typeOfUser;
}
public void setTypeOfUser(String typeOfUser) {
	this.typeOfUser = typeOfUser;
}

}
