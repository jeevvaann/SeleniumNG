package com.cucumberFramework;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Base64;
import java.util.Map;

public class APIUtils {

    private Logger logger = LogManager.getLogger(this.getClass());
    private Response response;
    private ValidatableResponse json;
    //private RequestSpecification request;


    /*
     * method is used to set input parameters to the request
     */
    public RequestSpecification inputParameters(RequestSpecification request, Map<String, String> parameters) {
        try {
            request = RestAssured.given().params(parameters);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return request;
    }

    /*
     * method is used to add cookies to the request
     */
    public RequestSpecification addCookies(RequestSpecification request, Map<String, String> cookies) {
        try {
            request = RestAssured.given().cookies(cookies);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return request;
    }

    /*
     * method is used to add headers to the request
     */
    public RequestSpecification addHeaders(RequestSpecification request, Headers headers) {
        try {

            request = RestAssured.given().headers(headers);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return request;
    }

    public Header addAuthentication(String username, String password) {
        Header author = null;
        try {
            author = new Header("Authorization",
                    "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return author;
    }

    /*
     * method to pass body to the request
     */
    public RequestSpecification inputRequestBody(RequestSpecification request, String jsonFile) {
        try {

            request = RestAssured.given().body(jsonFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return request;
    }

    /*
     * send get request and retrieve the response
     */
    public Response getRequest(RequestSpecification request, String endURL, String... pathParams) {
        try {

            response = request.when().get(endURL + pathParams);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public int getStatusCode(Response response) {
        return response.statusCode();
    }

    /*public  int getBody(Response response) {
        return response.get;
    }*/

    /*
     * send post request and retrieve the response
     */
    public Response postRequest(RequestSpecification request, String endURL) {
        try {

            response = RestAssured.when().post(endURL).then().extract().response();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }


    /*
     * send put request and retrieve the response
     */
    public Response putRequest(RequestSpecification request, String endURL, String... pathParams) {
        try {

            response = RestAssured.when().put(endURL + pathParams).then().extract().response();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    /*
     * send delete request and retrieve the response
     */
    public Response deleteRequest(RequestSpecification request, String endURL, String... pathParams) {
        try {

            response = RestAssured.when().delete(endURL + pathParams).then().extract().response();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

}
