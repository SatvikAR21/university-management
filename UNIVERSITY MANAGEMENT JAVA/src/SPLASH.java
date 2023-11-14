import javax.swing.*;
import java.awt.*;

public class SPLASH extends JFrame implements Runnable
{
    Thread t;
    SPLASH()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("UNIIM.jpeg"));//HERE WE HAVE BROUGHT OUT IMAGE TO THE PROGRAM
        Image i2=i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);//WE HAVE DONE THE THE SCALING OF THE IMAGE FOR THE FRAME
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);//ADDED THE IMAGE INTO THE FRAME
        t=new Thread(this);
        t.start();
        setLocation(250,50);//WE SET THE LOCATION OF THE FRAME AT THE TIME OPENING
        setVisible(true);//HERE WE MADE THE FRAME VISIBLE
        setSize(1000,700);//WE SET THE SIZE OF THE FRAME


    }
    //WE ARE OVERRIDINGTHE RUN METHOD WHICH IS IN THE RUNNABLE CLASS
    public void run()
    {
        try
        {
            Thread.sleep(7000);
            setVisible(false);
            //HERE AUTOMATICALLY AFTER 7 SECONDS THE NEXT FRAME WILL BE OPENED
            //NOW WE ARE DOING THE PROCESS SO THAT THE LOGIN FRAME IS OPENED AFTER THE SPLASH FRAME
            //WE HAVE CREATED THE OBJECT OF THE LOGIN SO THAT AS SOON AS THE SPLASH FRAME IS CLOSED THE LOGIN FRAME IS OPENED

            new LOGIN();
        }
        catch(Exception e)
        {

        }
    }
    public static void main(String args[])
    {
        new SPLASH();//WE CREATED AN OBJECT FOR THE SPLASH CLASS
    }
}
