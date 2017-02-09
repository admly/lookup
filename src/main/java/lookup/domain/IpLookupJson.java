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
	private double latitude;
	private double longitude;
	private String ip;
	private String countryCode;
	private String city;

	
	public double getLatitude(){return this.latitude;}
	public double getLongitude(){return this.longitude;}
	public String getIp(){return this.ip;}
	public String getCountryCode(){return this.countryCode;}
	public String getCity() {return city;}
}
