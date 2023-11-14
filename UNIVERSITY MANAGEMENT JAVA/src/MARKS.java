import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MARKS extends JFrame implements ActionListener
{
    String rollno;
    JButton back;
    MARKS(String rollno)
    {
        //ENTER MARKS SE JO HAMNE ROLL NUMBER KO SEND KIYA HAI VO PAKADNE KE LIYE PARAMETERIZED CONSTRUCTOR BANAYA HAI

        this.rollno=rollno;

        setSize(700,600);
        setLocation(500,100);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("SRM INSTITUTE OF SCIENCE AND TECHNOLOGY");
        heading.setBounds(120,10,500,25);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel subheading=new JLabel("RESULT OF EXAMINATION");
        subheading.setBounds(225,50,500,20);
        subheading.setFont(new Font("serif",Font.BOLD,18));
        add(subheading);

        JLabel lblrollno=new JLabel("ROLL NUMBER : "+rollno);
        lblrollno.setBounds(80,130,500,20);
        lblrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollno);

        JLabel lblsemester=new JLabel();
        lblsemester.setBounds(100,175,500,20);
        lblsemester.setFont(new Font("serif",Font.PLAIN,18));
        add(lblsemester);

        //DISPLAYING THE RESULTS OF THE SUBJECTS
        JLabel sub1=new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("serif",Font.PLAIN,18));
        add(sub1);

        JLabel sub2=new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("serif",Font.PLAIN,18));
        add(sub2);

        JLabel sub3=new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("serif",Font.PLAIN,18));
        add(sub3);

        JLabel sub4=new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("serif",Font.PLAIN,18));
        add(sub4);

        JLabel sub5=new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("serif",Font.PLAIN,18));
        add(sub5);

        try
        {
            CONNECTION c=new CONNECTION();



            ResultSet rs=c.s.executeQuery("select * from subject where rollno = '"+rollno+"'");
            while(rs.next())
            {
                sub1.setText(rs.getString("subject1"));
                sub2.setText(rs.getString("subject2"));
                sub3.setText(rs.getString("subject3"));
                sub4.setText(rs.getString("subject4"));
                sub5.setText(rs.getString("subject5"));

            }
            ResultSet rs1=c.s.executeQuery("select * from marks where rollno = '"+rollno+"'");
            while(rs1.next())
            {
                sub1.setText(sub1.getText()+"-------------------"+rs1.getString("marks1"));
                sub2.setText(sub2.getText()+"-------------------"+rs1.getString("marks2"));
                sub3.setText(sub3.getText()+"-------------------"+rs1.getString("marks3"));
                sub4.setText(sub4.getText()+"-------------------"+rs1.getString("marks4"));
                sub5.setText(sub5.getText()+"-------------------"+rs1.getString("marks5"));
                lblsemester.setText("Semester "+rs1.getString("semester"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        back=new JButton("BACK");
        back.setBounds(275,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {

            setVisible(false);

    }
    public static void main(String[] args)
    {
        new MARKS("");
    }
}