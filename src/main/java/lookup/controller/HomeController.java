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
	


	@RequestMapping("/map")
	public String welcome(Model model, HttpServletRequest request) throws MalformedURLException, IOException {
		IpLookupJson result  = ipLookupJson.GetJson();
		
		model.addAttribute("longtitude", result.getLongitude());
		model.addAttribute("latitude", result.getLatitude());
		model.addAttribute("api_key", googleApiService.GetApiKey());
		model.addAttribute("ipadress", request.getRemoteAddr());
		model.addAttribute("countryCode", result.getCountryCode());
		model.addAttribute("city", result.getCity());
		model.addAttribute("countryName", result.getCountryName());
		return "map";
	}}

