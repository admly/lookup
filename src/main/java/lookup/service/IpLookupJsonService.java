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
	public IpLookupJson GetJson() throws MalformedURLException, IOException{
		String url = "http://freegeoip.net/json/";
		String charset = java.nio.charset.StandardCharsets.UTF_8.name();
//		String param1 = request.getRemoteAddr().replaceAll(":", "."); // this should be uncommented in production environment instead of that line under
		String param1 = "62.181.220.227"; //hardcoded for a test purposes
		String query = String.format(URLEncoder.encode(param1, charset));
		URLConnection connection = new URL(url + query).openConnection();
		InputStream response = connection.getInputStream();
		Reader reader = new InputStreamReader(response, charset);
		IpLookupJson result  = new Gson().fromJson(reader, IpLookupJson.class);
		return result;
	}
}
