package util;

public class BrowserCleaner {

    public static void killAllProcesses(String typeOfBrowser) {
        if (System.getProperty("os.name").contains("windows")) {
            try {
                if (typeOfBrowser.equalsIgnoreCase("firefox") || typeOfBrowser.equalsIgnoreCase("mozilla firefox")) {
                    Process process = Runtime.getRuntime().exec(
                            "Taskkill /IM firefox.exe /F");
                    process.waitFor();
                    System.out.println("All Firefox processes are closed.");
                } else if (typeOfBrowser.equalsIgnoreCase("chrome") || typeOfBrowser.equalsIgnoreCase("google chrome")) {
                    Process process = Runtime.getRuntime().exec(
                            "Taskkill /IM chrome.exe /F");
                    process.waitFor();
                    System.out.println("All Google Chrome processes are closed.");
                } else if (typeOfBrowser.equalsIgnoreCase("explorer") || typeOfBrowser.equalsIgnoreCase("internet explorer") || typeOfBrowser.equalsIgnoreCase("ie")) {
                    Process process = Runtime.getRuntime().exec(
                            "Taskkill /IM iexplore.exe /F");
                    process.waitFor();
                    System.out.println("All Internet Explorer processes are closed.");
                } else if (typeOfBrowser.equalsIgnoreCase("opera")) {
                    Process process = Runtime.getRuntime().exec(
                            "Taskkill /IM opera.exe /F");
                    process.waitFor();
                    System.out.println("All Opera processes are closed.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
           try{
               if (typeOfBrowser.equalsIgnoreCase("firefox") || typeOfBrowser.equalsIgnoreCase("mozilla firefox")) {
                   Process process = Runtime.getRuntime().exec(
                           "killall firefox");
                   process.waitFor();
                   System.out.println("All Firefox processes are closed.");
               } else if (typeOfBrowser.equalsIgnoreCase("chrome") || typeOfBrowser.equalsIgnoreCase("google chrome")) {
                   Process process = Runtime.getRuntime().exec(
                           "killall chrome");
                   process.waitFor();
                   System.out.println("All Google Chrome processes are closed.");
               }
           }catch (Exception e){
               e.printStackTrace();
           }
        }
    }

}
