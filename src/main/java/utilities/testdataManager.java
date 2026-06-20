package utilities;

import java.util.Map;

public class testdataManager {
    private static ThreadLocal<Map<String,String>> testData =
            new ThreadLocal<>();

    public static void setTestData(Map<String,String> data){
        testData.set(data);
    }

    public static String getData(String key){
        return testData.get().get(key);
    }

    public static void unloadData(){
        testData.remove();
    }
    public static Map<String,String> getAllData() {
        return testData.get();
    }
}
