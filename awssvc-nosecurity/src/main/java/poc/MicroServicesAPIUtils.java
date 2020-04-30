package poc;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URISyntaxException;

public class MicroServicesAPIUtils
{
    public static HttpClient getHttpClient()
    {
        try
        {

            SSLContext sslContext = SSLContext.getDefault();

            SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(sslContext,
                    new String[] { "TLSv1.2" }, // important
                    null, NoopHostnameVerifier.INSTANCE);

            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
                    .register("https", sslConnectionFactory)
                    .register("http", PlainConnectionSocketFactory.INSTANCE).build();

            HttpClientConnectionManager ccm = new BasicHttpClientConnectionManager(registry);
            HttpClient httpclient = HttpClientBuilder.create().setSSLSocketFactory(sslConnectionFactory)
                    .setConnectionManager(ccm).build();
            return httpclient;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new DefaultHttpClient();
        }
    }


    public static void main(String[] args) throws IOException, JSONException {
        //System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3");
        //System.setProperty("jsse.enableSNIExtension","false");
        //HttpClient client=MicroServicesAPIUtils.getHttpClient();
        HttpClient client = new DefaultHttpClient();
        HttpGet get = getHttpGetRequest("2441DX");
        System.out.println(get.getURI());
        HttpResponse response = client.execute(get);
        System.out.println("response: " + response.getStatusLine().getStatusCode());
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity, RestAPIConstants.UTF8);
            JSONObject hubResult = new JSONObject( responseBody);
            System.out.println(hubResult.getString("vStoreId"));
        }

    }


    private static HttpGet getHttpGetRequest(String requestedZone) {
        HttpGet httpGet = null;

        try {
        URIBuilder builder = new URIBuilder("https://9py60jiejd.execute-api.eu-central-1.amazonaws.com/prod/hubs");

        builder.setParameter(RestAPIConstants.ZONE_ID, requestedZone);
        httpGet = new HttpGet(builder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
       httpGet.addHeader(RestAPIConstants.HTTP_HEADER_X_API_KEY, "AWeBGGhGk11QVTrgVofTu22dRXwOpZ3X6L5SC0v7");
        httpGet.addHeader(HttpHeaders.CONTENT_TYPE, RestAPIConstants.JSON_CONTENT_TYPE);

        return httpGet;
    }
}
