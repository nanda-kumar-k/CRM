
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "App",eager= true)
public class App 
{
    private String welcomeUserName;
    private String completedGreating;

	public String getCompletedGreating() {
		return completedGreating;
	}
	
	public void setCompletedGreating(String completedGreating) {
		this.completedGreating = completedGreating;
	}
	
	public String getWelcomeUserName() {
		return welcomeUserName;
	}

	public void setWelcomeUserName(String welcomeUserName) {
		this.welcomeUserName = welcomeUserName;
	}

    public void sayhello(){
    	System.out.println("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
    	System.out.println(welcomeUserName);
        completedGreating = "hello, "+ welcomeUserName;
    }
  
}
