package day13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageIOLab {

	public static void main(String[] args) {
		String path =  "c:/iotest/myimage";
		File isDir = new File(path);
		if(!isDir.exists()) {
			isDir.mkdirs();
		}
		
		try(FileReader reader = new FileReader("c:/iotest/list.txt");
				BufferedReader br = new BufferedReader(reader);){
			String data;
			String fileName;
			URL req = null;    
			InputStream is = null;
			FileOutputStream fos = null;
			String [] arr = new String[2];
			int input = 0;
			
			while(true) {
				data=br.readLine();
				if(data == null) break;
				arr= data.split(",");
				fileName = path+"/"+arr[0]+".jpg";
			
				req = new URL(arr[1]);
				is = req.openStream();
				fos = new FileOutputStream(fileName);
				
				input=0;
				while(true) {
					input = is.read();
					if(input == -1) break;
					fos.write(input);
				}
				
				fos.close();
				System.out.printf("%s가 성공적으로 저장되었습니다.\n",arr[0]+".jpg");
			}
			
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(MalformedURLException e) {	
			System.out.println("URL문자열 오류 : " + e.getMessage());
		} catch (IOException ioe) {
			System.out.println("IO 오류 : " + ioe.getMessage());
		}

	}

}
