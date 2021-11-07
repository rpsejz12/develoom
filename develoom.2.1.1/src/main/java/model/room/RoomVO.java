package model.room;

import org.springframework.web.multipart.MultipartFile;

public class RoomVO {
	private int rpk;
	private String email;
	private String roomname;
	private String password;
	private String rdatetime;
	private String filepath;
	private MultipartFile fileupload;
	
	
	public int getRpk() {
		return rpk;
	}
	public void setRpk(int rpk) {
		this.rpk = rpk;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRdatetime() {
		return rdatetime;
	}
	public void setRdatetime(String rdatetime) {
		this.rdatetime = rdatetime;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public MultipartFile getFileupload() {
		return fileupload;
	}
	public void setFileupload(MultipartFile fileupload) {
		this.fileupload = fileupload;
	}
	
	
	
	@Override
	public String toString() {
		return "RoomVO [rpk=" + rpk + ", email=" + email + ", roomname=" + roomname
				+ ", password=" + password + ", rdatetime=" + rdatetime + ", filepath=" + filepath + ", fileupload="
				+ fileupload + "]";
	}
}
