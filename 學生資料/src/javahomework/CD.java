package javahomework;

public class CD {
	private String cid;   //課程代號
	private String cname;   //課程名稱
	public CD(String cid,String cname) {
		this.cid = cid;
		this.cname = cname;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
