package Homework_4_inbook_8_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public class AppendableObjectOutputStream extends ObjectOutputStream{
	
	public AppendableObjectOutputStream() throws IOException {
		super();
	}
	 
	public AppendableObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		return;
	}
	
}


