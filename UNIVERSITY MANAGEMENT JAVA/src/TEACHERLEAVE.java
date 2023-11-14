import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TEACHERLEAVE extends JFrame implements ActionListener
{
    Choice cempid,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    TEACHERLEAVE()
    {
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("APPLY TEACHER LEAVE");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel lblempid=new JLabel("SEARCH BY EMPID");
        lblempid.setBounds(40,100,280,20);
        lblempid.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblempid);
        //DROP DOWN ADDED FOR THE SEARCH BY ROLL NUMBER
        cempid=new Choice();
        cempid.setBounds(40,130,150,20);
        add(cempid);

        //NOW WE ARE HITTING THE QUERY ON THE MYSQL TO FETCH A PARTICULAR DATA
        try
        {
            CONNECTION c=new CONNECTION();//WE CREATED THE OBJECT OF THE CONNECTION CLASS THAT IS THE CLASS WHICH IS CONNECTING US TO THE MYSQL
            ResultSet rs=c.s.executeQuery(("select * from teacher"));
            while(rs.next())
            {
                cempid.add(rs.getString("empid"));//HERE WE GAVE THE NAME OF THE COLLUMN UNDER WHICH THE DATA IE THE ROLL NUMBER IS SAVED

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        JLabel lbldate=new JLabel("DATE");
        lbldate.setBounds(40,170,280,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);

        dcdate=new JDateChooser();
        dcdate.setBounds(40,200,150,30);
        add(dcdate);

        JLabel lbltime=new JLabel("TIME DURATION");
        lbltime.setBounds(40,250,280,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);
        //DROP DOWN ADDED FOR THE SEARCH BY ROLL NUMBER
        ctime=new Choice();
        ctime.setBounds(40,280,150,20);
        ctime.add("FULL DAY");
        ctime.add("HALF DAY");
        add(ctime);

        //MAKING THE BUTTON OF THE SUBMIT
        submit=new JButton("SUBMIT");
        submit.setBounds(100,400,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,16));
        add(submit);
        //MAKING THE BUTTON OF THE CANCEL
        cancel=new JButton("CANCEL");
        cancel.setBounds(250,400,120,30);
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
            String rollno=cempid.getSelectedItem();
            String date=((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();

            String query="insert into teacherleave values('"+rollno+"','"+date+"','"+duration+"')";
            try
            {
                CONNECTION c=new CONNECTION();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"LEAVE CONFIRMED");
                setVisible(false);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new TEACHERLEAVE();
    }
}
