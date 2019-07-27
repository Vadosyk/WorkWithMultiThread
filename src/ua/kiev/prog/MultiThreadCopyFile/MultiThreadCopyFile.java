package ua.kiev.prog.MultiThreadCopyFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class MultiThreadCopyFile extends Thread {
	File src;
	File dest;
    long start;
    long end;
 
    public MultiThreadCopyFile (File src, File dest, long start, long end) {
        this.src = src;
        this.dest = dest;
        this.start = start;
        this.end = end;
    }
 
 public static void copyDir (String source, String destination) throws IOException {
	 	
		File src = new File(source);
		File dest = new File(destination);
		System.out.println("Wait!!!");
    		if (src.isDirectory()){
    			if (!dest.isDirectory()){
    				dest.mkdir();
    			}
    			File[]sfile=src.listFiles();
    			File[]dfile= new File[sfile.length];
    				for (int i=0; i< sfile.length; i++){
    					String file1=sfile[i].getPath();
    					String file2 = file1.replace(source, destination);
    					dfile[i]=new File(file2);
    					copyBuf(sfile[i],dfile[i]);
    				}
	  			}else{
	  			System.out.println("No such directory " +  destination);
	  			}
	  		System.out.println("Done!!!");
    	}

	private static void copyBuf(File from, File to) {
		try {		
			try(FileInputStream fis = new FileInputStream(from);
					FileOutputStream fos = new FileOutputStream(to)) {
				
				try(BufferedInputStream bis = new  BufferedInputStream(fis);
						BufferedOutputStream bos = new  BufferedOutputStream(fos)) {
					
					byte [] buff= new byte [128*1024];
					int str;
                while ((str=bis.read(buff))!=-1) {
                	
                	
                    bos.write(buff,0,str);
                }
            } 
        } 
	            
        
		}catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}
    
    @Override
    public void run() {
    	
    	try{
	 		copyDir("D:\\Test1","D:\\Test2");
	 	}catch (IOException e){
	 		System.out.println(e.getMessage());
	 	}	
    	
    }
}
