package nl.hanze.designpatterns.datahandler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileDataHandler extends AbstractDataHandler {
	private File file; // Source text file.
	
	public FileDataHandler(File file) {
		this.file = file;
	}
	
	@Override
	public String readData() {
		FileReader reader = null;
		
		try {
			reader = new FileReader(file);
			char[] buffer = new char[1024];
			StringBuilder builder = new StringBuilder();
			int bytesRead = 0;
			
			while((bytesRead = reader.read(buffer)) != -1) {
				builder.append(buffer, 0, bytesRead);
			}
			
			reader.close();
			return builder.toString();
		} catch (Exception e) {
			if(reader != null) {
				try { reader.close(); }
				catch (IOException e1) {} 
			}
			return null;
		}
	}

	@Override
	public String processData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeData() {
		// TODO Auto-generated method stub
		
	}

}
