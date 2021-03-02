package CONTROL;

public class CalculationAcademicTranscript {

	public float AverageGPA(AcademicTranscript gpa) {
		gpa.GPA = (gpa.MarkCourse * gpa.ProportionCourse + gpa.MarkMidTerm *  gpa.ProportionMidTerm
				+ gpa.MarkPractice * gpa.ProportionPractice
				+ gpa.ExamResults *  gpa.ProportionFinal) / 100;
		// tính điểm trung bình cuối kì
		return gpa.GPA;
	}
}
