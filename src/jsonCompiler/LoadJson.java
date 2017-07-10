package jsonCompiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class LoadJson {
	public static String loadFromUrl(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			HttpsURLConnection connection = (HttpsURLConnection)urlObject.openConnection();
			connection.setHostnameVerifier(new NullHostnameVerifier());
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
}
