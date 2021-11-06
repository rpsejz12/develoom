package model.page;

public class PageVO {
	
	private int curPage;	
	private int startPage;	
	private int endPage;	
	private int lastPage;	
	private int total;		
	private int perPage;	
	private int perPageSet; 
	private int start;		
	private int end;
	
	private String email;
	private String type;
	
	

	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}	
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}	
	public int getPerPageSet() {
		return perPageSet;
	}
	public void setPerPageSet(int perPageSet) {
		this.perPageSet = perPageSet;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return "PageVO [curPage=" + curPage + ", startPage=" + startPage + ", endPage=" + endPage + ", lastPage="
				+ lastPage + ", total=" + total + ", perPage=" + perPage + ", perPageSet=" + perPageSet + ", start="
				+ start + ", end=" + end + ", email=" + email + ", type=" + type + "]";
	}
	

	
	
}
