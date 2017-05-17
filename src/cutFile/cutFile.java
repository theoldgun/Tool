package cutFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class cutFile {
	private static Scanner scan;
	public static void readAndWrite(String readPath, List<String> outPutNameList) throws Exception {
		File inPutFile = new File(readPath);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(inPutFile));

		String line1 = reader.readLine();
		String line2 = reader.readLine();
		String end = "/r</testResults>";
		
		String tempString = null;
//		int line = 1;
		for (int i = 0; i < outPutNameList.size(); i++) {
			FileWriter writer = mikDir(outPutNameList.get(i));
			if (i == 0){
				writer.write(line1);
				writer.write(line2);
				while ((tempString = reader.readLine()) != null) {
					if (tempString.contains("2-1")) {
						writer.write(end);
						break;
					}
					writer.write(tempString);
//					System.out.println("line " + line + ": " + tempString);
//					line++;
				}
			}else if(i == outPutNameList.size()-1){
				while ((tempString = reader.readLine()) != null) {
					if (tempString.contains("5-1")) {
						writer.write(line1);
						writer.write(line2);
					}
					writer.write(tempString);
				}
			}else {
				String x = String.valueOf(i+1);
				String y = String.valueOf(i+2);
					while ((tempString = reader.readLine()) != null) {
						if (tempString.contains(x + "-1")) {
							writer.write(line1);
							writer.write(line2);
						}
						writer.write(tempString);
						if (tempString.contains(y + "-1")) {
							writer.write(end);
							break;
						}
					}
			}
			writer.close();
		}
//		}
		reader.close();
	}
	
	public static FileWriter mikDir(String writeName) throws IOException{
		File outPutFile = new File(writeName);
		FileWriter writer = new FileWriter(outPutFile);
		if ( !outPutFile.exists()) {
        	outPutFile.createNewFile();
        }
		return writer;
	}
	
	public static void main(String[] args) throws Exception {
		  scan = new Scanner(System.in);
		  System.out.println("readPath£º");
		  String readPath = scan.nextLine();
		  List<String> outPutNameList = new ArrayList<>();
		  for (int i = 0; i < 5; i++) {
			  System.out.println("outputname£º" + i);
			  String output = scan.nextLine();
			  outPutNameList.add(output);
		}
		  readAndWrite(readPath, outPutNameList);
	}
}

