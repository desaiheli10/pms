package com.example.common.pms;

/**
 * Created by JigarSoni on 9/25/2016.
 */
public class AppConfig {
    // Server user login url
    //StringBuilder str = new StringBuilder("http://192.168.43.207");
    static String IP_CONST = "http://192.168.2.6:80";
    public static String URL_LOGIN = IP_CONST + "/android_connect/login.php";
    public static String URL_ALL_PRODUCT = IP_CONST + "/android_connect/get_all_products.php";
    public static String url_create_product = IP_CONST + "/android_connect/add_company.php";
    public static String URL_ADD_DRIVE = IP_CONST + "/android_connect/add_drive.php";
    public static String URL_GET_DRIVES = IP_CONST + "/android_connect/get_all_drives.php";
    // Server user register url
   // public static String URL_DRIVE = "http://192.168.0.102/android_login_api/register.php";
}
