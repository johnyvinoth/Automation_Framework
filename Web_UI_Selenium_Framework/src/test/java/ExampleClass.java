import org.hamcrest.core.IsInstanceOf;
import org.testng.annotations.*;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleClass {
    //TODO: This is a sample class to understand the @BeforeMethod and @BeforeTest. This can be removed later.

    @BeforeMethod(groups ="setup")
    public void setUp_BeforeMethod() {
        // Setup activities specific to each test method
        System.out.println("BeforeMethod: Setup activities");
    }

    @BeforeTest(groups ="setup")
    public void setUp_BeforeTest() {
        // Setup activities specific to each test method
        System.out.println("BeforeTest: Setup activities");
    }

    @Test(groups = {"Test", "Test1"})
    public void testMethod1() {
        // Test method 1
        System.out.println("Test Method 1");

        List<Integer> lst=new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);

        List<Integer> lst1 = Arrays.asList(1,2,3,4,5);
        lst.add(6);

        Class<?> objlst=lst.getClass();
        Class<?> objlst1=lst1.getClass();

        System.out.println("The type of lst is: "+objlst.getName()+ " and the value in it is: "+lst);
        System.out.println("The type of lst1 is: "+objlst1.getName()+ " and the value in it is: "+lst1);

        int[][] num1={{1,2,3},{2,3,4},{2,3,4}};
        System.out.println(Arrays.deepToString(num1));
        int len=num1.length;
        int len_inner=num1[0].length;

        for (int i=0;i<len;i++)
        {
            for(int j=0;j<len_inner;j++)
            {

            System.out.println(num1[i][j]);
            }
        }

    }

    @Test(groups = {"Test", "Test2"})
    public void testMethod2() {
        // Test method 2
        System.out.println("Test Method 2");
    }

    @AfterTest(groups ="setup")
    public void teardown_AfterTest() {
        // Setup activities specific to each test method
        System.out.println("AfterTest: Setup activities");
    }

    @AfterMethod(groups ="setup")
    public void teardown_AfterMethod() {
        System.out.println("After Method: Tear down activites");
    }
}