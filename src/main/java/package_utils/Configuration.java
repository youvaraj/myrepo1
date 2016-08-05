package package_utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Configuration {
    
    private static Properties properties;

   
 
    /*
     * Read and load properties file
     * 
     * @throws - FileNotFoundException, IOException
     */
    public static void loadConfig(){
    	File file = new File(".//resources//setup.properties");
    	
        properties = new Properties();
        try {
			properties.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
    	
    	
    }
    
    
    public static String getPropVal(String propertyName){
    	System.out.println("Getting  " + propertyName + " value ");
    	return properties.getProperty(propertyName);
    	   
    }
    
}
