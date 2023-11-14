import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class ADDSTUDENT extends JFrame implements ActionListener
{
    JTextField tfname,tffname,tfadress,tfphone,tfemail,tfX,tfXII,tfaadhar;
    //NOW SINCE HERE THE ROLL NUMBER IS UNEDITABLE THEREFORE WE ARE HERE MAKING A LABEL FOR OUR ROLL NUMBER

    JLabel labelrollno;
    //HERE NOW WE ARE GENERATING THE RANDOM ROLL NUMBER
    //THE RANDOM NUMBER GENERATED IS IN LONG
    //WE NEED FOR 4 DIGITS THEREFORE WE MODULUS BY 9000L AND IT WILL STILL GIVE THE VALUES BETWEEN 0 AND 1 THEREFORE WE ADDED 1000 TO IT
    //SINCE IT COULD HAVE BEEN NEGATIVE THEREFORE WE USED MATH.ABSOLUTE
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000L)+1000L);
    //WE ARE MAKING AND OBJECT OF THE JDATECHOOSER CLASS FOR OUR CALENDER
    JDateChooser dcdob;
    //WE ARE NOW CREATING THE OBJECT FOR THE COMBOBOX CLASS FOR THE MAKING OF THE DROPDOWN
    JComboBox cbcourse,cbbranch;
    //NOW WE ARE FINALLY MAKING THE BUTTONS FOR THE SUBMIT AND THE CANCEL OF THE STUDENT DETAILS
    JButton submit,cancel;
    ADDSTUDENT()
    {
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        //PUT THE HEADING USING JLABEL
        JLabel heading=new JLabel("NEW STUDENT DETAILS");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        //PUT THE NAME LABEL
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        //CREATING THE NAME TEXTFIELD
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        //PUT THE FATHER NAME LABEL
        JLabel lblfname=new JLabel("FATHER'S NAME");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        //CREATING THE FATHER NAME TEXTFIELD
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);


        //PUT THE ROLL NUMBER LABEL
        JLabel lblrollno=new JLabel("ROLL NUMBER");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        //WE WANT THE ROLL NUMBER TO BE AUTO GENERATED THEREFORE WE WILL HERE USE THE RANDOM CLASS
        //ABOVE WE HAVE GENERATED OUR ROLL NUMBER NOW WE ARE MAKING ANOTHER LABEL TO DISPLAY OUR ROLL NUMBER AND WE ARE MAKING A LABEL SINCE WE DONOT HAVE TO EDIT OUR ROLL NUMBER
        //HERE THE 2003 IS A FIXED NUMBER AND THE LAST FOUR DIGITS WILL BE KEEP ON CHANGING
        labelrollno=new JLabel("2003"+first4);
        labelrollno.setBounds(220,200,200,30);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);
        //NOW WE ARE MAKING OUR DATE OF BIRTH
        //NOW FOR OUR DATE OF BIRTH WE WILL BE APPLYING A CALENDER
        //NOW TO APPLY CALENDER WE NEED COM.TOACTOR WHICH IS IN A JAR FILE

        JLabel lbldo=new JLabel("DATE OF BIRTH : ");
        lbldo.setBounds(400,200,200,30);
        lbldo.setFont(new Font("serif",Font.BOLD,20));
        add(lbldo);
        //FOR CALENDER
        dcdob=new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        //NOW WE ADD PHONE NUMBER LABEL
        JLabel lblphone=new JLabel("PHONE");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        //CREATING THE PHONE NUMBER TEXTFIELD
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        //NOW WE ADD ADDRESS LABEL
        JLabel lbladress=new JLabel("ADDRESS");
        lbladress.setBounds(50,250,200,30);
        lbladress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladress);
        //CREATING THE ADRESS TEXTFIELD
        tfadress = new JTextField();
        tfadress.setBounds(200,250,150,30);
        add(tfadress);






        //NOW WE ADD EMAIL ADDRESS LABEL
        JLabel lblemail=new JLabel("EMAIL ID");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        //CREATING THE EMAIL ADRESS TEXTFIELD
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);


        //NOW WE ADD 10th PERCENTAGE LABEL
        JLabel lblX=new JLabel("Xth %");
        lblX.setBounds(400,300,200,30);
        lblX.setFont(new Font("serif",Font.BOLD,20));
        add(lblX);
        //CREATING THE 10th PERCENTAGE TEXTFIELD
        tfX = new JTextField();
        tfX.setBounds(600,300,150,30);
        add(tfX);


        //NOW WE ADD 12th PERCENTAGE LABEL
        JLabel lblXII=new JLabel("XIIth %");
        lblXII.setBounds(50,350,200,30);
        lblXII.setFont(new Font("serif",Font.BOLD,20));
        add(lblXII);
        //CREATING THE ADRESS TEXTFIELD
        tfXII = new JTextField();
        tfXII.setBounds(200,350,150,30);
        add(tfXII);

        //NOW WE ADD AADHAR NUMBER LABEL
        JLabel lblaadhar=new JLabel("AADHAR NUMBER");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        //CREATING THE AADHAR NUMBER TEXTFIELD
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);

        //NOW WE ADD COURSE LABEL
        JLabel lblcourse=new JLabel("COURSE");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        //NOW WE WILL CREATE A DROPDOWN FOR THE COURSE
        //WE ARE ALSO ADDING SOME OF THE VALUES IN THE DROPDOWN
        String course[]={"B.Tech","BBA","BCA","Bsc","Msc","MCA","MCom","MA","BA"};

        cbcourse=new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        //NOW WE ADD COURSE BRANCH LABEL
        JLabel lblbranch=new JLabel("BRANCH");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        //NOW WE WILL CREATE A DROPDOWN FOR THE COURSE BRANCH
        //WE ARE ALSO ADDING SOME OF THE VALUES IN THE DROPDOWN
        String branch[]={"COMPUTER SCIENCE","ELECTRONICS","MECHANICAL","CIVIL","IT"};

        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        //MAKING THE BUTTON OF THE SUBMIT
        submit=new JButton("SUBMIT");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,16));
        add(submit);
        //MAKING THE BUTTON OF THE CANCEL
        cancel=new JButton("CANCEL");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(cancel);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            //NOW IF WE HAVE PRESSED THE SUBMIT BUTTON THEN WE HAVE TO TAKE OUT ALL THE VALUES OF THE STUDENT WHICH HE HAS ENTERED
            String name=tfname.getText();
            String fname=tffname.getText();
            String rollno=labelrollno.getText();
            //NOW YOU HAVE TO FETCH THE DATE OF BIRTH FROM THE CALENDER THEREFORE WE USE GETDATEEDITOR AND TO GET THE ACCESS OF THE UI COMPONENT WE USE THE GETUICOMPONENT
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address=tfadress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String x=tfX.getText();
            String xii=tfXII.getText();
            String aadhar=tfaadhar.getText();
            //NOW WE HAVE TO FETCH THE DETAILS OF THE COURSE AND THE BRANCH
            String course=(String) cbcourse.getSelectedItem();//SINCE THE GETSELECTEDITEM RETURNS THE OBJECT THEREFORE WE ARE TYPECASTING IT INTO A STRING
            String branch=(String) cbbranch.getSelectedItem();
            //NOW WE WILL CREATE A TABLE IN THE MYSQL TO GET THESE ENTRIES IN IT
            //WE HAVE NOW CREATED THE TABLE IN THE MYSQL AND NOW WE ARE INSERTING THE DATA IN THE MYSQL TABLE
            try
            {
                String query="insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
                CONNECTION c = new CONNECTION();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Details inserted Successfully");
                setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();

            }



        }
        else if (ae.getSource()==cancel)
        {
           setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new ADDSTUDENT();
    }
}
