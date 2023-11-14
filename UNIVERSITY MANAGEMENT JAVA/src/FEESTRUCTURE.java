import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class FEESTRUCTURE extends JFrame
{
    FEESTRUCTURE()
    {
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("FEE STRUCTURE");
        heading.setBounds(50,10,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);


        JTable table=new JTable();
        try
        {
            CONNECTION c=new CONNECTION();
            ResultSet rs=c.s.executeQuery("select * from fees");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,60,1000,700);
        add(jsp);

        setVisible(true);
    }
    public static void main(String[] args)
    {
        new FEESTRUCTURE();

    }
}