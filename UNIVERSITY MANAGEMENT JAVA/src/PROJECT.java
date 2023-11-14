import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PROJECT extends JFrame implements ActionListener
{
    PROJECT()
    {
        setSize(1540,850);
        //WE ARE PUTTING AN IMAGE HERE
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("UNIIM2.jpg"));//HERE WE HAVE BROUGHT OUT IMAGE TO THE PROGRAM
        Image i2=i1.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);//WE HAVE DONE THE THE SCALING OF THE IMAGE FOR THE FRAME
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        //image.setBounds(350,20,200,200);//WE DONOT DO SETBOUNDS IF WE HAVE NOT DONE THE LAYOUT NULL
        add(image);//ADDED THE IMAGE INTO THE FRAME
        //NOW WE ARE ADDING THE MENU BAR ABOVE THE IMAGE IN THE FRAME WITH SUB PARTS ALSO
        JMenuBar mb=new JMenuBar();//MENU BAR IS CREATED

        //NEW INFORMATION
        JMenu newInformation= new JMenu("NEW INFORMATION");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
            //SUB PART FACULTY INFORMATION IS ADDED HERE
            JMenuItem facultyInfo=new JMenuItem("NEW FACULTY INFORMATION");
            facultyInfo.setBackground(Color.WHITE);
            facultyInfo.addActionListener(this);
            newInformation.add(facultyInfo);
            //SUB PART STUDENT INFORMATION IS ADDED HERE
            JMenuItem studentInfo=new JMenuItem("NEW STUDENT INFORMATION");
            studentInfo.setBackground(Color.WHITE);
            studentInfo.addActionListener(this);
            newInformation.add(studentInfo);

        //DETAILS
        JMenu details= new JMenu("DETAILS");
        details.setForeground(Color.RED);
        mb.add(details);
            //SUB PART FACULTY DETAILS IS ADDED HERE
            JMenuItem facultydetails=new JMenuItem("VIEW FACULTY DETAILS");
            facultydetails.setBackground(Color.WHITE);
            facultydetails.addActionListener(this);
            details.add(facultydetails);
            //SUB PART STUDENT DETAILS IS ADDED HERE
            JMenuItem studentdetails=new JMenuItem("VIEW STUDENT DETAILS");
            studentdetails.setBackground(Color.WHITE);
            studentdetails.addActionListener(this);
            details.add(studentdetails);

        //LEAVE APPLICATION
        JMenu leave= new JMenu("APPLY LEAVE");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
            //SUB PART FACULTY LEAVE APPLICATION IS ADDED HERE
            JMenuItem facultyleave=new JMenuItem("VIEW FACULTY LEAVE");
            facultyleave.setBackground(Color.WHITE);
            facultyleave.addActionListener(this);
            leave.add(facultyleave);
            //SUB PART STUDENT LEAVE APPLICATION IS ADDED HERE
            JMenuItem studentleave=new JMenuItem("VIEW STUDENT LEAVE");
            studentleave.setBackground(Color.WHITE);
            studentleave.addActionListener(this);
            leave.add(studentleave);


        //LEAVE DETAILS
        JMenu leaveDetails= new JMenu("LEAVE DETAILS");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
            //SUB PART FACULTY LEAVE DETAILS IS ADDED HERE
            JMenuItem facultyleaveDetails=new JMenuItem("VIEW FACULTY LEAVE DETAILS");
            facultyleaveDetails.setBackground(Color.WHITE);
            facultyleaveDetails.addActionListener(this);
            leaveDetails.add(facultyleaveDetails);
            //SUB PART STUDENT LEAVE DETAILS IS ADDED HERE
            JMenuItem studentleaveDetails=new JMenuItem("VIEW STUDENT LEAVE DETAILS");
            studentleaveDetails.setBackground(Color.WHITE);
            studentleaveDetails.addActionListener(this);
            leaveDetails.add(studentleaveDetails);

        //EXAM DETAILS
        JMenu exam= new JMenu("EXAMINATION");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
            //SUB PART EXAMINATION DETAILS IS ADDED HERE
            JMenuItem examinationdetails=new JMenuItem("EXAMINATION RESULTS");
            examinationdetails.setBackground(Color.WHITE);
            examinationdetails.addActionListener(this);
            exam.add(examinationdetails);
            //SUB PART ENTER MARKS IS ADDED HERE
            JMenuItem entermarks=new JMenuItem("ENTER MARKS");
            entermarks.setBackground(Color.WHITE);
            entermarks.addActionListener(this);
            exam.add(entermarks);

        //UPDATE DETAILS
        JMenu updateinfo= new JMenu("UPDATE DETAILS");
        updateinfo.setForeground(Color.RED);
        mb.add(updateinfo);
            //SUB PART FACULTY DETAILS UPDATE IS ADDED HERE
            JMenuItem updatefacultyinfo=new JMenuItem("FACULTY DETAILS UPDATE");
            updatefacultyinfo.setBackground(Color.WHITE);
            updatefacultyinfo.addActionListener(this);
            updateinfo.add(updatefacultyinfo);
            //SUB PART STUDENT DETAILS UPDATE IS ADDED HERE
            JMenuItem updatestudentinfo=new JMenuItem("STUDENT DETAILS UPDATE");
            updatestudentinfo.setBackground(Color.WHITE);
            updatestudentinfo.addActionListener(this);
            updateinfo.add(updatestudentinfo);

        //FEE DETAILS
        JMenu fee= new JMenu("FEE DETAILS");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
            //SUB PART FEESTRUCTURE IS ADDED HERE
            JMenuItem feestructure=new JMenuItem("FEE STRUCTURE");
            feestructure.setBackground(Color.WHITE);
            feestructure.addActionListener(this);
            fee.add(feestructure);
            //SUB PART STUDENT FEE FORM IS ADDED HERE
            JMenuItem feeform=new JMenuItem("STUDENT FEE FORM");
            feeform.setBackground(Color.WHITE);
            feeform.addActionListener(this);
            fee.add(feeform);

        //UTILITY
        JMenu utility= new JMenu("UTILITY");
        utility.setForeground(Color.RED);
        mb.add(utility);
            //SUB PART NOTEPAD IS ADDED HERE
            JMenuItem notepad=new JMenuItem("NOTEPAD");
            notepad.setBackground(Color.WHITE);
            notepad.addActionListener(this);//ACTION LISTENER APPLIED TO OPEN THE NOTEPAD
            utility.add(notepad);
            //SUB PART CALCULATOR IS ADDED HERE
            JMenuItem calc=new JMenuItem("CALCULATOR");
            calc.setBackground(Color.WHITE);
            calc.addActionListener(this);//ACTION LISTENER APPLIED TO OPEN THE CALCULATOR
            utility.add(calc);

        //WE WILL TELL ABOUT THE PROJECT IN THIS ABOUT
        JMenu about= new JMenu("ABOUT");
        about.setForeground(Color.BLUE);
        mb.add(about);
        //SUB PART NOTEPAD IS ADDED HERE
        JMenuItem ab=new JMenuItem("ABOUT");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);


        //EXIT //TO EXIT THE PROJECT
        JMenu exit= new JMenu("EXIT");
        exit.setForeground(Color.BLUE);
        mb.add(exit);
            //SUB PART NOTEPAD IS ADDED HERE
            JMenuItem ex=new JMenuItem("EXIT");
            ex.setBackground(Color.WHITE);
            ex.addActionListener(this);
            exit.add(ex);


        setJMenuBar(mb);


        setVisible(true);
    }
    //NOW WE HAVE TO OVERRIDE THE ABSTRACT METHOD IN THE CLASS ACTION LISTENER
    //HERE WE ALSO HAVE TO DIFFERENTIATE THAT WHICH ONE HAS CALLED THE ACTIONPERFORMED WHETHER IT IS EXIT OR CALCULATOR OR NOTEPAD

    public void actionPerformed(ActionEvent ae)
    {
        //WE CAN USE THE GET SOURCE BUT WE ARE USING THE ACTIONCOMMAND SINCE WE DONOT HAVE BUTTONS HERE
        //WITH THE HELP OF ACTIONCOMMAND WE CAN CHECK THAT WHICH ONE HAS CALLED THIS FUNCTION

        String msg= ae.getActionCommand();
        //WE ARE HANDILING THE EXIT OPTION TO CLOSE OUR PROJECT
        if(msg.equals("EXIT"))
            setVisible(false);
        //WE ARE HANDLING THE CALCULATOR OPTION IN THE UTILITY
        else if(msg.equals("CALCULATOR"))
        {
            try
            {
                //ANY FILE IN THE COMPUTER SYSTEM WHICH HAS THE EXTENTION EXE CAN BE RUN WITH THE HELP OF EXEC FUNCTION
                Runtime.getRuntime().exec("Calc.exe");
            }
            catch (Exception e)
            {

            }
        }
        //WE ARE HADLING THE NOTEPAD OPTION
        else if(msg.equals("NOTEPAD"))
        {
            try
            {
                //ANY FILE IN THE COMPUTER SYSTEM WHICH HAS THE EXTENTION EXE CAN BE RUN WITH THE HELP OF EXEC FUNCTION
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception e)
            {

            }
        }
        else if(msg.equals("NEW FACULTY INFORMATION"))
        {
            new ADDTEACHER();
        }
        else if(msg.equals("NEW STUDENT INFORMATION"))
        {
            new ADDSTUDENT();
        }
        else if(msg.equals("VIEW FACULTY DETAILS"))
        {
            new TEACHERDETAILS();
        }
        else if(msg.equals("VIEW STUDENT DETAILS"))
        {
            new STUDENTDETAILS();
        }
        else if(msg.equals("VIEW FACULTY LEAVE"))
        {
            new TEACHERLEAVE();
        }
        else if(msg.equals("VIEW STUDENT LEAVE"))
        {
            new STUDENTLEAVE();
        }
        else if(msg.equals("VIEW FACULTY LEAVE DETAILS"))
        {
            new TEACHERLEAVEDETAILS();
        }
        else if(msg.equals("VIEW STUDENT LEAVE DETAILS"))
        {
            new STUDENTLEAVEDETAILS();
        }
        else if(msg.equals("STUDENT DETAILS UPDATE"))
        {
            new UPDATESTUDENT();
        }
        else if(msg.equals("FACULTY DETAILS UPDATE"))
        {
            new UPDATETEACHER();
        }
        else if(msg.equals("ENTER MARKS"))
        {
            new ENTERMARKS();
        }
        else if(msg.equals("EXAMINATION RESULTS"))
        {
            new EXAMINATIONDETAILS();
        }
        else if(msg.equals("FEE STRUCTURE"))
        {
            new FEESTRUCTURE();
        }
        else if(msg.equals("STUDENT FEE FORM"))
        {
            new STUDENTFEEFORM();
        }
        else if(msg.equals("ABOUT"))
        {
            new ABOUT();
        }

    }
    public static void main(String args[])
    {
        new PROJECT();
    }
}

