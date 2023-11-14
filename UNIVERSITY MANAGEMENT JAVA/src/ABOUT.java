import javax.swing.*;
import java.awt.*;

public class ABOUT extends JFrame
{
    ABOUT()
    {
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("UNIIM2.jpg"));//HERE WE HAVE BROUGHT OUT IMAGE TO THE PROGRAM
        Image i2=i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);//WE HAVE DONE THE THE SCALING OF THE IMAGE FOR THE FRAME
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);

        JLabel heading=new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70,20,250,130);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);





        setVisible(true);
    }
    public static void main(String[] args)
    {
        new ABOUT();

    }
}

