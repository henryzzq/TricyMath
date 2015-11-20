package com.tricy.model;

public class Chance {
	protected String issue = "";
	protected Integer redBall1 = 0;
	protected Integer redBall2 = 0;
	protected Integer redBall3 = 0;
	protected Integer redBall4 = 0;
	protected Integer redBall5 = 0;
	protected Integer redBall6 = 0;
	protected Integer blueBall = 0;
	public Chance()
	{
		
	}
	public Chance(String issue,
				  String r1, 
				  String r2, 
				  String r3, 
				  String r4, 
				  String r5, 
				  String r6, 
				  String b)
	{
		this.issue = issue;
		redBall1 = Integer.parseInt(r1);
		redBall2 = Integer.parseInt(r2);
		redBall3 = Integer.parseInt(r3);
		redBall4 = Integer.parseInt(r4);
		redBall5 = Integer.parseInt(r5);
		redBall6 = Integer.parseInt(r6);
		//orderReadBall();
		blueBall = Integer.parseInt(b);
	}
	public Chance(String issue)
	{
		this.issue = issue;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public Integer getRedBall1() {
		return redBall1;
	}
	public void setRedBall1(Integer redBall1) {
		this.redBall1 = redBall1;
	}
	public Integer getRedBall2() {
		return redBall2;
	}
	public void setRedBall2(Integer redBall2) {
		this.redBall2 = redBall2;
	}
	public Integer getRedBall3() {
		return redBall3;
	}
	public void setRedBall3(Integer redBall3) {
		this.redBall3 = redBall3;
	}
	public Integer getRedBall4() {
		return redBall4;
	}
	public void setRedBall4(Integer redBall4) {
		this.redBall4 = redBall4;
	}
	public Integer getRedBall5() {
		return redBall5;
	}
	public void setRedBall5(Integer redBall5) {
		this.redBall5 = redBall5;
	}
	public Integer getRedBall6() {
		return redBall6;
	}
	public void setRedBall6(Integer redBall6) {
		this.redBall6 = redBall6;
	}
	public Integer getBlueBall() {
		return blueBall;
	}
	public void setBlueBall(Integer blueBall) {
		this.blueBall = blueBall;
	}
	@Override
	public String toString() {
		return issue + " " + redBall1 + " " + redBall2 + " " + redBall3 + " " + redBall4 + " " + redBall5 + " " + redBall6 + " " + blueBall;
	}
	
}
