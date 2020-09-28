package javahomework;

public class SCD {
	private String id;     //學生代號
	private String cid;   //課程代號
	public SCD(String id,String cid) {
		this.id = id;
		this.cid = cid;

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
}
