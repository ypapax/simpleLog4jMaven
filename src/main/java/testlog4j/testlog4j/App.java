package testlog4j.testlog4j;



/**
 * Hello world!
 *
 */
import java.io.*;
import java.net.*;
import org.apache.log4j.*;
import org.apache.log4j.xml.*;
        
public class App 
{
    // Next : check jar 
    static Logger logger = Logger.getLogger(App.class);
    URL url = getClass().getClassLoader().getResource("log4j.xml");
    URL url2 = getClass().getProtectionDomain().getCodeSource().getLocation();
    

    InputStream input = this.getClass().getClass().getResourceAsStream("/log4j.xml");
    
 
    public static void main( String[] args )
    {
        
        App app = new App();
        
        String url2String = app.url2.toString();
        
        
        url2String = "jar:ftp:" + url2String + "!/log4j.xml";
        URL newUrl = null;
        try{
            newUrl = new URL(url2String);
        }catch(Exception x){x.printStackTrace();}
        
        System.out.println("Input:" + app.input);
        System.out.println("URL :" + app.url.toString());
        System.out.println("newURL :" + newUrl);
        
        DOMConfigurator.configure(app.url);
//        try{
//            System.out.println("Resource(.).toURI: " + App.class.getResource(".").toURI());
//        }catch(Exception x ){x.printStackTrace();}
        
//        try{
////            Path path = Paths.get(App.class.getProtectionDomain().getCodeSource().getLocation().getPath());
////          Path path = Paths.get(App.class.getResource("src/main/resources/log4j.xml").toURI());
////            Path parentPath = path.getParent();
////            parentPath = parentPath.getParent();
////            String parent = parentPath.toString();
////            System.out.println("path " + parent);
////////            String logPath = parent + File.separator + "resources" + 
////////                    File.separator + "log4j.xml";
////            String logPath = parent + File.separator + "log4j.xml";
////            URL url = new File(logPath).toURI().toURL();
//        }catch(Exception x ){x.printStackTrace();}
        
        System.out.println( "Hello World!" );
        System.out.println("Resource(.): " + App.class.getResource("."));
        System.out.println("Resource(): " + App.class.getResource(""));
        System.out.println("URL :" + app.url.toString());
        System.out.println("URL2 :" + app.url2.toString());
        System.out.println("newURL :" + newUrl);
        
         if(logger.isDebugEnabled()==true){ 
            logger.debug("DEBUGGIN!");
         }
        logger.info("INFO");
       
    }
    
      private String getJarFolder() {
    // get name and path
    String name = getClass().getName().replace('.', '/');
    name = getClass().getResource("/" + name + ".class").toString();
    // remove junk
    name = name.substring(0, name.indexOf(".jar"));
    name = name.substring(name.lastIndexOf(':')-1, name.lastIndexOf('/')+1).replace('%', ' ');
    // remove escape characters
    String s = "";
    for (int k=0; k<name.length(); k++) {
      s += name.charAt(k);
      if (name.charAt(k) == ' ') k += 2;
    }
    // replace '/' with system separator char
    return s.replace('/', File.separatorChar);
  }
}
