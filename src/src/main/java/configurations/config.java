package configurations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class config {
	FileReader reader; 
	Properties p;
public  String Getproperities (String propertykey) throws IOException {
	
	
		return p.getProperty(propertykey);
}




public  config(String filepath)  {
	super();
	try {
		this.reader =new FileReader(System.getProperty("user.dir")+"/src/main/java/configurations/"+filepath);
		p=new Properties(); 
		try {
			p.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
