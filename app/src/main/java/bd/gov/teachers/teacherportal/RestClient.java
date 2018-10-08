package bd.gov.teachers.teacherportal;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class RestClient {

    private String endPoint;
    private String url;
    private AsyncHttpClient client;

    public RestClient setEndPoint(String endPoint) {
        this.endPoint = endPoint;
        return this;
    }

    public RestClient  setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getFullURl() {
        return endPoint;
    }

    public void get(RequestParams requestParams, AsyncHttpResponseHandler responseHander) {
        this.getClient().get(getFullURl(), responseHander);
    }

    public void post(RequestParams requestParams, AsyncHttpResponseHandler responseHander) {
        this.getClient().post(getFullURl(), requestParams, responseHander);
    }

    public AsyncHttpClient getClient() {
        this.client = new AsyncHttpClient();
        return this.client;
    }
}
