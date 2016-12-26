package lookup.controller;

import java.io.FileNotFoundException;
import java.io.IOException;


import java.net.MalformedURLException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String welcome(Model model) throws FileNotFoundException {
		model.addAttribute("api_key", googleApiService.GetApiKey());
		return "map";
	}}

