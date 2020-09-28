package javahomework;

public class DD {
	private String did;     //科系代號
	private String dname;   //科系名稱
	public DD(String did,String dname) {
		this.did = did;
		this.dname = dname;

	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
}
