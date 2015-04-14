
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class CC3200_Controller{

    private static Socket socketAndroid;
    private static Socket socketLaunchPad;
   
    public static void main(String[] args) {
        try{
            int portAndroid = 1200;
            int portLaunchpad = 1201;
            ServerSocket serverSocketAndroid = new ServerSocket(portAndroid);
            ServerSocket serverSocketLaunchpad = new ServerSocket(portLaunchpad);
            System.out.println("Server Started and listening to the port 1200 and 1201");
            while(true){
            	
            	socketLaunchPad = serverSocketLaunchpad.accept();
                System.out.println("Launchpad connected to the server");
            	
            	socketAndroid = serverSocketAndroid.accept();
                System.out.println("Android connected to the server");
                
               
                
                InputStream is = socketAndroid.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);                
                
                OutputStream os = socketLaunchPad.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                
                String rmessage;
                String smessage;
                
                rmessage = br.readLine();
                System.out.println(rmessage);
                
                
                //Scanner s = new Scanner(System.in);                         
                //while(true){
                    //smessage = s.nextLine(); 
                    //System.out.println("Writing the following message to server "+smessage);
                    //bw.write(smessage);
                    //bw.flush();
                    
                    
                    bw.write(rmessage);
                    bw.flush();
                //}
                    
                    //serverSocketAndroid.close();
                    //serverSocketLaunchpad.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally
        {
            try{
               socketAndroid.close();
               socketLaunchPad.close();

            }
            catch(Exception e){
            }
        }
    }
}