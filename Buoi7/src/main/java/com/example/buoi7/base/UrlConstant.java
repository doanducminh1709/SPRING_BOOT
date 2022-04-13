package com.example.buoi7.base;
//có tác dụng khai báo sẵn các cái rã request mà mình muốntruyc cập đến
public class UrlConstant {
    public static  final class Province{
        private static final String PREFIX = "/provinces";
        public static final String PROVINCES = PREFIX;
        public static final String PROVINCE_WITH_CODE = PREFIX + "/{code}";
        public static final String DISTRICT_WITH_CODE_PROVINCE = PREFIX + "/{code}/districts";
        public static final String COLLECTION = PREFIX +"/province-collection";
    }
    public static  final class District{
        private static final String PREFIX = "/district";
        public static final String DISTRICTS = PREFIX;
        public static final String DISTRICT_WITH_cODE = PREFIX + "/{code}";
        public static final String COLLECTION = PREFIX +"/district-collection";
    }
}
