package com.hit.baiktraweb.Base;

public class UrlContant {
    public static final class Darling {
        private static final String PREFIX = "/darlings";
        public static final String DARLINGS = PREFIX;
        public static final String DARLINGS_CURRENT = DARLINGS + "/current";
        public static final String DARLING_CURRENT_WITH_CODE = PREFIX + "/id";
        public static final String DARLINGS_WITH_ID = PREFIX + "/{id}";
        public static final String DARLINGS_WITH_ID_RESSES = DARLINGS_WITH_ID + "/add";
        public static final String DARLINGS_WITH_ID_AddRESSES =  DARLINGS_WITH_ID +"/addresses";

    }
    public static final class  ADDRESS {
        private static final String PREFIX = "/addresses";
        public static final String ADDRESS = PREFIX;
        public static final String ADDRESS_WITH_DARLING = PREFIX + "/{darlingId}";
        public static final String ADDRESS_WITH_DARLING_ID = ADDRESS_WITH_DARLING + "/{id}";
    }
}
