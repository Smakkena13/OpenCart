package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public static final Logger log;
    Properties p;
    RandomStringUtils rm;

    static {
        try {
            File file = new File("C:\\Users\\Happy\\IdeaProjects\\opencart\\log4j2.xml");

            if (file.exists()) {
                ConfigurationSource source = new ConfigurationSource(
                        new FileInputStream(file), file
                );
                Configurator.initialize(null, source);
                System.out.println("Log4j2 initialized manually ✅");
            } else {
                System.out.println("❌ log4j2.xml NOT FOUND at given path!");
            }

            // Debug: Print where Log4j2 loaded config from
            LoggerContext context = (LoggerContext) LogManager.getContext(false);
            System.out.println("Config loaded from: " + context.getConfigLocation());

        } catch (Exception e) {
            System.out.println("❌ Exception: " + e.getMessage());
            e.printStackTrace();
        }

        log = LogManager.getLogger(BaseClass.class);
    }

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String br) throws IOException {
        log.info("Test started");
        log.info("intializing the browser");

        switch(br.toLowerCase()){
            case "chrome": driver=new ChromeDriver();
            break;
            case "edge": driver=new EdgeDriver();
            break;
            case "firefox": driver=new FirefoxDriver();
            break;
            default:
                System.out.println("invalid browser");
                return;
        }
        p=new Properties();
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
        p.load(file);
        driver.get(p.getProperty("url2"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        log.info("maximized the browser");
    }

    @AfterClass
    public void tearDown(){

        System.out.println("tear down");
//        driver.quit();
        log.info("Test completed");
    }
    public String randomString(){
        rm=new RandomStringUtils();
        String alpha=rm.randomAlphabetic(5);
        return alpha;
    }
    public String randomNumeric(){
        String num=rm.randomNumeric(3);
        return num;
    }
    public String randomAlphaNum(){
        String alpha=rm.randomAlphabetic(5);
        String num=rm.randomNumeric(3);
        String alpnum=alpha+num;
        return alpnum;
    }
    public String captureScreenshot(String rname){
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMddmmss");
        Date d=new Date();
        String currdate= df.format(d);

        TakesScreenshot ts= (TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        String targetFilepath=System.getProperty("user.dir")+"\\screenshots\\"+rname+"_"+currdate+"_"+".png";
        File target=new File(targetFilepath);

        source.renameTo(target);
        return targetFilepath;

    }
}
