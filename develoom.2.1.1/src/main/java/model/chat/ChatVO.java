package model.chat;

public class ChatVO {
	private int cpk;
	private String email;
	private String content;
	private String cdatetime;
	public int getCpk() {
		return cpk;
	}
	public void setCpk(int cpk) {
		this.cpk = cpk;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCdatetime() {
		return cdatetime;
	}
	public void setCdatetime(String cdatetime) {
		this.cdatetime = cdatetime;
	}
	
	@Override
	public String toString() {
		return "ChatVO [cpk=" + cpk + ", email=" + email + ", content=" + content + ", cdatetime=" + cdatetime + "]";
	}
}


