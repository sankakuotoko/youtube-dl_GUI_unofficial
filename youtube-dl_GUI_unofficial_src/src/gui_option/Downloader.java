package gui_option;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Downloader {
  String file;
  
  String file2;
  public String outputs = "";
  void commands() {
    Runtime runtime = Runtime.getRuntime();
    String[] Command = { "youtube-dl",/*"-o","\"" + (Gui.p3t1.getText())+"\"", */Gui.str ,"","","","","","",""};
    if(Gui.c1.getState()) {
    	Command[3] = "-x" ;
    	Command[4] = "--audio-format";
    	Command[5] = Gui.p4t1.getText();
    }
    if(Gui.c2.getState()) {
    	Command[6]="--all-formats";
    }
    if(Gui.p5c1.getState()) {
    	Command[7] = "-f";
    	Command[8] = Gui.p5t1.getText();
    }
    this.file = Gui.p2t1.getText();
    this.file2 = this.file.replace("\\", "/");
    File dir = new File(file2);
    Process p = null;
    try {
      p = runtime.exec(Command, null, dir);
    } catch (IOException ignored) {
      ignored.printStackTrace();
    } 
    try {
      p.waitFor();
    } catch (InterruptedException ignored) {
      ignored.printStackTrace();
    } 
    InputStream is = p.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    while (true) {
      String line = null;
      
    	  try {
              Thread.sleep(10L);
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
        try {
			line = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
        if (line != null) {
        	
          outputs = String.valueOf(outputs) + line;
          
          Gui.l2.setText("line:"+line);
         
            System.out.println("line:" + line);
          
        try {
          Thread.sleep(10L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } 
      	if ((line.indexOf("[download] 100%") != -1)) {
      		try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          break; }
      	if ((line.indexOf("Error") != -1)) {
      		try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      		break; 
      		}else if (line.indexOf("has already")!=-1) {
      			try {
    				br.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
      		break;	
      		}
    
  }
      }}}

