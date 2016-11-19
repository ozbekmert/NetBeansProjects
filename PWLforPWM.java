import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PWLforPWM 
{
    public static void main(String[] args) 
    {
       
        Double x = new Double(0);
        double stepsize =244.140625;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Duty Cycle: ");
        double dutyCycle =Integer.parseInt(sc.nextLine());
        int border =0;
        int index =0;
        StringBuilder t = new StringBuilder();
   
       
        try 
        {    
            File logFile=new File("pwm.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
           
         for(int cycle=0; cycle<200 ;cycle ++)
         {
               for(int j = 1;j< 4096;j++ )
               {
                   
                   border = (int)(4096*(dutyCycle/100)); 
                   
                   if(index < border)
                   { 
                  
                     t = new StringBuilder();
                     x = (j*stepsize)+(cycle*4096*stepsize);
                     t.append(x.toString());
                     t.append("n    ");
                     t.append("902");
                     t.append("m");
                     t.append(System.getProperty("line.separator"));
                     t.append(System.getProperty("line.separator"));
                     writer.write(t.toString());

                     index++;
                   }
                   else
                   {
                   
                   
                     t = new StringBuilder();  
                     
                     x = (j*stepsize)+(cycle*4096*stepsize);
                     t.append(x.toString());
                     t.append("n    ");
                     t.append("0m");
                     t.append(System.getProperty("line.separator"));
                     t.append(System.getProperty("line.separator"));
                     writer.write(t.toString());
                     index++;
                   }
               }
               index =0;

           
         }
            //Close writer
            writer.close();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }

        
        
        
        
    }
    
}
