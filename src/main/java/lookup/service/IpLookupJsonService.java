package lookup.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import lookup.domain.IpLookupJson;

@Service
public class IpLookupJsonService {
	public String GetJson() throws MalformedURLException, IOException{
		String url = "http://freegeoip.net/json/";
		String charset = java.nio.charset.StandardCharsets.UTF_8.name();
		String param1 = "195.26.76.94";
		String query = String.format(URLEncoder.encode(param1, charset));
		URLConnection connection = new URL(url + query).openConnection();
		InputStream response = connection.getInputStream();
		Reader reader = new InputStreamReader(response, charset);
		IpLookupJson result  = new Gson().fromJson(reader, IpLookupJson.class);
		String ipAdress = result.getIp();
		return ipAdress;
	}
}
