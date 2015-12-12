package util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpHelper {
    private static Map<String, String> headers;

    public static Map<String, String> setHeaders(){
        headers.put("Cache-Control", "no-cache");
        headers.put("User-Agent:", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");
        headers.put("Accept-Encoding", "gzip, deflate, sdch");
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        return headers;
    }

    public static HttpResponse sendGet(String url, Map<String, Object> params, int expectedStatusCode){
        HttpResponse<JsonNode> response = null;
        String builtUrl = null;
        setHeaders();
//            StringBuilder sb = new StringBuilder(params.size()*5);
//            sb.append(url).append("?");
//            for (String key:params.keySet()){
//                sb.append(key).append("=").append(params.get(key)).append("&");
//
//            }
//            sb.deleteCharAt(sb.lastIndexOf("&"));
//            url = sb.toString();

        if (!(params.isEmpty()) || (params != null)) {
            try {
                response = Unirest.get(url).headers(setHeaders()).queryString(params).asJson();
            } catch (UnirestException e) {
                e.printStackTrace();
                builtUrl = Unirest.get(url).headers(headers).queryString(params).getUrl().toString();
                Assert.fail("Unable to send get request: " + builtUrl);
            }
        }

        Assert.assertEquals(response.getStatus(), expectedStatusCode, "Response code from " + builtUrl + " is not equal to expected" + expectedStatusCode);
        return response;
    }

    public static String sendGetReturnContent(String url, Map<String, Object> params, int expectedStatusCode){
        HttpResponse response = sendGet(url, params, expectedStatusCode);
        BufferedReader reader;
        StringBuilder result = null;
        System.out.println("\n" + response.getBody().toString() + "\n");
        try {
            reader = new BufferedReader(new InputStreamReader(response.getRawBody()));
            String line;
            while ((line = reader.readLine()) != null){
                result.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public static String sendGetReturnContent(String url, int expectedStatusCode) {
        return sendGetReturnContent(url, new HashMap<String, Object>(), expectedStatusCode);
    }


}
