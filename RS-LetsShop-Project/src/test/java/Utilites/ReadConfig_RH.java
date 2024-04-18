package Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ReadConfig_RH {


	Properties properties;


	public ReadConfig_RH()
	{

		try {
			
			Path filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "java", "Utilites", "config.properties");
			File floc = filePath.toFile();
			FileInputStream fis = new FileInputStream(floc);
			properties = new Properties();
			properties.load(fis);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public String getUserMailId()
	{
		String emailid = properties.getProperty("Email");
		return emailid;
	}
	public String getPassWord()
	{
		String pwd = properties.getProperty("PassWord");
		return pwd;
	}
	public String browserName()
	{
		String browsername = properties.getProperty("BrowserName");
		return browsername;
	}

}
