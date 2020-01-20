package OAuth2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class oauth2 {
    String access_token="";

    @Test
    public void Test01_getCode() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("sadacs2005");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        
        
        String url=driver.getCurrentUrl();
        
        }
    
   // @Test
    public void Test02_getAccessToken() {
        RestAssured.baseURI="https://www.googleapis.com";
        String tokenResponse=RestAssured.given().
        queryParam("code","").
        queryParam("scope","email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid").
        queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
        queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W").
        queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php").
        queryParam("grant_type","authorization_code").
        when().log().all().post("/oauth2/v4/token").
        then().extract().response().asString();
        JsonPath jp= new JsonPath(tokenResponse);
        access_token=jp.get("access_token").toString();
    }
    
    //@Test
        public void Test03_getAllCourses() {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        Response res=RestAssured.given().queryParam("access_token",access_token).
                      when().get("/getCourse.php").
                      then().extract().response();
        }
    }


