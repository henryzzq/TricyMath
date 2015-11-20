package com.tricy.util;

import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class RestUtil {
	public static String getHTML(String path, String chars) throws Exception
	{
		HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(path);
        HttpResponse response = client.execute(request);
        Charset charset = Charset.forName(chars);
        String result = EntityUtils.toString(response.getEntity(), charset); 
        return result;
	}
	public static void main(String[] args) throws Exception
	{
		System.out.println(RestUtil.getHTML("http://www.17500.cn/ssq/details.php?issue=2006003", "GB2312"));
	}
}
