package ua.kiev.prog.MultiThreadCopyFile;

import java.io.File;

public class Main {
	public static void main(String[] args) {
	     
		 final int NUMBERS_OF_BLOCKS = 5;
		 	String source = "D:\\Test1";
			String destination = "D:\\Test2";
			File src = new File(source);
			File dest = new File(destination);
			
       for (int i = 0; i <NUMBERS_OF_BLOCKS ; i++) { 	   
    	   MultiThreadCopyFile thread = new MultiThreadCopyFile(src, dest, src.length()*i/NUMBERS_OF_BLOCKS, (src.length()*(i+1)/NUMBERS_OF_BLOCKS));
    	   thread.start();
            
    	  /* try {
               thread.join();                   
               System.out.println(thread.getName()); 
           } catch (InterruptedException e) {
               e.printStackTrace();
           }*/
    	   
    	   System.out.println(thread.getName());
        }
       
	}
	 
}