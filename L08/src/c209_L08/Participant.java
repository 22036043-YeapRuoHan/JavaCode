package c209_L08;


/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22036043, Jul 4, 2023 11:31:36 AM
 

 * @author 22036043
 *
 */
public class Participant {
	String nric;
	String name;
	int mobileNum;
	
	public Participant(String nric, String name, int mobileNum) {
		super();
		this.nric = nric;
		this.name = name;
		this.mobileNum = mobileNum;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(int mobileNum) {
		this.mobileNum = mobileNum;
	}

}
