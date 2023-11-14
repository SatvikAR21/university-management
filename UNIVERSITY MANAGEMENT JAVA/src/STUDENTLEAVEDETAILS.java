import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//BY THIS WE ARE GOING TO MAKE THE EVENT OF A CLICK ON OUR 5 BUTTONS
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;//AFTER IMPORTING THIS CLASS WE CAN DIRECTLY PUT ALL THE DATA INSIDE THE TABLE FROM THE MYSQL WITHOUT THE HELP OF THE WHILE LOOP


//HERE WE ARE WRITING THE CODE FOR THE DISPLAY OF THE SUDENT DETAILS WHICH WE HAVE ENTERED IN THE PREVIOUS WINDOw
public class STUDENTLEAVEDETAILS extends JFrame implements ActionListener
{
    //TILL NOW WE MADE THE DROPDOWN WITH THE HELP OF JCOMBOX BUT NOW WE CAN ALSO MAKE THE DROPDOWN WITH THE HELP OF THE CHOICE
    Choice crollno;
    JTable table;//NOW WE ARE CREATING A TABLE
    JButton search,print,update,add,cancel;//HERE NOW WE ARE CREATING THE BUTTONS

    STUDENTLEAVEDETAILS()
    {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //LABEL OF SEARCH BY ROLL NUMBER ADDED
        JLabel heading=new JLabel("SEARCH BY ROLL NUMBER");
        heading.setBounds(20,20,170,20);
        add(heading);
        //DROP DOWN ADDED FOR THE SEARCH BY ROLL NUMBER
        crollno=new Choice();
        crollno.setBounds(200,20,150,20);
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

        table=new JTable();
        //NOW WE ARE CREATING A TABLE
        //IN THE TABLE WE NEED A SCROLL BAR WHICH WE WILL GET WITH THE HELP OF THE jSCROLLPANE
        //NOW AGAIN WE WILL INSERT THE VALUES IN THE TABLE WITH THE HELP OF MYSQL
        //NOW IN ORDER TO GET THE INFORMATION IN THE TABLE WE NEED TO IMPORT A LIABRARY WHICH WE DID IE RS2XML.JAR

        try
        {
            CONNECTION c = new CONNECTION();//WE CREATED THE OBJECT OF THE CONNECTION CLASS THAT IS THE CLASS WHICH IS CONNECTING US TO THE MYSQL
            ResultSet rs = c.s.executeQuery(("select * from studentleave"));
            //BY CALLING THESE FUNCTIONS WE GOT EVERYTHING DIRECTLY FROM OUR DATABASE IE MYSQL DIRECTLY TO THE GUI
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        search=new JButton("SEARCH");
        search.setBounds(20,70,85,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("PRINT");
        print.setBounds(220,70,80,20);
        print.addActionListener(this);
        add(print);



        cancel=new JButton("CANCEL");
        cancel.setBounds(420,70,85,20);
        cancel.addActionListener(this);
        add(cancel);





        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)//NOW WE ARE OVERRIDING THE FUNCTION
    {

        if(ae.getSource()==search)//IN THE SEARCH BUTTON WE WILL SEARCH FOR A PARTICULAR STUDENT WITH A PARTICULAR ROLL NUMBER
        {//WE WILL CLICK ON A PARTICULAR ROLL NUMBER AND THEN ONLY THAT ONE WILL BE DISPLAYED AND NOT THE OTHERS
            String query="select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
            try
            {
                //BASICALLY AFTER THE SELECTION OF THE ROLL NUMBER ANOTHER TABLE WILL BE DISPLAYED OF THAT ROLL NUMBER ONLY
                CONNECTION c=new CONNECTION();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==print)
        {
            try
            {
                table.print();//WE HAVE PUT THE PRINT IN THE TRY CATC SINCE PRINTER IS THE EXTERNAL PROPERTIES THEREFORE THERE ARE SOME CHANCES OF GETTING AN ERROR
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        else if (ae.getSource()==cancel)
        {
            setVisible(false);//WE CLOSE OUR CURRENT FRAME

        }
    }
    public static void main(String[] args)
    {
        new STUDENTLEAVEDETAILS();

    }
}