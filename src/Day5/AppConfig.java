package Day5;

public class AppConfig {
    private static AppConfig instance = null;

    private String appName;
    private int maxRetries;
    private AppConfig () {
        appName = "LSL";
        maxRetries = 10;
    }

    public static AppConfig getInstance () {
        if(instance == null) {
            instance = new AppConfig();
        }

        return instance;
    }

    public void setAppName (String appName) {
        this.appName = appName;
    }

    public String getAppName () {
        return appName;
    }



}
