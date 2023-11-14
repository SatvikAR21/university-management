import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class STUDENTFEEFORM extends JFrame implements ActionListener
{
    JLabel labeltotal;
    Choice crollno;
    JComboBox cbcourse,cbbranch,cbsemester;
    JButton update,pay,back;
    STUDENTFEEFORM()
    {
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("UNIIM2.jpg"));//HERE WE HAVE BROUGHT OUT IMAGE TO THE PROGRAM
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);//WE HAVE DONE THE THE SCALING OF THE IMAGE FOR THE FRAME
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,200);
        add(image);

        JLabel lblrollno=new JLabel("SELECT ROLL NUMBER");
        lblrollno.setBounds(40,60,195,20);
        lblrollno.setFont(new Font("serif",Font.BOLD,16));
        add(lblrollno);
        //DROP DOWN ADDED FOR THE SEARCH BY ROLL NUMBER
        crollno=new Choice();
        crollno.setBounds(240,60,150,20);
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
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblname);
        //CREATING THE NAME TEXTFIELD
        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);

        //PUT THE FATHER NAME LABEL
        JLabel lblfname=new JLabel("FATHER'S NAME");
        lblfname.setBounds(40,140,200,15);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblfname);
        //CREATING THE FATHER NAME TEXTFIELD
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname);

        try
        {
            CONNECTION c=new CONNECTION();
            String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));

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

                    }
                }
                catch (Exception ee)
                {
                    ee.printStackTrace();
                }
            }
        });

        JLabel lblcourse=new JLabel("COURSE");
        lblcourse.setBounds(40,180,150,20);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcourse);
        //NOW WE WILL CREATE A DROPDOWN FOR THE COURSE
        //WE ARE ALSO ADDING SOME OF THE VALUES IN THE DROPDOWN
        String course[]={"BTech","BBA","BCA","Bsc","Msc","MCA","MCom","MA","BA"};

        cbcourse=new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        //NOW WE ADD COURSE BRANCH LABEL
        JLabel lblbranch=new JLabel("BRANCH");
        lblbranch.setBounds(40,220,150,20);
        lblbranch.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblbranch);
        //NOW WE WILL CREATE A DROPDOWN FOR THE COURSE BRANCH
        //WE ARE ALSO ADDING SOME OF THE VALUES IN THE DROPDOWN
        String branch[]={"COMPUTER SCIENCE","ELECTRONICS","MECHANICAL","CIVIL","IT"};

        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);


        JLabel lblsemester=new JLabel("SELECT SEMESTER");
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("serif",Font.BOLD,16));
        add(lblsemester);

        String semester[]={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        cbsemester=new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lbltotal=new JLabel("TOTAL PAYABLE");
        lbltotal.setBounds(40,300,350,20);
        lbltotal.setFont(new Font("serif",Font.BOLD,16));
        add(lbltotal);

        labeltotal=new JLabel("");
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("serif",Font.BOLD,16));
        add(labeltotal);


        //MAKING THE BUTTON OF THE SUBMIT
        update=new JButton("UPDATE");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("serif",Font.BOLD,16));
        add(update);
        //MAKING THE BUTTON OF THE CANCEL
        pay=new JButton("PAY FEE");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma",Font.BOLD,16));
        add(pay);


        //MAKING THE BUTTON OF THE CANCEL
        back=new JButton("BACK");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        add(back);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {
            String course=(String) cbcourse.getSelectedItem();
            String semester=(String) cbsemester.getSelectedItem();
            try
            {
                CONNECTION c= new CONNECTION();
                ResultSet rs=c.s.executeQuery("select * from fees where course = '"+course+"'");
                while(rs.next())
                {
                    labeltotal.setText(rs.getString(semester));
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==pay)
        {
            String rollno=crollno.getSelectedItem();
            String course=(String) cbcourse.getSelectedItem();
            String semester=(String) cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total=labeltotal.getText();
            try
            {
                CONNECTION c= new CONNECTION();
                String query= "insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"College fee submited successfully");
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
        new STUDENTFEEFORM();

    }
}