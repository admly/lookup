package lookup.domain;

public class IpLookupJson {
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
