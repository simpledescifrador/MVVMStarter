package com.esys.mvvmstarter.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Utility {

    /**
     * Hides the on-screen keyboard.
     *
     * @param activity current activity
     */
    public static void hideKeyboard(Activity activity, View view) {
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static String checkNullToBlank(String value) {
        if (value != null && !value.equalsIgnoreCase("null")) {
            return value;
        }
        return "";
    }

    public static Integer checkNullToBlankInt(Integer value) {
        if (value != null) {
            return value;
        }
        return 0;
    }

    public static String changeToAsterisk(String text) {
        String change_text;
        change_text = text + "$";
        StringBuilder processedText = new StringBuilder();
        int ptr = 0;
        if (change_text.length() - 1 >= 3) {
            while (change_text.charAt(ptr) != '$') {
                if (ptr < (change_text.length() - 4)) {
                    processedText.append("*");
                } else {
                    processedText.append(change_text.charAt(ptr));
                }
                ptr++;
            }
            return processedText.toString();
        } else {
            return text;
        }
    }

    public static long getTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * This function check if all editText passed have a text
     */
    public static boolean isCompleteFields(List<EditText> editTexts) {
        boolean isCompleteFields = true;

        for (EditText et : editTexts) {
            if (et.getText().toString().isEmpty()) {
                isCompleteFields = false;
            }
        }
        return isCompleteFields;
    }

    @SuppressLint("SimpleDateFormat")
    public static String formatDate(Date date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @SuppressLint("SimpleDateFormat")
    public static String formatDateTime(Date date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @SuppressLint("SimpleDateFormat")
    public static String formatDateTime(Date date, String format) {
        try {
            return new SimpleDateFormat(format).format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Date stringToDate(String date) {
        @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date toDate = new Date();
        try {
            toDate = formatter.parse(date);
            return toDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toDate;
    }

    public static Date stringToDateTime(String date) {
        @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date toDate = new Date();
        try {
            toDate = formatter.parse(date);
            return toDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toDate;
    }

    public static String getStringCurrentDate() {
        @SuppressLint("SimpleDateFormat") String dateStamp = new SimpleDateFormat("yyyy-MM-dd")
                .format(Calendar.getInstance().getTime());
        return dateStamp;
    }

    public static String getStringCurrentDateTime() {
        @SuppressLint("SimpleDateFormat") String dateStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(Calendar.getInstance().getTime());
        return dateStamp;
    }

    public static String getStringCurrentTime() {
        @SuppressLint("SimpleDateFormat") String dateStamp = new SimpleDateFormat("HH:mm")
                .format(Calendar.getInstance().getTime());
        return dateStamp;
    }

    /**
     * The recommended conversion method
     * to avoid null exception
     *
     * @param data should be convertable to double
     * @return 0 if the data is invalid or the double value of data.
     */
    public static double stringToDouble(String data) {
        try {
            return Double.parseDouble(data);
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * The recommended conversion method
     * to avoid null exception
     *
     * @param data should be convertable to int
     * @return 0 if the data is invalid or the int value of data.
     */
    public static int stringToInt(String data) {
        try {
            return Integer.parseInt(data);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static boolean hasInternet(Context context) {
        boolean isConnectedToWifi = false;
        boolean isConnectedToMobile = false;
        boolean isConnectedToEthernet = false;

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI")) {
                if (ni.isConnected()) {
                    isConnectedToWifi = true;
                }
            }
            if (ni.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (ni.isConnected()) {
                    isConnectedToMobile = true;
                }
            }
            if (ni.getTypeName().equalsIgnoreCase("ETHERNET")) {
                if (ni.isConnected()) {
                    isConnectedToEthernet = true;
                }
            }
        }
        return isConnectedToWifi || isConnectedToMobile || isConnectedToEthernet;
    }
}
