// NOW WE HAVE MADE A CLASS CONNECTION WHICH WILL HELP US TO CONNECT THE JAVA WITH THE MYSQL DATABASE
//BASICALLY AFTER THE LOGIN PAGE WE NEED TO ENTER THE LOGIN DETAILS AND THEN CHECK WHETHER THOSE DETAILS ARE AVAILABLE IN THE DATABASE OR NOT
//THEN IF THEY ARE AVAILABLE IN THE DATA BASE THEN WE WILL GO TO THE PROJECT FRAME THAT IS THE MAIN UNIVERSITY FRAME AND THEN WE CAN PROCEED
//IF THE LOGIN CREDENTIALS ARE NOT PRESENT IN THE DATABASE THEN WE WILL HAVE TO CLOSE THE LOGIN PAGE


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//NOW WE ARE DOING THE JAVA DATABASE CONNECTIVITY
/*
* JAVA DATABASE CONNECTIVITY IS DONE IN 5 STEPS
1 - REGISTER THE DRIVER CLASS
2 - CREATING CONNECTION STRING
3 - CREATING STATEMENT
4 - EXECUTING MYSQL QUERIES
5 - CLOSING THE CONNECTION
* */
 /*
 Procedure: HOW TO ADD THE JAR FILE
Open your installed IntelliJ IDEA Project and.
Go to the File > Project Structure.
Select Modules at the left panel and select the Dependencies tab.
Select the + icon and select 1 JARs or Directories option.
select your JAR file or you can select the directories.
Click on the OK button.
 * */
public class CONNECTION
{
    Connection c;//WE CREATED A REFERENCE VARIABLE OF THE INTERFACE
    Statement s;//WE CREATED THE REFERENCE VARIABLE OF THE INTERFACE FOR THE THIRD STEP OF CONNECTING DATABASE
    CONNECTION()
    {
        try
        {
            //1-FIRST STEP OF REGISTERING THE DRIVER CLASS
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2-SECOND STEP CREATING THE CONNECTION STRING
            //WE ARE ENTERING OUR MYSQL DATABASE DETAILS
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","S@tMsq21");
            //3-THIRD STEP CREATING THE STATEMENT
            s=c.createStatement();
        }
        catch (Exception e)
        {
            //HERE WE HAVE PRINTED THE EXCEPTION WHICH CAME
            e.printStackTrace();
        }
    }
}
