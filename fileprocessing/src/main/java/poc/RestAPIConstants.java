package poc;

public class RestAPIConstants
{
    public final static double AVERAGE_RADIUS_OF_EARTH = 6371;

    public final static String PIPELINE_PARAM_EXCEPTION = "Exception";
    public final static String PIPELINE_PARAM_REQUEST = "CurrentRequest";

    // Query parameters
    public static final String TOP_PARAM_NAME = "top";
    public static final String MODIFIED_SINCE_PARAM_NAME = "modifiedSince";
    public static final String SKIP_PARAM_NAME = "skip";
    public static final String CATEGORY_PARAM_NAME = "categorie";
    public static final String ORDER_BY_PARAM_NAME = "orderby";
    public static final String ORDER_DIR_PARAM_NAME = "orderdir";
    public static final String ID_PARAM_NAME = "id";
    public static final String RECIPE_TYPE_PARAM_NAME = "soort";
    public static final String RECIPE_SEASON_PARAM_NAME = "seizoen";
    public static final String RECIPE_KITCHEN_PARAM_NAME = "keuken";
    public static final String ACCESS_TOKEN_PARAM_NAME = "accesstoken";
    public static final String MEDIA_TYPE_PARAM_NAME = "mediaType";
    public static final String TYPE_PARAM_NAME = "type";
    public static final String USER_LATITUDE_PARAM_NAME = "lat";
    public static final String USER_LONGITUDE_PARAM_NAME = "long";
    public static final String XML_MEDIA_TYPE_PARAM_VALUE = "xml";
    public static final String JSON_MEDIA_TYPE_PARAM_VALUE = "json";
    public static final String LAST_MODIFICATION_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String ZONE_ID = "zoneId";
    public static final String JSON_CONTENT_TYPE = "application/json";
    public static final String HUB_API_KEY = "virtualstore.finder.microservice.api.key";
    public static final String HTTP_HEADER_X_API_KEY = "x-api-key";
    public static final String HUB_API_STORE_ID = "vStoreId";

    // Store locator pipeline parameters
    public final static String PIPELINE_PARAM_ALL_STORES = "AllStores";
    public final static String PIPELINE_PARAM_FILTERED_STORES = "FilteredStores";
    public final static String PIPELINE_PARAM_SORTED_STORES = "SortedStores";
    public final static String PIPELINE_PARAM_FILTERED_SORTED_STORES = "FilteredSortedStores";
    public final static String PIPELINE_PARAM_DISTANCE = "Distance";
    public final static String PIPELINE_PARAM_LATITUDE = "Latitude";
    public final static String PIPELINE_PARAM_LONGITUDE = "Longitude";
    public final static String PIPELINE_PARAM_COUNTRY_CODE = "CountryCode";
    public final static String PIPELINE_PARAM_POST_CODE = "PostCode";
    public final static String GOOGLE_DRIVE_RESULTS = "GoogleDriveResults";

    public final static String PIPELINE_PARAM_VIEWPORT_NE = "ViewportNorthEast";
    public final static String PIPELINE_PARAM_VIEWPORT_SW = "ViewportSouthWest";

    public final static String PIPELINE_PARAM_STORES = "Stores";
    public final static String PIPELINE_PARAM_ADDRESS = "Address";
    public final static String PIPELINE_PARAM_HOUSENUMBER = "HouseNumber";

    // Affiliate REST API pipeline parameters
    public final static String PIPELINE_PARAM_PROMOTIONS = "Promotions";
    public final static String PIPELINE_PARAM_RECIPES = "Recipes";
    public final static String PIPELINE_PARAM_TYPE = "Type";
    public final static String PIPELINE_PARAM_MODIFIED_SINCE = "ModifiedSince";
    public final static String PIPELINE_PARAM_ORDER_BY = "OrderBy";
    public final static String PIPELINE_PARAM_ORDER_DIR = "OrderDir";
    public final static String PIPELINE_PARAM_TOP = "Top";
    public final static String PIPELINE_PARAM_PRODUCT_SKUS = "SKUs";
    public final static String PIPELINE_PARAM_IDS = "IDs";
    public final static String PIPELINE_PARAM_CATEGORY_DISPLAY_NAME = "CategoryDisplayName";
    public final static String PIPELINE_PARAM_PRODUCTS = "Products";
    public final static String PIPELINE_PARAM_SEASON = "Season";
    public final static String PIPELINE_PARAM_KITCHEN = "Kitchen";
    public final static String PIPELINE_PARAM_REFINEMET = "Refinement";

    // Store custom attributes
    public final static String STORE_ATTRIBUTE_COMPLEX_NUMBER = "origSapStoreID";
    public final static String STORE_ATTRIBUTE_SAP_STORE_ID = "sapStoreID";
    public final static String STORE_ATTRIBUTE_DISPLAY_NAME = "displayName";
    public final static String STORE_ATTRIBUTE_LATITUDE = "latitude";
    public final static String STORE_ATTRIBUTE_LONGITUDE = "longitude";
    public final static String STORE_ATTRIBUTE_OPENING_DATE = "openingDate";
    public final static String STORE_ATTRIBUTE_CLOSING_DATE = "closingDate";
    public final static String STORE_ATTRIBUTE_HOMEDELIVERY_DATE = "homeDeliveryDate";
    public final static String STORE_ATTRIBUTE_COLLECTION_START_DATE = "collectionStartDate";
    public final static String STORE_ATTRIBUTE_COLLECTION_END_DATE = "collectionEndDate";
    public final static String STORE_ATTRIBUTE_HOME_DELIVERY_DATE = "homeDeliveryDate";
    public final static String STORE_ATTRIBUTE_STORE_TYPE = "location_type";
    public final static String STORE_ATTRIBUTE_STORE_PRICE_TYPE = "priceType";
    public final static String STORE_ATTRIBUTE_FACILITIES = "facilities";
    public final static String STORE_ATTRIBUTE_MON_THIS_OPEN = "monThisOpen";
    public final static String STORE_ATTRIBUTE_MON_THIS_CLOSE = "monThisClose";
    public final static String STORE_ATTRIBUTE_TUES_THIS_OPEN = "tuesThisOpen";
    public final static String STORE_ATTRIBUTE_TUES_THIS_CLOSE = "tuesThisClose";
    public final static String STORE_ATTRIBUTE_WEDS_THIS_OPEN = "wedsThisOpen";
    public final static String STORE_ATTRIBUTE_WEDS_THIS_CLOSE = "wedsThisClose";
    public final static String STORE_ATTRIBUTE_THURS_THIS_OPEN = "thursThisOpen";
    public final static String STORE_ATTRIBUTE_THURS_THIS_CLOSE = "thursThisClose";
    public final static String STORE_ATTRIBUTE_FRI_THIS_OPEN = "friThisOpen";
    public final static String STORE_ATTRIBUTE_FRI_THIS_CLOSE = "friThisClose";
    public final static String STORE_ATTRIBUTE_SAT_THIS_OPEN = "satThisOpen";
    public final static String STORE_ATTRIBUTE_SAT_THIS_CLOSE = "satThisClose";
    public final static String STORE_ATTRIBUTE_SUN_THIS_OPEN = "sunThisOpen";
    public final static String STORE_ATTRIBUTE_SUN_THIS_CLOSE = "sunThisClose";
    public final static String STORE_ATTRIBUTE_MON_NEXT_OPEN = "monNextOpen";
    public final static String STORE_ATTRIBUTE_MON_NEXT_CLOSE = "monNextClose";
    public final static String STORE_ATTRIBUTE_TUES_NEXT_OPEN = "tuesNextOpen";
    public final static String STORE_ATTRIBUTE_TUES_NEXT_CLOSE = "tuesNextClose";
    public final static String STORE_ATTRIBUTE_WEDS_NEXT_OPEN = "wedsNextOpen";
    public final static String STORE_ATTRIBUTE_WEDS_NEXT_CLOSE = "wedsNextClose";
    public final static String STORE_ATTRIBUTE_THURS_NEXT_OPEN = "thursNextOpen";
    public final static String STORE_ATTRIBUTE_THURS_NEXT_CLOSE = "thursNextClose";
    public final static String STORE_ATTRIBUTE_FRI_NEXT_OPEN = "friNextOpen";
    public final static String STORE_ATTRIBUTE_FRI_NEXT_CLOSE = "friNextClose";
    public final static String STORE_ATTRIBUTE_SAT_NEXT_OPEN = "satNextOpen";
    public final static String STORE_ATTRIBUTE_SAT_NEXT_CLOSE = "satNextClose";
    public final static String STORE_ATTRIBUTE_SUN_NEXT_OPEN = "sunNextOpen";
    public final static String STORE_ATTRIBUTE_SUN_NEXT_CLOSE = "sunNextClose";
    public final static String STORE_ATTRIBUTE_ENABLED = "enabled";
    public final static String STORE_ATTRIBUTE_HOMEDELIVERY_END_DATE = "homeDeliveryEndDate";

    // Recipe custom attributes
    public final static String RECIPE_ATTRIBUTE_PREPARATION_TIME = "prepTime";
    public final static String RECIPE_ATTRIBUTE_TYPE = "type";
    public final static String RECIPE_ATTRIBUTE_SOURCE = "source";
    public final static String RECIPE_ATTRIBUTE_SEASON = "season";
    public final static String RECIPE_ATTRIBUTE_OCCASION = "occasion";
    public final static String RECIPE_ATTRIBUTE_COURSE = "course";
    public final static String RECIPE_ATTRIBUTE_NUM_SERVED = "numServed";
    public final static String RECIPE_ATTRIBUTE_DISH = "dish";
    public final static String RECIPE_ATTRIBUTE_DIFFICULTY = "difficulty";
    public final static String RECIPE_ATTRIBUTE_VIDEO_URLS = "videoURLs";
    public final static String RECIPE_ATTRIBUTE_SOURCE_HALLO_JUMBO = "sourceHalloJumbo";
    public final static String RECIPE_SUB_STEP_DESCRIPTION = "subStepDescription";

    public final static String CARBOHYDRATES = "koolhydraten";
    public final static String CALORIES = "kcal";
    public final static String FAT = "vet";
    public final static String SATURATED_FATS = "verzadigde vetten";
    public final static String PROTEIN = "eiwit";

    public final static String HOUR_FORMAT = "HH:mm";
    public final static String CLOSED = "Gesloten";

    public final static String STORE_ATTRIBUTE_VALUE_STORE_TYPE_COLLECT_ONLY = "PuP";
    public final static String STORE_ATTRIBUTE_VALUE_STORE_TYPE_WITH_PUP = "SupermarktPuP";
    public final static String STORE_ATTRIBUTE_VALUE_STORE_TYPE_STORE_ONLY = "Supermarkt";

    public final static String RESULTS_ARRAY_GOOGLE_RESPONSE = "results";
    public final static String ADDRESS_COMPONENTS_GOOGLE_RESPONSE = "address_components";
    public final static String GEOMETRY_GOOGLE_RESPONSE = "geometry";
    public final static String LOCATION_GOOGLE_RESPONSE = "location";
    public final static String LATITUDE_GOOGLE_RESPONSE = "lat";
    public final static String LONGITUDE_GOOGLE_RESPONSE = "lng";
    public static final String SHORT_NAME_GOOGLE_RESPONSE = "short_name";
    public static final String LONG_NAME_GOOGLE_RESPONSE = "long_name";
    public static final String COUNTRY_GOOGLE_RESPONSE = "country";
    public static final String TYPES_GOOGLE_RESPONSE = "types";
    public static final String ROUTE_GOOGLE_RESPONSE = "route";
    public static final String LOCALITY_GOOGLE_RESPONSE = "locality";
    public static final String POSTAL_CODE_GOOGLE_RESPONSE = "postal_code";

    public final static String VIEWPORT_GOOGLE_RESPONSE = "viewport";
    public final static String NE_GOOGLE_RESPONSE = "northeast";
    public final static String SW_GOOGLE_RESPONSE = "southwest";

    public final static String GOOGLE_API_URL_CONFIG_KEY = "google.geocoding.api.url";
    public final static String GOOGLE_DRIVETIME_API_URL_CONFIG_KEY = "google.drivetime.api.url";
    public final static String PIPELET_CONFIG_PARAM_URL = "URL";
    public final static String ADDRESS_PLACEHOLDER = "<address>";
    public final static String ORIGINS_PLACEHOLDER = "<origins>";
    public final static String DESTINATIONS_PLACEHOLDER = "<destinations>";
    public static final String GOOGLE_API_CRYPTO_KEY_CONFIG_KEY = "google.geocoding.cryptoKey";

    public final static String CLOSEST_STORES_DEFAULT_COUNT = "5";
    public final static String CLOSEST_STORES_COUNT_CONFIG_KEY = "closest.stores.count";

    public final static String ORDER_DIR_ASC = "asc";
    public final static String ORDER_DIR_DESC = "desc";

    public final static String STORE_SORTABLE_FIELD_ID = "id";
    public final static String STORE_SORTABLE_PARAMETER_DISTANCE = "distance";

    public final static String PRODUCT_SORTABLE_PARAMETER_ID = "id";
    public final static String PRODUCT_SORTABLE_PARAMETER_TITLE = "titel";
    public final static String PRODUCT_SORTABLE_PARAMETER_VALID_FROM = "inAssortimentSinds";
    public final static String PRODUCT_SORTABLE_FIELD_SKU = "sku";
    public final static String PRODUCT_SORTABLE_FIELD_NAME = "name";
    public final static String PRODUCT_SORTABLE_FIELD_VALID_FROM = "validfrom";

    public final static String PRODUCT_ATTRIBUTE_EAN = "EAN";
    public final static String PRODUCT_ATTRIBUTE_TAGS = "tags";

    public final static String OPENING_TIMES_DATE_FORMAT = "yyyyMMdd";
    public final static String ACCESS_TOKEN = "accesstoken";

    public final static String STORE_DETAILS_PATH_CONFIG_KEY = "store.details.path";
    public final static String STORES_LINK_CONFIG_KEY = "stores.link";
    public final static String STORES_TTL_CONFIG_KEY = "stores.ttl";
    public final static String STORES_VERSION_CONFIG_KEY = "stores.version";

    public final static String PRODUCTS_LINK_CONFIG_KEY = "products.link";
    public final static String PRODUCTS_TTL_CONFIG_KEY = "products.ttl";
    public final static String PRODUCTS_VERSION_CONFIG_KEY = "products.version";
    public final static String PRODUCT_DETAILS_PAGE_PATH_CONFIG_KEY = "products.details.page.path";

    public final static String PROMOTIONS_LINK_CONFIG_KEY = "promotions.link";
    public final static String PROMOTIONS_TTL_CONFIG_KEY = "promotions.ttl";
    public final static String PROMOTIONS_VERSION_CONFIG_KEY = "promotions.version";

    public final static String RECIPES_LINK_CONFIG_KEY = "recipes.link";
    public final static String RECIPES_TTL_CONFIG_KEY = "recipes.ttl";
    public final static String RECIPES_VERSION_CONFIG_KEY = "recipes.version";

    public final static String DATE_FORMAT_CONFIG_KEY = "affiliate.apis.date.format";
    public final static String DATE_TIME_FORMAT_CONFIG_KEY = "affiliate.apis.datetime.format";

    public final static String AFFILIATE_API_IMAGE_TYPE = "Front";
    public final static String AFFILIATE_API_IMAGE_SIZE = "Medium";
    public final static String AFFILIATE_API_PROMOTION_BADGE_TYPE = "MediumBadge";
    public final static String AFFILIATE_API_PROMOTION_IMAGE_TYPE = "MediumImage";

    public final static String SKU_URL_PARAM = "SKU";

    public final static String HTTPS_PROTOCOL = "https";
    public final static String DEFAULT_HTTP_PORT = "80";
    public final static String DEFAULT_HTTPS_PORT = "443";

    public final static String PRODUCT_CUST_ATTR_WT_STEP_QTY_MULT = "weightStepQuantityMultiplier";

    public final static String MINIMUM_PLACEORDER_VALUE_LOCALIZED_KEY = "jmb.rest.placeorder.mov.error";
    public final static String MINIMUM_UPDATEORDER_VALUE_LOCALIZED_KEY = "jmb.rest.updateorder.mov.error";

    public final static String GROUP_RESTRICTION_VIOLATION_BASKET_LOCALIZED_KEY = "jmb.rest.grouprestriction.basket.violation.error";
    public final static String GROUP_RESTRICTION_VIOLATION_ADDRESS_LOCALIZED_KEY = "jmb.rest.grouprestriction.address.violation.error";

    public final static String PREFILL_API_URL_CONFIG_KEY = "jmb.microservice.prefill.api.url";
    public final static String SKU_PREFILL_API_RESPONSE = "sku";

    public final static String ROUTE_PLANNER_API_URL_CONFIG_KEY = "routeplanner.geocoding.api.url.be";
    public final static String ROUTEPLANNER_DRIVETIME_API_URL_CONFIG_KEY = "routeplanner.geocoding.microservice.drivetime.api.url";
    public final static String VIRTUAL_STORE_FINDER_API_URL_CONFIG_KEY = "virtualstore.finder.microservice.api.url";
    public final static String COUNTRY_CODE_PLACEHOLDER = "<countryCode>";
    public final static String PIPELINE_PARAM_STREET = "Street";
    public final static String STREET_PLACEHOLDER = "<street>";
    public final static String COUNTRY_CODE_NL = "NL";
    public final static String COUNTRY_CODE_BE = "BE";
    public static final String ROUTEPLANNER_LONGITUDE_PARAM_NAME = "lng";
    public static final String UTF8 = "UTF-8";
    public static final int RETRY_COUNT = 3;
    public static final int ORIGINS_LIMIT = 25;

}
