package com.example.btvnb7.Base;

public class Constant {
    public static final class Darling{
        private static final String PREFIX = "/darlings";
        public static final String DARLINGS = PREFIX;
        public static final String CURRENT = DARLINGS + "/current";
        public static final String DARLING_BY_ID = PREFIX + "/{id}";
        public static final String DARLING_BY_ID_ADDRESSES = DARLING_BY_ID + "/addresses";
    }
    public static final class Address{
        private static final String PREFIX = "/addresses";
        public static final String POST_ADDRESS = PREFIX + "/{darlingId}";
        public static final String ADDRESSES_BY_DARLING_ID = PREFIX + "/{darlingId}/{id}";
    }

}
