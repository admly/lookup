package lookup.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@Controller
public class HomeController {
	private static final String[] HEADERS_TO_TRY = { 
		    "X-Forwarded-For",
		    "Proxy-Client-IP",
		    "WL-Proxy-Client-IP",
		    "HTTP_X_FORWARDED_FOR",
		    "HTTP_X_FORWARDED",
		    "HTTP_X_CLUSTER_CLIENT_IP",
		    "HTTP_CLIENT_IP",
		    "HTTP_FORWARDED_FOR",
		    "HTTP_FORWARDED",
		    "HTTP_VIA",
		    "REMOTE_ADDR" };

@RequestMapping("/")
	public static String getClientIpAddress(Model model,HttpServletRequest request) throws MalformedURLException, IOException {
		String url = "http://freegeoip.net/json/";
		String charset = java.nio.charset.StandardCharsets.UTF_8.name();
		String param1 = "195.26.76.94";
	
		String query = String.format(URLEncoder.encode(param1, charset));
		URLConnection connection = new URL(url + query).openConnection();
		InputStream response = connection.getInputStream();
		
		
		Reader reader = new InputStreamReader(response, charset);
		JsonResult result  = new Gson().fromJson(reader, JsonResult.class);
		String name = result.getIp();
		
		model.addAttribute("xml", name);

	    for (String header : HEADERS_TO_TRY) {
	        String ip = request.getHeader(header);
	        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
	            model.addAttribute("pro", ip);
	        }
	    }
	    model.addAttribute("address", request.getRemoteAddr());
	    model.addAttribute("host",request.getRemoteHost());
	    model.addAttribute("port",request.getRemotePort());
	    return "hello";
	}


@RequestMapping("/mapa")
public String welcome(Model model) throws FileNotFoundException {
	
	
	String fileLocation = "C:\\Users\\threat\\Desktop\\programowanie\\lookup_webapp\\config.json"; //path to json config with {"api_key" : "..."}
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new FileReader(fileLocation));
	ConfigFile response = gson.fromJson(reader, ConfigFile.class );
	String name = response.getApiKey();
	model.addAttribute("api_key", name);
	return "map";
}}


class ConfigFile {
    private String api_key;
    public String getApiKey(){return this.api_key;}
    
}


class JsonResult {
	private double latitude;
	private double longtitude;
	private String ip;
	private String countryCode;
	private String city;
	
	
	public double getLatitude(){return this.latitude;}
	public double getLongtitude(){return this.longtitude;}
	public String getIp(){return this.ip;}
	public String getCountryCode(){return this.countryCode;}
	public String getCity() {return city;}

	
	
}
