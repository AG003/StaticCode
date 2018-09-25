package configReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader 
{
	public String getConfigReader(String name) throws IOException
	{
		String filePath = System.getProperty("user.dir")+"/src/main/resources/configurationfile/Config.property";
		
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(name);
		
	}
	

}
