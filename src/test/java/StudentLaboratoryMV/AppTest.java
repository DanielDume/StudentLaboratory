package StudentLaboratoryMV;

import StudentLaboratoryMV.controller.LaboratoriesController;
import StudentLaboratoryMV.model.Laboratory;
import StudentLaboratoryMV.model.Student;
import StudentLaboratoryMV.repository.FileDataPersistence;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileWriter;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    private LaboratoriesController controller;
    private FileDataPersistence repository;

    @Override
    protected void setUp() throws Exception {

        super.setUp();
        repository = new FileDataPersistence("test/students.txt");
        controller  = new LaboratoriesController("test/students.txt", "test/laboratories.txt");

    }

    @Override
    protected void tearDown() throws Exception{

        super.tearDown();
        new FileWriter("test/students.txt").close();
        new FileWriter("test/laboratories.txt").close();

    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
//        AddStudentInvalidRegNumber();
//        AddStudentInvalidName();
//
//        TestAddStudent();
    }

    public void TestAddStudent(){

        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s  = new Student("ddie1901", "gheorghe vasile",111),
                s2 = new Student("asdg1931", "vasile gheorghe",222);
        boolean result1, result2;
        result1 = controller.saveStudent(s);
        assertTrue(result1);
        try{
            assertEquals(1,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
        result2 = controller.saveStudent(s);
        assertTrue(result2);
        try{
            assertEquals(2,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void AddStudentInvalidRegNumber(){

        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("1233asdf","gheorghe vasile", 111);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
        s = new Student("asd123","gheorghe vasile", 111);
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
        s = new Student("asdf123","gheorghe vasile", 111);
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
        s = new Student("asd1234","gheorghe vasile", 111);
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
        s = new Student("","gheorghe vasile", 111);
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void AddStudentInvalidName(){

        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("asdf1234","gheorghe vasile1", 111);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
        s = new Student("asdf1234","gheorghevasile", 111);
        result = controller.saveStudent(s);
        //assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            //assert false;
        }
    }

    public void AddStudentInvalidHighGroupNumber(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("asdf1234","gheorghe vasile", 10000);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
        s = new Student("asdf1234","gheorghe vasile", 100000);
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void AddStudentInvalidLowGroupNumber(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("asdf1234","gheorghe vasile", 10);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
        s = new Student("asdf1234","gheorghe vasile", 0);
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
        s = new Student("asdf1234","gheorghe vasile", -10);
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }


    public void testTC_EC_1(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s  = new Student("ddie1901", "gheorghe vasile",111);
        boolean result1;
        result1 = controller.saveStudent(s);
        assertTrue(result1);
        try{
            assertEquals(1,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_EC_2(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile", 1233);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_EC_3(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile", 12);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_EC_4(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile", 1000);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_EC_5(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile2", 123);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_EC_6(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie@1901","gheorghe vasile", 123);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_EC_7(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghevasile", 123);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_EC_8(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddi1901","gheorghe vasile", 12);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void testTC_EC_9(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddi1901","", 123);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_EC_10(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("","gheorghe vasile", 123);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }



    public void testTC_BVA_11(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile", 101);
        boolean result;
        result = controller.saveStudent(s);
        assertTrue(result);
        try{
            assertEquals(1,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void testTC_BVA_12(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile", 99);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void testTC_BVA_13(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile", 101);
        boolean result;
        result = controller.saveStudent(s);
        assertTrue(result);
        try{
            assertEquals(1,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_BVA_14(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile", 900);
        boolean result;
        result = controller.saveStudent(s);
        assertTrue(result);
        try{
            assertEquals(1,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void testTC_BVA_15(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile", 901);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void testTC_BVA_16(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","gheorghe vasile", 899);
        boolean result;
        result = controller.saveStudent(s);
        assertTrue(result);
        try{
            assertEquals(1,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }
    public void testTC_BVA_17(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","a df", 900);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void testTC_BVA_18(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","asd", 900);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void testTC_BVA_19(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Student s = new Student("ddie1901","asdfg", 900);
        boolean result;
        result = controller.saveStudent(s);
        assertFalse(result);
        try{
            assertEquals(0,repository.getStudentsList().size());
        }
        catch (Exception e){
            assert false;
        }
    }

    public void testTC_DT_20(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
            assert false;
        }
        controller.saveStudent(new Student("ddie1901","gheorghe vasile", 500));
        try{
            controller.saveLaboratory(new Laboratory(1,"10/10/2010", 1, "ddie1901"));
        }
        catch (Exception e){
            assert false;
        }
        try{
            boolean result = controller.addGrade("ddie1901","1",10);
            assertTrue(result);
        }
        catch (Exception e){
            assert false;
        }

    }

    public void testTC_DT_21(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
            assert false;
        }
        try{
            boolean result = controller.addGrade("ddie1901","1",10);
            assertTrue(result);
        }
        catch (Exception e){
            assert true;
        }

    }

    public void testTC_DT_22(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
            assert false;
        }
        controller.saveStudent(new Student("ddie1901","gheorghe vasile", 500));
        try{
            controller.saveLaboratory(new Laboratory(1,"10/10/2010", 1, "ddie1901"));
        }
        catch (Exception e){
            assert false;
        }
        try{
            controller.addGrade("ddie1901","1",10);
            boolean result = controller.addGrade("ddie1901","1",9);
            assertTrue(result);
        }
        catch (Exception e){
            assert false;
        }

    }

    public void testTC_DT_23(){
        try{
            new FileWriter("test/students.txt").close();
            new FileWriter("test/laboratories.txt").close();
        }
        catch (Exception e){
            e.printStackTrace();
            assert false;
        }
        controller.saveStudent(new Student("ddie1901","gheorghe vasile", 500));
        controller.saveStudent(new Student("ddie1902","ghe vasi", 300));
        try{
            controller.saveLaboratory(new Laboratory(1,"10/10/2010", 1, "ddie1901"));
            controller.saveLaboratory(new Laboratory(2,"11/11/2010", 1, "ddie1902"));
        }
        catch (Exception e){
            assert false;
        }
        try{
            controller.addGrade("ddie1901","1",10);
            controller.addGrade("ddie1902","2",8);
            boolean result = controller.addGrade("ddie1901","1",9);
            assertTrue(result);
        }
        catch (Exception e){
            assert false;
        }

    }
}
