import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class EXAMINATIONDETAILS extends JFrame implements ActionListener
{
    JTextField search;
    JButton result, back;
    JTable table;
    EXAMINATIONDETAILS()
    {
        setSize(1000,475);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("CHECK RESULT");
        heading.setBounds(50,15,400,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        search=new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(search);

        //MAKING THE BUTTON OF THE SUBMIT
        result=new JButton("RESULT");
        result.setBounds(300,90,100,30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        result.setFont(new Font("serif",Font.BOLD,16));
        add(result);
        //MAKING THE BUTTON OF THE CANCEL
        back=new JButton("BACK");
        back.setBounds(420,90,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        add(back);

        table=new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);

        try
        {
            CONNECTION c=new CONNECTION();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //WE WANT TO CLICK ON ANY OF THE STUDENT IN THE TABLE AND THEN WE WANT IT TO BE DISPLAYED IN THE ROLL NUMBER SECTION
        //THEREFORE NOW WE ARE APPLYING THE MOUSE LISTENER
        table.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }

        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==result)
        {

            //A NEW FRAME WILL BE OPENED
            new MARKS(search.getText());
            setVisible(false);
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new EXAMINATIONDETAILS();

    }
}