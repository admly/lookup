package lookup.service;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import lookup.domain.ConfigFile;

@Service
public class GoogleApiService {
	public String GetApiKey() throws FileNotFoundException {
		String fileLocation = "config.json"; //path to json config with {"api_key" : "..."}
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(fileLocation));
		ConfigFile response = gson.fromJson(reader, ConfigFile.class );
		String apiKey = response.getApiKey();
		return apiKey;
	}
}
