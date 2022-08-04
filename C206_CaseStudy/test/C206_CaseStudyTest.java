import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Student student = new Student ("", "", "", "", "", "");
	private Student student2  = new Student ("", "", "", "", "", "");
	
	private String studentID = "";
	private String studentName = "";
	private String studentGrade = "";
	private String studentClass = "";
	private String studentTeacher = "";
	private String studentCCA = "";
	
	private String studentID1 = "";
	private String studentName1 = "";
	private String studentGrade1 = "";
	private String studentClass1 = "";
	private String studentTeacher1 = "";
	private String studentCCA1 = "";
	
	private String parentName = "";
	private String parentName2 = "";
	private String parentEmail = "";
	private String parentEmail2 = "";
	
	private int contact = 0;
	private int contact2 = 0;
	private Parent parent = new Parent(student, "", "", 0);
	private Parent parent2 = new Parent(student, "", "", 0);
	private int ccaID = 0;
	private C206_CaseStudy object = new C206_CaseStudy();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Parent> parentList = new ArrayList<Parent>();
	private ArrayList<Parent> updatedParentList = new ArrayList<Parent>();
	
	@Before
	public void setUp() throws Exception {
		studentID = "A0000";
		studentName = "John";
		studentGrade = "P6";
		studentClass = "6A";
		studentTeacher = "Mary";
		studentCCA = "Basketball";
		
		studentID1 = "A1000";
		studentName1 = "Johns";
		studentGrade1 = "P5";
		studentClass1 = "5B";
		studentTeacher1 = "Marry";
		studentCCA1 = "Baseball";
		
		student = new Student(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA);
		student2 = new Student(studentID1, studentName1, studentGrade1, studentClass1, studentTeacher1, studentCCA1);
		
		parentName = "Jackson";
		parentName2 = "Jacksons";
		parentEmail = "Jackson@gmail.com";
		parentEmail2 = "Jacksons@gmail.com";
		
		contact = 12345678;
		contact2 = 12345679;
		
		parent = new Parent(student, parentName, parentEmail, contact);
		parent2 = new Parent(student2, parentName2, parentEmail2, contact2);
		ccaID = 12345678;		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddStudent() {
		//test if the student is added into arraylist
		studentList.clear();
		studentList.add(student);
		studentList.add(student2);
		//Check if new students can be detected
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA);
		assertEquals("Check that student arraylist size is 2", 2, studentList.size());
	}
	@Test
	public void testViewStudent() {
		
	}
	@Test
	public void testDeleteStudent() {
		
	}
	@Test
	public void testAddParent() {
		//test if the parent is added into arraylist
		parentList.clear();
		parentList.add(parent);//0
		parentList.add(parent2);//1
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//2
		assertEquals(parentList.get(0).getStudentID(), parentList.get(2).getStudentID());
		assertEquals(parentList.get(0).getStudentName(), parentList.get(2).getStudentName());
		assertEquals(parentList.get(0).getGrade(), parentList.get(2).getGrade());
		assertEquals(parentList.get(0).getClassID(), parentList.get(2).getClassID());
		assertEquals(parentList.get(0).getTeacherName(), parentList.get(2).getTeacherName());
		assertEquals(parentList.get(0).getParentName(), parentList.get(2).getParentName());
		assertEquals(parentList.get(0).getParentEmail(), parentList.get(2).getParentEmail());
		assertEquals(parentList.get(0).getParentContact(), parentList.get(2).getParentContact());
	}
	
	@Test
	public void testViewParent() {
		//test if the output is printed correctly
		parentList.clear();
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);
		String output = object.viewParent(parentList);
		String testOutput = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Parent Name", "Parent Email", "Parent contact");
		testOutput += String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10d\n", parentList.get(0).getStudentObject().getStudentID(), parentList.get(0).getStudentObject().getStudentName(), parentList.get(0).getStudentObject().getGrade(), parentList.get(0).getStudentObject().getClassID(), parentList.get(0).getStudentObject().getTeacherName(), parentList.get(0).getParentName(), parentList.get(0).getParentEmail(), parentList.get(0).getParentContact());
		assertEquals(testOutput, output);
		
	}
	
	@Test
	public void testDeleteParent() {
		//test if the parent is deleted from arraylist
		parentList.clear();//start the test without external factor
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//add in parent
		object.deleteParent(ccaID, student.getStudentID(), updatedParentList, parentList);
		assertEquals(0, parentList.size());//there should have nothing inside
	}
	
	@Test
	public void testDeleteParentFail() {
		//test if the parent is deleted from arraylist
		parentList.clear();//start the test without external factor
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//add in parent
		object.deleteParent(ccaID, student2.getStudentID(), updatedParentList, parentList);
		assertNotEquals(0, parentList.size());//there should have 1 elemnt inside
	}
	
	@Test
	public void testGenerateCCAID() {
		//int testCCAID = C206_CaseStudy.generateCCAID();
		//assertNotEquals(12345678, testCCAID);
	}

	@After
	public void tearDown() throws Exception {
	}
}
