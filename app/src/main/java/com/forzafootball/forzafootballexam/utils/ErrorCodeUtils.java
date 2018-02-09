package com.forzafootball.forzafootballexam.utils;

/**
 * Util class to determine Error Codes
 * Created by e.castellanos on 08/02/2018.
 */

public class ErrorCodeUtils {
    public static String getErrorMessageByErrorCode(int errorCode) {
        String errorResponseText = "Error " + errorCode + ": ";
        switch (errorCode) {
        case 400:
            errorResponseText += "Bad Request";
            break;
        case 401:
            errorResponseText += "Unauthorized";
            break;
        case 403:
            errorResponseText += "Forbidden";
            break;
        case 404:
            errorResponseText += "Url Not Found";
            break;
        case 408:
            errorResponseText += "Request Timeout";
            break;
        case 500:
            errorResponseText += "Internal Server Error";
            break;
        case 501:
            errorResponseText += "Not Implemented";
            break;
        case 502:
            errorResponseText += "Bad Gateway";
            break;
        case 503:
            errorResponseText += "Service Unavailable";
            break;
        case 504:
            errorResponseText += "Gateway timeout";
            break;
        default:
            errorResponseText += "Unrecognized Error";
            break;
        }
        return errorResponseText;
    }
}
