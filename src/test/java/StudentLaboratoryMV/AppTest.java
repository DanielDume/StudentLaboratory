package StudentLaboratoryMV;

import StudentLaboratoryMV.controller.LaboratoriesController;
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
        testTC_EC_1();TC_EC_2();TC_EC_3();TC_EC_4();TC_EC_5();TC_EC_6();TC_EC_7();TC_EC_8();TC_EC_9();TC_EC_10();
        TC_BVA_11();TC_BVA_12();TC_BVA_13();TC_BVA_14();TC_BVA_15();TC_BVA_16();TC_BVA_17();TC_BVA_18();TC_BVA_19();
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
    public void TC_EC_2(){
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
    public void TC_EC_3(){
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
    public void TC_EC_4(){
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
    public void TC_EC_5(){
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
    public void TC_EC_6(){
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
    public void TC_EC_7(){
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
    public void TC_EC_8(){
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

    public void TC_EC_9(){
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
    public void TC_EC_10(){
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



    public void TC_BVA_11(){
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

    public void TC_BVA_12(){
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

    public void TC_BVA_13(){
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
    public void TC_BVA_14(){
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

    public void TC_BVA_15(){
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

    public void TC_BVA_16(){
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
    public void TC_BVA_17(){
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

    public void TC_BVA_18(){
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

    public void TC_BVA_19(){
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


}
