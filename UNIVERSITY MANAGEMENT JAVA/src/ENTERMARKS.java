import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ENTERMARKS extends JFrame implements ActionListener
{
    Choice crollno;
    JComboBox cbsemester;

    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit, cancel;
    ENTERMARKS()
    {
        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("UNIIM2.jpg"));//HERE WE HAVE BROUGHT OUT IMAGE TO THE PROGRAM
        Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);//WE HAVE DONE THE THE SCALING OF THE IMAGE FOR THE FRAME
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);

        JLabel heading=new JLabel("ENTER MARKS OF STUDENT");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblrollno=new JLabel("SELECT ROLL NUMBER");
        lblrollno.setBounds(50,70,200,20);
        lblrollno.setFont(new Font("serif",Font.BOLD,15));
        add(lblrollno);
        //DROP DOWN ADDED FOR THE SEARCH BY ROLL NUMBER
        crollno=new Choice();
        crollno.setBounds(250,70,150,20);
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

        JLabel lblsemester=new JLabel("SELECT SEMESTER");
        lblsemester.setBounds(50,110,180,20);
        lblsemester.setFont(new Font("serif",Font.BOLD,15));
        add(lblsemester);

        String semester[]={"1st SEMESTER","2nd SEMESTER","3rd SEMESTER","4th SEMESTER","5th SEMESTER","6th SEMESTER","7th SEMESTER","8th SEMESTER"};
        cbsemester=new JComboBox(semester);
        cbsemester.setBounds(250,110,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lblentersubject=new JLabel("ENTER SUBJECT");
        lblentersubject.setBounds(100,150,200,40);
        lblentersubject.setFont(new Font("serif",Font.BOLD,15));
        add(lblentersubject);

        JLabel lblentermarks=new JLabel("ENTER MARKS");
        lblentermarks.setBounds(320,150,200,40);
        lblentermarks.setFont(new Font("serif",Font.BOLD,15));
        add(lblentermarks);

        tfsub1=new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);

        tfsub2=new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);

        tfsub3=new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);

        tfsub4=new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);

        tfsub5=new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);

        tfmarks1=new JTextField();
        tfmarks1.setBounds(275,200,200,20);
        add(tfmarks1);

        tfmarks2=new JTextField();
        tfmarks2.setBounds(275,230,200,20);
        add(tfmarks2);

        tfmarks3=new JTextField();
        tfmarks3.setBounds(275,260,200,20);
        add(tfmarks3);

        tfmarks4=new JTextField();
        tfmarks4.setBounds(275,290,200,20);
        add(tfmarks4);

        tfmarks5=new JTextField();
        tfmarks5.setBounds(275,320,200,20);
        add(tfmarks5);

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
        cancel.setBounds(275,400,120,30);
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
            try
            {
                CONNECTION c=new CONNECTION();
                String query1="insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
                String query2="insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"MARKS INSERTED SUCCESSFULLY");
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
    public static void main(String args[])
    {
        new ENTERMARKS();
    }
}