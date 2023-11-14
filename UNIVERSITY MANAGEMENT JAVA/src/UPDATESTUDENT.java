import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class UPDATESTUDENT extends JFrame implements ActionListener
{
    JTextField tfcourse,tffname,tfadress,tfphone,tfemail,tfbranch;
    //NOW SINCE HERE THE ROLL NUMBER IS UNEDITABLE THEREFORE WE ARE HERE MAKING A LABEL FOR OUR ROLL NUMBER

    JLabel labelrollno;
    //HERE NOW WE ARE GENERATING THE RANDOM ROLL NUMBER
    //THE RANDOM NUMBER GENERATED IS IN LONG
    //WE NEED FOR 4 DIGITS THEREFORE WE MODULUS BY 9000L AND IT WILL STILL GIVE THE VALUES BETWEEN 0 AND 1 THEREFORE WE ADDED 1000 TO IT
    //SINCE IT COULD HAVE BEEN NEGATIVE THEREFORE WE USED MATH.ABSOLUTE

    //WE ARE MAKING AND OBJECT OF THE JDATECHOOSER CLASS FOR OUR CALENDER

    //WE ARE NOW CREATING THE OBJECT FOR THE COMBOBOX CLASS FOR THE MAKING OF THE DROPDOWN

    //NOW WE ARE FINALLY MAKING THE BUTTONS FOR THE SUBMIT AND THE CANCEL OF THE STUDENT DETAILS
    JButton update,cancel;
    Choice crollno;
    UPDATESTUDENT()
    {
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        //PUT THE HEADING USING JLABEL
        JLabel heading=new JLabel("UPDATE STUDENT DETAILS");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblrollno=new JLabel("SELECT ROLL NUMBER");
        lblrollno.setBounds(50,100,200,20);
        heading.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollno);
        //DROP DOWN ADDED FOR THE SEARCH BY ROLL NUMBER
        crollno=new Choice();
        crollno.setBounds(250,100,220,20);
        add(crollno);

        //NOW WE ARE HITTING THE QUERY ON THE MYSQL TO FETCH A PARTICULAR DATA
        try
        {
            CONNECTION c=new CONNECTION();//WE CREATED THE OBJECT OF THE CONNECTION CLASS THAT IS THE CLASS WHICH IS CONNECTING US TO THE MYSQL
            ResultSet rs=c.s.executeQuery(("select * from student"));
            while(rs.next())
            {
                crollno.add(rs.getString("rollno"));//HERE WE GAVE THE NAME OF THE COLLUMN UNDER WHICH THE DATA IE THE ROLL NUMBER IS SAVED

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        //PUT THE NAME LABEL
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        //CREATING THE NAME TEXTFIELD
        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);

        //PUT THE FATHER NAME LABEL
        JLabel lblfname=new JLabel("FATHER'S NAME");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        //CREATING THE FATHER NAME TEXTFIELD
         JLabel labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname);


        //PUT THE ROLL NUMBER LABEL
         lblrollno=new JLabel("ROLL NUMBER");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        //WE WANT THE ROLL NUMBER TO BE AUTO GENERATED THEREFORE WE WILL HERE USE THE RANDOM CLASS
        //ABOVE WE HAVE GENERATED OUR ROLL NUMBER NOW WE ARE MAKING ANOTHER LABEL TO DISPLAY OUR ROLL NUMBER AND WE ARE MAKING A LABEL SINCE WE DONOT HAVE TO EDIT OUR ROLL NUMBER
        //HERE THE 2003 IS A FIXED NUMBER AND THE LAST FOUR DIGITS WILL BE KEEP ON CHANGING
        labelrollno=new JLabel();
        labelrollno.setBounds(220,200,200,30);
        labelrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelrollno);
        //NOW WE ARE MAKING OUR DATE OF BIRTH
        //NOW FOR OUR DATE OF BIRTH WE WILL BE APPLYING A CALENDER
        //NOW TO APPLY CALENDER WE NEED COM.TOACTOR WHICH IS IN A JAR FILE

        JLabel lbldob=new JLabel("DATE OF BIRTH : ");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        //FOR CALENDER
        JLabel labeldob=new JLabel();
        labeldob.setBounds(600,200,150,30);
        labeldob.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeldob);
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
        JLabel labelX = new JLabel();
        labelX.setBounds(600,300,150,30);
        labelX.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelX);


        //NOW WE ADD 12th PERCENTAGE LABEL
        JLabel lblXII=new JLabel("XIIth %");
        lblXII.setBounds(50,350,200,30);
        lblXII.setFont(new Font("serif",Font.BOLD,20));
        add(lblXII);
        //CREATING THE ADRESS TEXTFIELD
        JLabel labelXII = new JLabel();
        labelXII.setBounds(200,350,150,30);
        labelXII.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelXII);

        //NOW WE ADD AADHAR NUMBER LABEL
        JLabel lblaadhar=new JLabel("AADHAR NUMBER");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        //CREATING THE AADHAR NUMBER TEXTFIELD
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelaadhar);

        //NOW WE ADD COURSE LABEL
        JLabel lblcourse=new JLabel("COURSE");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        //NOW WE WILL CREATE A DROPDOWN FOR THE COURSE
        //WE ARE ALSO ADDING SOME OF THE VALUES IN THE DROPDOWN

        tfcourse=new JTextField();
        tfcourse.setBounds(200,400,150,30);
        tfcourse.setBackground(Color.WHITE);
        add(tfcourse);

        //NOW WE ADD COURSE BRANCH LABEL
        JLabel lblbranch=new JLabel("BRANCH");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        //NOW WE WILL CREATE A DROPDOWN FOR THE COURSE BRANCH
        //WE ARE ALSO ADDING SOME OF THE VALUES IN THE DROPDOWN

        tfbranch=new JTextField();
        tfbranch.setBounds(600,400,150,30);
        tfbranch.setBackground(Color.WHITE);
        add(tfbranch);

        //WE HAVE TO DYNAMICALLY INSERT THE VALUES THEREFORE WE NEED A HIT IN THE DATABASE
        try
        {
            CONNECTION c=new CONNECTION();
            String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfadress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelX.setText(rs.getString("class_x"));
                labelXII.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                try
                {
                    CONNECTION c=new CONNECTION();
                    String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next())
                    {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfadress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelX.setText(rs.getString("class_x"));
                        labelXII.setText(rs.getString("class_xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                }
                catch (Exception ee)
                {
                    ee.printStackTrace();
                }
            }
        });




        //MAKING THE BUTTON OF THE SUBMIT
        update=new JButton("UPDATE");
        update.setBounds(250,550,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("serif",Font.BOLD,16));
        add(update);
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
        if(ae.getSource()==update)
        {
            //NOW IF WE HAVE PRESSED THE SUBMIT BUTTON THEN WE HAVE TO TAKE OUT ALL THE VALUES OF THE STUDENT WHICH HE HAS ENTERED


            String rollno=labelrollno.getText();
            //NOW YOU HAVE TO FETCH THE DATE OF BIRTH FROM THE CALENDER THEREFORE WE USE GETDATEEDITOR AND TO GET THE ACCESS OF THE UI COMPONENT WE USE THE GETUICOMPONENT
            String address=tfadress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();

            //NOW WE HAVE TO FETCH THE DETAILS OF THE COURSE AND THE BRANCH
            String course=tfcourse.getText();//SINCE THE GETSELECTEDITEM RETURNS THE OBJECT THEREFORE WE ARE TYPECASTING IT INTO A STRING
            String branch=tfbranch.getText();
            //NOW WE WILL CREATE A TABLE IN THE MYSQL TO GET THESE ENTRIES IN IT
            //WE HAVE NOW CREATED THE TABLE IN THE MYSQL AND NOW WE ARE INSERTING THE DATA IN THE MYSQL TABLE
            try
            {
                String query="update student set address ='"+address+"',phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"' where rollno='"+rollno+"'";
                CONNECTION c = new CONNECTION();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Details updated Successfully");
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
        new UPDATESTUDENT();
    }
}
