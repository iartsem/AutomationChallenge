package browserFactory;

public class BrowserManagerFactory {
    public static BrowserManager getManager(BrowserName name) {
        BrowserManager browserManager = null;
        switch (name) {
            case CHROME:
                browserManager = new ChromeBrowserManager();
                break;
            default:
                browserManager = new ChromeBrowserManager();
                break;
        }
        return browserManager;
    }
}
