package edu.usal.service;

import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;
import java.io.IOException;

public class LogHandler {

	public LogHandler(Exception e) {
		try {
			PrintWriter writer = new PrintWriter("latest.log", "UTF-8");
			e.printStackTrace(writer);
			writer.close();
		} catch(UnsupportedEncodingException e2) {
			e2.printStackTrace();
			e.printStackTrace();
		} catch(IOException e2) {
			e2.printStackTrace();
			e.printStackTrace();
		} catch (Exception e2) {
			e.printStackTrace();
		}
	}
}
