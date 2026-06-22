package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader
{
	private Properties properties;
	
	public PropertiesLoader(String filePath)
    {
		properties = new Properties();
        try(FileInputStream fis = new FileInputStream(filePath))
        {
            properties.load(fis);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // Method to get a property value by key
    public Properties getProperties()
    {
        return properties;
    }
}