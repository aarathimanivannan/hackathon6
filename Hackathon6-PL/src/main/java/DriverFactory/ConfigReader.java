package DriverFactory;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	public class ConfigReader {

	
		public Properties init_prop() throws Exception {
		Properties prop = new Properties();
		
		FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\ConfigReader\\Config.properties");
		
		prop.load(file_path);
		
	     return prop;

	 

	    }
	}


	
	
	
	
	/*public Properties prop;

	 
    public Properties init_prop() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("opencartConfig\\OpencartConfig.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
