package modelo;

import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;


/**
 * Representa una estación metereológica virtual.
 * La información es recuperada desde Yahoo Weather.
 * 
 * @author Angel Augusto Agudelo Z
 * @version Nov.2012 
 */
public class WeatherStation 
{
	private HashMap<String, String> cityCodes;
	private boolean searchByName;
	private Document xmlData;
	private String cityName;
	private String yahooCityName;
	private String cityCode;
	private int temperature;
	private int humidity;
	private String sunrise;
	private String sunset;
	private String imgURL;
	private ImageIcon icon;
	private boolean online;

	// Valores por defecto para pasar FMSG
	private String proxyHost = "proxy2.utp.edu.co";
	private int proxyPort = 8080;

	/**
	 * Crea una nueva Estación Metereológica. 
	 * Ubicación por defecto Pereira. La estación se pone online.
	 */
	public WeatherStation() 
	{
		cityCodes = new HashMap<String, String>();
		fillCityCodes();
		setCityName("Pereira");
		online = true;
	}

	/**
	 * Establece alguna ciudades que pueden ser accesadas por su nombre.
	 */
	private void fillCityCodes() 
	{
		// todas las ciudades en minusculas!
		cityCodes.put("Barranquilla", "COXX0002");
		cityCodes.put("Bogota", "COXX0004");
		cityCodes.put("Bucaramanga", "COXX0005");
		cityCodes.put("Cali", "COXX0008");
		cityCodes.put("Cartago", "COXX0010");
		cityCodes.put("Pereira", "COXX0024");
		cityCodes.put("Rio de Janeiro", "BRXX0201");
    }

	/**
	 * @return Nombre de la ciudad seleccionada.
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @return Nombres de todas las ciudades disponibles.
	 */
	public String[] getCityNames() 
	{
		Set<String> namen = cityCodes.keySet();
		return namen.toArray(new String[0]);
	}

	/**
	 * @return Nombre retornado por servicio metereológico de Yahoo.
	 */
	public String getYahooCityName() {
		return yahooCityName;
	}

	/**
	 * Fija código de la ciudad. El código debe ser algo como: COXX0018.
	 * Se debe visitar la pagina de yahoo para ver los códigos existentes.  
	 * @param El código de la ciudad.
	 */
	public void setCityCode(String code) 
	{
		cityCode = code;
		searchByName = false;
	}

	/**
	 * @return Código de la ciudad.
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * Fija la ubicacion de la Estación Metereológica. 
	 * La ciudad solo se cambia cuando la encuentra en la lista.
	 * @param nombre de la ciudad
	 * @return true, si la ciudad existe, false si no se encontró la ciudad.
	 */
	public boolean setCityName(String city) 
	{
		for (String key : cityCodes.keySet()) {
			if (key.equalsIgnoreCase(city)) {
				cityName = city;
				searchByName = true;
				cityCode = cityCodes.get(key);
				return true;
			}
		}
		return false;
	}

	/**
	 * Obtiene la temperatura de la ciudad.
	 */
	public int getTemperature() {
		return temperature;
	}

	/**
	 * Obtiene la humedad de la ciudad.
	 */
	public int getHumidity() {
		return humidity;
	}

	/**
	 * Obtiene la salida del sol de la ciudad.
	 */
	public String getSunrise() {
		return sunrise;
	}

	/**
	 * Obtiene la puesta del sol de la ciudad.
     */
	public String getSunset() {
		return sunset;
	}

	/**
	 * Obtiene un url de un icono que represente el tiempo. 
	 * @return URL de la imagen representando el tiempo actual.
	 */
	public String getImgURL() {
		return imgURL;
	}

	/**
	 * Obtiene una ImageIcon representando el tiempo.
	 */
	public ImageIcon getIcon() {
		return icon;
	}

	/**
	 * Fija online para datos reales.  Fijar offline para propósitos de prueba
	 * sin conexión a internet. Cuando está offline se generan datos aleatorios.
	 * @param Nuevo estaus online: true si online, false si offline
	 */
	public void setOnline(boolean isOnline) 
	{
		online = isOnline;
		if (!online) {
			setDummyValues();
		}
	}

	/**
	 * Obtiene el estatus de la estación.
	 * @return true si online. false si offline.
	 */
	public boolean isOnline() {
		return online;
	}

	/**
	 * Descarga el Documento XML desde el tiempo de Yahoo.
     */
	private void loadXMLDocument() 
	{
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			xmlData = builder.parse("http://xml.weather.yahoo.com/forecastrss?p=" + cityCode + "&u=c");
		} 
		catch (Exception ex) {
			System.err.println(ex);
		}
	}

	/**
	 * Analiza el Documento XML, que contiene la información.
     */
	private void scanXMLDocument() 
	{
		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			// Comprobar, si el documento es valido
			if (xpath.evaluate("/rss/channel/description", xmlData).equals("Yahoo! Weather Error")) {
				// lanzar una RuntimeException, porque los estudiantes no están forzados a manejarlo,
				// si no conocen de excepciones.
				throw new RuntimeException("Error al leer los datos metereológicos. Tal vez el código de la ciudad es incorrecto...");
			}

			// obtener el contenido de XPath 
			yahooCityName = xpath.evaluate("/rss/channel/location/@city", xmlData);
			humidity = Integer.valueOf(xpath.evaluate("/rss/channel/atmosphere/@humidity", xmlData));
			sunrise  = xpath.evaluate("/rss/channel/astronomy/@sunrise", xmlData);
			sunset   = xpath.evaluate("/rss/channel/astronomy/@sunset", xmlData);

			if (!searchByName) {
				cityName = yahooCityName;
			}
			temperature = Integer.valueOf(xpath.evaluate("/rss/channel/item/condition/@temp", xmlData));
			// Dado que la descripción no es XML, el contenido debe ser buscado a mano
			String description = xpath.evaluate("/rss/channel/item/description", xmlData);
			imgURL = find("<img src=\".*\"/>", description);	// buscar primer img-tag
			imgURL = imgURL.substring(10, imgURL.length() - 3);	// obtener src
			icon = new ImageIcon(new URL(imgURL));
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
	}

	/**
	 * Actualiza datos metereológicos. Si no está online, valores dummy son fijados para propósito de pruebas.
	 */
	public void update() 
	{
		if (online) {
			loadXMLDocument();
			scanXMLDocument();
		} 
		else {
			setDummyValues();
		}
	}

	// Retorna el primer substring en la entrada que coincida con el patron.
	// Retorna null si no encuentra coincidencia.
	// Source: http://exampledepot.com/egs/java.util.regex/Greedy.html
	private String find(String patternStr, CharSequence input) 
	{
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	/**
	 * Fija valores aleatorios para pruebas.
	 */
	private void setDummyValues() 
	{
		Random random = new Random();
		cityName = "Offlinecity" + Math.abs(random.nextInt(1000));
		yahooCityName = cityName;
		cityCode = "TheCityCode";
		temperature = random.nextInt(40);
		humidity = random.nextInt(101);
		sunrise = "morning";
		sunset = "evening";
		imgURL = null;
	}

	/**
	 * Alterna on/off del servidor proxy.
	 * 
	 * @param estado true si on, false si off.
     */
	public void setProxy(boolean state) 
	{
		if (state == false) {
			System.clearProperty("proxySet");
			System.clearProperty("proxyHost");
			System.clearProperty("proxyPort");
		}
		else {
			System.setProperty("proxySet", "true");
			System.setProperty("proxyHost", proxyHost);
			System.setProperty("proxyPort", ((Integer) proxyPort).toString());
		}
	}

	public void setProxyHost(String host) 
	{
		proxyHost = host;
		setProxy(false);
		setProxy(true);
	}

	public void setProxyPort(int port) 
	{
		proxyPort = port;
		setProxy(false);
		setProxy(true);
	}	
}

