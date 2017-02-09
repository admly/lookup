package lookup.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import lookup.domain.IpLookupJson;
import lookup.service.GoogleApiService;
import lookup.service.IpLookupJsonService;



@Controller
public class HomeController {
	
	@Autowired
	private GoogleApiService googleApiService;
	
	@Autowired
	private IpLookupJsonService ipLookupJson;
	
	
	
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
	public String getClientIpAddress(Model model, HttpServletRequest request) throws MalformedURLException, IOException {
		
	
	    for (String header : HEADERS_TO_TRY) {
	        String ip = request.getHeader(header);
	        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
	            model.addAttribute("pro", ip);
	        }
	    }
	    model.addAttribute("address", request.getRemoteAddr());
	    model.addAttribute("host",request.getRemoteHost());
	    model.addAttribute("port",request.getRemotePort());
		model.addAttribute("xml", ipLookupJson.GetJson());

	    
	    return "hello";
	}


	@RequestMapping("/map")
	public String welcome(Model model, HttpServletRequest request) throws MalformedURLException, IOException {
		String url = "http://freegeoip.net/json/";
		String charset = java.nio.charset.StandardCharsets.UTF_8.name();
//		String param1 = request.getRemoteAddr().replaceAll(":", "."); // this should be uncommented in production enviornment instead of that line under
		String param1 = "62.181.220.227"; //hardcoded for a test purposes
		String query = String.format(URLEncoder.encode(param1, charset));
		URLConnection connection = new URL(url + query).openConnection();
		InputStream response = connection.getInputStream();
		Reader reader = new InputStreamReader(response, charset);
		IpLookupJson result  = new Gson().fromJson(reader, IpLookupJson.class);
		
		model.addAttribute("longtitude", result.getLongitude());
		model.addAttribute("latitude", result.getLatitude());
		model.addAttribute("api_key", googleApiService.GetApiKey());
		return "map";
	}}

