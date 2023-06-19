package demo.accessingdatamysql;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RequestController {
    public static class Token {
        public String code;
        public String data;
        public String msg;
        public Boolean success;
    }

    public static class External {
        public String code;
        public List<AppObj> data;
        public String msg;
        public Number size;
        public Number total;
    }

    public static class AppObj {
        public String appSecret;
        public String appId;
        public String accountEnabled;
        public String appName;
        public String sts;
        public String threshold;
        public String appOwner;
        public String token;
        public String gateCode;
        public String desc;
        public String createTs;
        public String lastModTs;
        public String privilege;
    };

    public static String sendPOST(String POST_URL, String POST_DATA, String HEADER_PROPERTY) throws IOException {
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        // con.setRequestProperty("User-Agent", USER_AGENT);
        con.setDoInput(true); // 對於APP端而言，如果需要有'input'，也就是接收server的回傳結果，則需要設為true
        con.setDoOutput(true); // 對於App端而言，如果有需要'output'，也就是傳送資料給 server，則需要設為true
        if (HEADER_PROPERTY != "") {
            con.setRequestProperty("Authorization", "Basic" + " " + HEADER_PROPERTY);
        }

        // For POST only - START
        OutputStream os = con.getOutputStream();
        System.out.println(POST_DATA.toString());
        os.write(POST_DATA.toString().getBytes());
        os.flush();
        os.close();
        // For POST only - END
        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            ObjectMapper mapper = new ObjectMapper();
            // JSON string to Java Object
            Token responseObj = mapper.readValue(response.toString(), Token.class);
            System.out.println(responseObj.data);
            return responseObj.data;
        } else {
            System.out.println("POST request did not work.");
            return "";
        }
    }

    public static List<AppObj> sendPOST2(String POST_URL, String POST_DATA, String HEADER_PROPERTY) throws IOException {
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.setDoOutput(true);
        if (HEADER_PROPERTY != "") {
            con.setRequestProperty("Authorization", "Basic" + " " + HEADER_PROPERTY);
        }

        // For POST only - START
        OutputStream os = con.getOutputStream();
        System.out.println(POST_DATA.toString());
        os.write(POST_DATA.toString().getBytes());
        os.flush();
        os.close();
        // For POST only - END
        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            ObjectMapper mapper = new ObjectMapper();
            // JSON string to Java Object
            External responseObj = mapper.readValue(response.toString(), External.class);
            List<AppObj> appObj = responseObj.data;
            System.out.println(appObj);
            return appObj;
        } else {
            System.out.println("POST request did not work.");
            return null;
        }
    }

}
