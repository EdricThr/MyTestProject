package com.THR.HTTP;

import com.base.util.StringUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 无key参数请求
 *
 * @author Thr
 */
public class HttpPostRequest {

    //public static String url = "http://10.0.42.220:8080/NoneKeyServlet";
    public static String url = "https://10.0.200.189/kmclient?action=describeMailboxInfo&domainAccount=user3";


    public static void main(String args[]) throws Exception {

        doHttpUrlConnectionReqWithParam();
        //doHttpClientWithKeyParam();
    }

    /**
     * 使用HttpURLConnection做post请求，设置参数
     * @throws Exception
     */
    public static void doHttpUrlConnectionReqWithParam() throws Exception {
        String paramValue = "aa=hhhhhh";
        String result = doHttpUrlConnectionRequest(url, paramValue);
        System.out.println(result);
    }

    /**
     * 使用HttpClient进行post请求，设置参数
     * @throws Exception
     */
    public static void doHttpClientWithKeyParam() throws Exception {
        doHttpclientRequest(url);
    }


    private static String doHttpUrlConnectionRequest(String url, String paramValue) throws Exception {
        try {
            String charset = null;
            if (StringUtil.isEmpty(charset)){
                charset = "UTF-8";
            }
            URL postUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();

            conn.setConnectTimeout(0);
            conn.setReadTimeout(0);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //如下设值，可在header中得到对应属性
            conn.setRequestProperty("aaa","bbbb");
            conn.setRequestProperty("bbb","bbbb");
            conn.setRequestProperty("ccc","bbbb");
            conn.setRequestProperty("dddd","bbbb");

            //如下设置，可使用getParameter获取值，或者直接从流中读取，但是只能使用一种
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.write(paramValue.getBytes(charset));
            out.flush();
            out.close(); // flush and close

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

                StringBuffer result = new StringBuffer();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                reader.close();
                return URLDecoder.decode(result.toString(), charset);
            }else{
                throw new Exception("实时同步用户数据任务,请求数据失败,返回码：" + conn.getResponseCode());
            }
        } catch (Exception e) {
            throw e;
        }
    }


    public static void doHttpclientRequest(String url) throws Exception {
        HttpClient client = new DefaultHttpClient();

        HttpPost post = new HttpPost(url);

        List<NameValuePair> parameters = new ArrayList<>();
        NameValuePair nameValuePair = new BasicNameValuePair("username","thr");
        parameters.add(nameValuePair);
        post.setEntity(new UrlEncodedFormEntity(parameters, HTTP.UTF_8));

        HttpResponse response = client.execute(post);

        int status = response.getStatusLine().getStatusCode();
        if (status != HttpStatus.SC_OK) {
            throw new Exception("执行请求失败");
        }
        String result = EntityUtils.toString(response.getEntity());
        System.out.println("result:"+result);
    }
}
