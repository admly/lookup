package lookup.domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.google.gson.Gson;

public class IpLookupJson {
	private String country_name;
	private double latitude;
	private double longitude;
	private String ip;
	private String country_code;
	private String city;

	
	public double getLatitude(){return this.latitude;}
	public double getLongitude(){return this.longitude;}
	public String getIp(){return this.ip;}
	public String getCountryCode(){return this.country_code;}
	public String getCity() {return city;}
	public String getCountryName(){return this.country_name;}
}
