package com.Automation.HoroLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteConfig {

/**
* @author UmaSasmal
* @param value
* @param WriteCongig
*/
public void writeData(String key, String value, String fileName){

try {
FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\"+fileName+".properties");
Properties props = new Properties();
props.load(in);
in.close();

FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "\\"+fileName+".properties");
props.setProperty(key, value);
props.store(out, null);
out.close();
} catch (FileNotFoundException ex) {
// file does not exist
} catch (IOException ex) {
// I/O error
}
}
}