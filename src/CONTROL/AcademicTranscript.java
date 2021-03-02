package CONTROL;

public class AcademicTranscript {
	String MASV;
	String Name;
	String MAGV;
	String NameGV;
	String Subject; // môn
	String SubjectName;
	String SClass; // lớp
	String ClassName;//tên lớp
	String MaKhoa;
	String TypeSubject;
	int Sotiet; //số tiết học
	int credit; // Tín chỉ
	int Duyet;
	float ProportionCourse; // Tỉ lệ điểm quá trình
	float ProportionMidTerm; // Tỉ lệ điểm giữa kỳ
	float ProportionPractice; // Tỉ lệ điểm thực hành
	float ProportionFinal; // Tỉ lệ điểm cuối kỳ
	float MarkCourse; // Điểm quá trình
	float MarkMidTerm; // Điểm giữa kì
	float MarkPractice; // Điểm Thực hành
	float ExamResults; // Điểm Thi
	float GPA; // Điểm trung bình
	float DRL;
	String scholastic; // năm học
	String semester; // học kì
	public AcademicTranscript() {}
	public AcademicTranscript(String mASV, String name, String mAGV, String nameGV, String subject,String subjectName, String sClass,String className,
			String maKhoa,String typeSubject,int soTiet,int credit, int proportionCourse, int proportionMidTerm, int proportionPractice, int proportionFinal,
			float markCourse, float markMidTerm, float markPractice, float examResults, float gPA,float dRL,
			String scholastic, String semester,int duyet) {
		super();
		MASV = mASV;
		Name = name;
		MAGV = mAGV;
		NameGV = nameGV;
		Subject = subject;
		SubjectName=subjectName;
		SClass = sClass;
		ClassName=className;
		MaKhoa=maKhoa;
		TypeSubject=typeSubject;
		Sotiet=soTiet;
		this.credit = credit;
		ProportionCourse = proportionCourse;
		ProportionMidTerm = proportionMidTerm;
		ProportionPractice = proportionPractice;
		ProportionFinal = proportionFinal;
		MarkCourse = markCourse;
		MarkMidTerm = markMidTerm;
		MarkPractice = markPractice;
		ExamResults = examResults;
		GPA = gPA;
		DRL=dRL;
		this.scholastic = scholastic;
		this.semester = semester;
		Duyet=duyet;
	}

	public String getMASV() {
		return MASV;
	}

	public void setMASV(String mASV) {
		MASV = mASV;
	}

	public String getMAGV() {
		return MAGV;
	}

	public void setMAGV(String mAGV) {
		MAGV = mAGV;
	}

	public String getNameGV() {
		return NameGV;
	}

	public void setNameGV(String nameGV) {
		NameGV = nameGV;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	public String getSClass() {
		return SClass;
	}

	public void setSClass(String sClass) {
		SClass = sClass;
	}

	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getMaKhoa() {
		return MaKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}
	public String getTypeSubject() {
		return TypeSubject;
	}
	public void setTypeSubject(String typeSubject) {
		TypeSubject = typeSubject;
	}
	public int getSotiet() {
		return Sotiet;
	}
	public void setSotiet(int sotiet) {
		Sotiet = sotiet;
	}
	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public float getProportionCourse() {
		return ProportionCourse;
	}

	public void setProportionCourse(float proportionCourse) {
		ProportionCourse = proportionCourse;
	}

	public float getProportionMidTerm() {
		return ProportionMidTerm;
	}

	public void setProportionMidTerm(float proportionMidTerm) {
		ProportionMidTerm = proportionMidTerm;
	}

	public float getProportionPractice() {
		return ProportionPractice;
	}

	public void setProportionPractice(float proportionPractice) {
		ProportionPractice = proportionPractice;
	}

	public float getProportionFinal() {
		return ProportionFinal;
	}

	public void setProportionFinal(float proportionFinal) {
		ProportionFinal = proportionFinal;
	}

	public float getMarkCourse() {
		return MarkCourse;
	}

	public void setMarkCourse(float markCourse) {
		MarkCourse = markCourse;
	}

	public float getMarkMidTerm() {
		return MarkMidTerm;
	}

	public void setMarkMidTerm(float markMidTerm) {
		MarkMidTerm = markMidTerm;
	}

	public float getMarkPractice() {
		return MarkPractice;
	}

	public void setMarkPractice(float markPractice) {
		MarkPractice = markPractice;
	}

	public float getExamResults() {
		return ExamResults;
	}

	public void setExamResults(float examResults) {
		ExamResults = examResults;
	}

	public float getGPA() {
		return GPA;
	}

	public void setGPA(float gPA) {
		GPA = gPA;
	}

	public float getDRL() {
		return DRL;
	}
	public void setDRL(float dRL) {
		DRL = dRL;
	}
	public String getScholastic() {
		return scholastic;
	}

	public void setScholastic(String scholastic) {
		this.scholastic = scholastic;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getDuyet() {
		return Duyet;
	}
	public void setDuyet(int duyet) {
		Duyet = duyet;
	}
}
