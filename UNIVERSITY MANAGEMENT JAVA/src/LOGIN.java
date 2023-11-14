import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class LOGIN extends JFrame implements ActionListener
{
    //WE ARE GLOBALLY DECLARING THE LOGIN AND THE CANCEL BUTTON SO THAT THEY CAN BE CHECKED IN THE ACTIONPERFORMED FUNCTION WHICH BUTTON IS BEING CALLED
    JButton login,cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    LOGIN()
    {
        //HERE WE HAVE CREATED THE FRAME WHICH HAS ITS DIMENSIONS SET AND THE BACKGROUND IS WHITE
        getContentPane().setBackground((Color.WHITE));
        setLayout(null);
        //WE ARE CREATING A LABEL FOR USERNAME
        JLabel lblusername=new JLabel("USERNAME");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);
        //NOW WE ARE CREATING A TEXT FIELD FOR THE USERNAME
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);

        //WE ARE CREATING A LABEL FOR PASSWORD
        JLabel lblpassword=new JLabel("PASSWORD");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);
        //NOW WE ARE CREATING A PASSWORD FIELD FOR THE PASSWORD
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        //WE ARE NOW MAKING THE LOGIN BUTTON
        login=new JButton("LOGIN");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.BOLD,16));
        add(login);
        //NOW WE ARE MAKING THE CANCEL BUTTON
        cancel=new JButton("CANCEL");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        add(cancel);
        //WE ARE NOW ADDING A IMAGE IN THE LOGIN FRAME
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logini.png"));//HERE WE HAVE BROUGHT OUT IMAGE TO THE PROGRAM
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);//WE HAVE DONE THE THE SCALING OF THE IMAGE FOR THE FRAME
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,20,200,200);
        add(image);//ADDED THE IMAGE INTO THE FRAME

        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    //WE ARE OVERRIDING THE FUNCTION WHICH IS IN THE ACTIONLISTENER CLASS
    //IF WE ARE CLICKING THE BUTTON EITHER THE LOGIN OR CANCEL THEN THIS FUNCTION IS BEING CALLED BECAUSE OF WHICH NOW WE HAVE TO WRITE THE CODE OF THE FURTHER PROGRAM IN THIS FUNCTION
    //WE ALSO HAVE TO DIFFERENTIATE IN THIS FUNCTION WHETHER THE CALL IS FROM THE LOGIN OR FROM THE CANCEL

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            String username = tfusername.getText(); //WE CAN TAKE OUT THE TEXT OF THAT USER NAME WHICH IS ENTERED BY THE USER IN THE LOGIN FRAME
            String password = tfpassword.getText();//WE CAN TAKE OUT THE TEXT OF THAT PASSWORD WHICH IS ENTERED BY THE USER IN THE LOGIN FRAME
            //NOW WE WILL CREATE A MYSQL QUERY IE IT IS CHECKING FROM THE MYSQL DATABASE WHETHER MY USERNAME AND PASSWORD IS PRESENT OR NOT IN THE DATABASE
            //HAMNE SINGLE INVERTED COMMA ISILIYE LAGAYE HAIN KYONKI HAMNE APNE DATABASE MEI VARCHAR MEI SINGLE INVERTED COMMA LAGAYE THEE
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            //NOW WE WILL EXECUTE OUR MYSQL QUERY
            //SINCE MYSQL IS AN EXTERNAL ENTITY THEREFORE WE WILL APPLY TRY AND CATCH WHENEVER WE ARE USING MYSQL BECAUSE THERE ARE CHANCES OF GETTING AN ERROR

            try
            {
                CONNECTION c = new CONNECTION();//WE CREATED THE OBJECT OF THE CONNECTION CLASS
                //NOW WE ARE FINALLY HIITING OUR MYSQL QUERY
                ResultSet rs = c.s.executeQuery(query);//IN THE QUERY THE SELECT KEYWORD BRINGS SOME VALUES FROM THE DATABASE WHEN THE QUERY IS HIT THEREFORE IN ORDER TO STORE THOSE VALUES WE CREATE A VARIABLE TO STORE OF THE CLASS RESULT SET
                if(rs.next())//IF RS HAS THE VALUE IN THE DATABASE THEN PROGRAM WILL GO IN THE IF
                {
                    setVisible(false);//IF THE VALUES ARE CORRECT THE WE CLOSED THE LOGIN FRAME AND OPEND THE PROJECT FRAME
                    new PROJECT();
                }
                else//IF RS DOSENT HAVE VALUE IN THE DATABASE THEN THE PROGRAM WILL GO IN THE ELSE PART
                {
                    JOptionPane.showMessageDialog(null,"INVALID USERNAME OR PASSWORD");//MESSAGE DISPLAYED IN THE CASE OF INVALID USERNAME OR PASSWORD
                    setVisible(false);
                }
                c.s.close();//5-FIFTH STEP IN WHICH WE HAVE CLOSED THE CONNECTION

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new LOGIN();
    }
}