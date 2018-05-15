package com.model;

public class graph {
	private int Computer;
	private int office;
	private int router;
	private int server;
	private int swtch;
	public int getComputer() {
		return Computer;
	}
	public void setComputer(int computer) {
		Computer = computer;
	}
	public int getOffice() {
		return office;
	}
	public void setOffice(int office) {
		this.office = office;
	}
	public int getRouter() {
		return router;
	}
	public void setRouter(int router) {
		this.router = router;
	}
	public int getServer() {
		return server;
	}
	public void setServer(int server) {
		this.server = server;
	}
	public int getSwtch() {
		return swtch;
	}
	public void setSwtch(int swtch) {
		this.swtch = swtch;
	}
	
	public void set(int computer,
					int office,
					int router,
					int server,
					int swtch) {
		this.Computer=computer;
		this.office=office;
		this.router=router;
		this.server=server;
		this.swtch=swtch;
	}
	
	
	
}
