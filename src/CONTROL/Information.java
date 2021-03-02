package CONTROL;

public class Information {
	String ID; // mã số
	String Name; // tên
	String GT;//GTs
	java.sql.Date Date; // Ngày sinh
	String NumberPhone; // số điện thoại
	String Address; // địa chỉ
	String CMND; // CMND
	String iDFaculty; // khoa
	String trainingCourse; //Khoá đào tạo
	String TypeOfTraining; // hệ đào tạo
	String degree; // học vị hoặc trình độ
	String academicRank;// học hàm, chức vụ
	String iDClass; //mã lớp
	public Information() {}
	public Information(String iD, String name, String gT, java.sql.Date date, String numberPhone, String address,
			String cMND, String iDFaculty, String trainingCourse, String typeOfTraining, String degree,
			String academicRank, String iDClass) {
		super();
		ID = iD;
		Name = name;
		GT = gT;
		Date = date;
		NumberPhone = numberPhone;
		Address = address;
		CMND = cMND;
		this.iDFaculty = iDFaculty;
		this.trainingCourse = trainingCourse;
		TypeOfTraining = typeOfTraining;
		this.degree = degree;
		this.academicRank = academicRank;
		this.iDClass = iDClass;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGT() {
		return GT;
	}
	public void setGT(String gT) {
		GT = gT;
	}
	public java.sql.Date getDate() {
		return Date;
	}
	public void setDate(java.sql.Date date) {
		Date = date;
	}
	public String getNumberPhone() {
		return NumberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		NumberPhone = numberPhone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getiDFaculty() {
		return iDFaculty;
	}
	public void setiDFaculty(String iDFaculty) {
		this.iDFaculty = iDFaculty;
	}
	public String getTrainingCourse() {
		return trainingCourse;
	}
	public void setTrainingCourse(String trainingCourse) {
		this.trainingCourse = trainingCourse;
	}
	public String getTypeOfTraining() {
		return TypeOfTraining;
	}
	public void setTypeOfTraining(String typeOfTraining) {
		TypeOfTraining = typeOfTraining;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getAcademicRank() {
		return academicRank;
	}
	public void setAcademicRank(String academicRank) {
		this.academicRank = academicRank;
	}
	public String getiDClass() {
		return iDClass;
	}
	public void setiDClass(String iDClass) {
		this.iDClass = iDClass;
	}
	
}
