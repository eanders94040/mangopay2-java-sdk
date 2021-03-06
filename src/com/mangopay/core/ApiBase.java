package com.mangopay.core;

import com.mangopay.MangoPayApi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base class for all Api classes.
 */
public abstract class ApiBase {

    /**
     * Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    protected MangoPayApi _root;

    /**
     * Array with REST URL and request type.
     */
    private Map<String, String[]> methods = new HashMap<String, String[]>(){{

        put("authentication_base", new String[] { "/api/clients/", RequestType.POST });
        put("authentication_oauth", new String[] { "/oauth/token", RequestType.POST });
        
        put("events_all", new String[] { "/events", RequestType.GET });
        put("events_gethookcallbacks", new String[] { "/events/%s/hook-callbacks", RequestType.GET });
        
        put("hooks_create", new String[] { "/hooks", RequestType.POST });
        put("hooks_all", new String[] { "/hooks", RequestType.GET });
        put("hooks_get", new String[] { "/hooks/%s", RequestType.GET });
        put("hooks_save", new String[] { "/hooks/%s", RequestType.PUT });
        
        put("info_get", new String[] { "/info", RequestType.GET });
        put("info_getfeewallets", new String[] { "/info/fee-wallets", RequestType.GET });
        put("info_getmeansofpayment", new String[] { "/info/means-of-payment", RequestType.GET });
     
        put("cardregistration_create", new String[] { "/cardregistrations", RequestType.POST });
        put("cardregistration_get", new String[] { "/cardregistrations/%s", RequestType.GET });
        put("cardregistration_save", new String[] { "/cardregistrations/%s", RequestType.PUT });
        
        put("preauthorization_create", new String[] { "/preauthorizations/card/direct", RequestType.POST });
        put("preauthorization_get", new String[] { "/preauthorizations/%s", RequestType.GET });
        put("preauthorization_save", new String[] { "/preauthorizations/%s", RequestType.PUT });
        
        put("card_get", new String[] { "/cards/%s", RequestType.GET });
        put("card_save", new String[] { "/cards/%s", RequestType.PUT });
        
        // pay ins URLs
        put("payins_card-web_create", new String[] { "/payins/card/web/", RequestType.POST });
        put("payins_card-direct_create", new String[] { "/payins/card/direct/", RequestType.POST });
        put("payins_card-preauthorized_create", new String[] { "/payins/card/preauthorized/", RequestType.POST });
        put("payins_card-recurrentexecution_create", new String[] { "/payins/card/recurrent-pay-in-execution/", RequestType.POST });
        
        put("payins_registeredcard-web_create", new String[] { "/payins/registered-card/web/", RequestType.POST });
        put("payins_registeredcard-direct_create", new String[] { "/payins/registered-card/direct/", RequestType.POST });
        put("payins_registeredcard-preauthorized_create", new String[] { "/payins/registered-card/preauthorized/", RequestType.POST });
        put("payins_registeredcard-recurrentexecution_create", new String[] { "/payins/registered-card/recurrent-pay-in-execution/", RequestType.POST });
        
        put("payins_bankwirepayin-web_create", new String[] { "/payins/bankwire/web/", RequestType.POST });
        put("payins_bankwirepayin-direct_create", new String[] { "/payins/bankwire/direct/", RequestType.POST });
        put("payins_bankwirepayin-preauthorized_create", new String[] { "/payins/bankwire/preauthorized/", RequestType.POST });
        put("payins_bankwirepayin-recurrentexecution_create", new String[] { "/payins/bankwire/recurrent-pay-in-execution/", RequestType.POST });
        
        put("payins_directcredit-web_create", new String[] { "/payins/direct-credit/web/", RequestType.POST });
        put("payins_directcredit-direct_create", new String[] { "/payins/direct-credit/direct/", RequestType.POST });
        put("payins_directcredit-preauthorized_create", new String[] { "/payins/direct-credit/preauthorized/", RequestType.POST });
        put("payins_directcredit-recurrentexecution_create", new String[] { "/payins/direct-credit/recurrent-pay-in-execution/", RequestType.POST });
        put("payins_get", new String[] { "/payins/%s", RequestType.GET });
        put("payins_createrefunds", new String[] { "/payins/%s/refunds", RequestType.POST });
        
        put("payins_preauthorized-direct_create", new String[] { "/payins/preauthorized/direct/", RequestType.POST });
        put("payins_bankwire-direct_create", new String[] { "/payins/bankwire/direct/", RequestType.POST });
        
        put("payouts_bankwire_create", new String[] { "/payouts/bankwire/", RequestType.POST });
        put("payouts_merchantexpense_create", new String[] { "/payouts/merchant-expense/", RequestType.POST });
        put("payouts_amazongiftcard_create", new String[] { "/payouts/amazon-giftcard/", RequestType.POST });
        put("payouts_get", new String[] { "/payouts/%s", RequestType.GET });
        put("payouts_createrefunds", new String[] { "/payouts/%s/refunds", RequestType.POST });
        put("payouts_getrefunds", new String[] { "/payouts/%s/refunds", RequestType.GET });
        
        put("reccurringpayinorders_create", new String[] { "/reccurring-pay-in-orders", RequestType.POST });
        put("reccurringpayinorders_get", new String[] { "/reccurring-pay-in-orders/%s", RequestType.GET });
        put("reccurringpayinorders_gettransactions", new String[] { "/reccurring-pay-in-orders/%s/transactions", RequestType.GET });
        
        put("refunds_get", new String[] { "/refunds/%s", RequestType.GET });
        
        put("repudiations_get", new String[] { "/repudiations/%s", RequestType.GET });
        
        put("transfers_create", new String[] { "/transfers/", RequestType.POST });
        put("transfers_get", new String[] { "/transfers/%s", RequestType.GET });
        put("transfers_getrefunds", new String[] { "/transfers/%s/refunds", RequestType.GET });
        put("transfers_createrefunds", new String[] { "/transfers/%s/refunds", RequestType.POST });
        
        put("users_createnaturals", new String[] { "/users/natural", RequestType.POST });
        put("users_createlegals", new String[] { "/users/legal", RequestType.POST });
        put("users_createkycrequests", new String[] { "/users/%s/KYC/requests", RequestType.POST });
        
        put("users_createbankaccounts_iban", new String[] { "/users/%s/bankaccounts/iban", RequestType.POST });
        put("users_createbankaccounts_gb", new String[] { "/users/%s/bankaccounts/gb", RequestType.POST });
        put("users_createbankaccounts_us", new String[] { "/users/%s/bankaccounts/us", RequestType.POST });
        put("users_createbankaccounts_ca", new String[] { "/users/%s/bankaccounts/ca", RequestType.POST });
        put("users_createbankaccounts_other", new String[] { "/users/%s/bankaccounts/other", RequestType.POST });
        
        put("users_all", new String[] { "/users", RequestType.GET });
        put("users_allkyc", new String[] { "/users/%s/KYC", RequestType.GET });
        put("users_allkycrequests", new String[] { "/users/%s/KYC/requests", RequestType.GET });
        put("users_allwallets", new String[] { "/users/%s/wallets", RequestType.GET });
        put("users_allbankaccount", new String[] { "/users/%s/bankaccounts", RequestType.GET });
        put("users_allpaymentcards", new String[] { "/users/%s/payment-cards", RequestType.GET });
        put("users_get", new String[] { "/users/%s", RequestType.GET });
        put("users_getnaturals", new String[] { "/users/natural/%s", RequestType.GET });
        put("users_getlegals", new String[] { "/users/legal/%s", RequestType.GET });
        put("users_getkycrequests", new String[] { "/users/%s/KYC/requests/%s", RequestType.GET });
        put("users_getproofofidentity", new String[] { "/users/%s/ProofOfIdentity", RequestType.GET });
        put("users_getproofofaddress", new String[] { "/users/%s/ProofOfAddress", RequestType.GET });
        put("users_getproofofregistration", new String[] { "/users/%s/ProofOfRegistration", RequestType.GET });
        put("users_getshareholderdeclaration", new String[] { "/users/%s/ShareholderDeclaration", RequestType.GET });
        put("users_getbankaccount", new String[] { "/users/%s/bankaccounts/%s", RequestType.GET });
        put("users_getpaymentcards", new String[] { "/users/%s/payment-cards/%s", RequestType.GET });
        put("users_savenaturals", new String[] { "/users/natural/%s", RequestType.PUT });
        put("users_savelegals", new String[] { "/users/legal/%s", RequestType.PUT });
        
        put("users_allcards", new String[] { "/users/%s/cards", RequestType.GET });
        put("users_alltransactions", new String[] { "/users/%s/transactions", RequestType.GET });
        
        put("users_createkycdocument", new String[] { "/users/%s/KYC/documents", RequestType.POST });
        put("users_getkycdocument", new String[] { "/users/%s/KYC/documents/%s", RequestType.GET });
        put("users_savekycdocument", new String[] { "/users/%s/KYC/documents/%s", RequestType.PUT });
        put("users_createkycpage", new String[] { "/users/%s/KYC/documents/%s/pages", RequestType.POST });
        
        put("wallets_create", new String[] { "/wallets", RequestType.POST });
        put("wallets_allrecurringpayinorders", new String[] { "/wallets/%s/recurring-pay-in-orders", RequestType.GET });
        put("wallets_alltransactions", new String[] { "/wallets/%s/transactions", RequestType.GET });
        put("wallets_alltransactionspage", new String[] { "/wallets/%s/transactions/pages/%s", RequestType.GET });
        put("wallets_get", new String[] { "/wallets/%s", RequestType.GET });
        put("wallets_save", new String[] { "/wallets/%s", RequestType.PUT });
        
    }};
    
    /**
     * Creates new API instance.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiBase(MangoPayApi root) {
        _root = root;
    }

    /**
     * Gets the URL of REST Mango Pay API.
     * @param key   The method key to get URL of.
     * @return      The URL string of given method.
     */
    protected String getRequestUrl(String key) throws Exception {
        String result = "";
        try {
            result = this.methods.get(key)[0];
        } catch (Exception ex) {
            throw new Exception("Unknown method key: " + key);
        }
        return result;
    }
    
    /**
     * Gets the HTTP request verb.
     * @param key   The method key.
     * @return      One of the HTTP verbs: GET, PUT or POST.
     */
    protected String getRequestType(String key) {
        return this.methods.get(key)[1];
    }
    
    /**
     * Creates the Dto instance.
     * @param <T>               Type on behalf of which the request is being called.
     * @param classOfT          Type on behalf of which the request is being called.
     * @param methodKey         Relevant method key.
     * @param entity            Dto instance that is going to be sent.
     * @param entityId          Entity identifier.
     * @param secondEntityId    Second entity identifier.
     * @return                  The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto> T createObject(Class<T> classOfT, String methodKey, T entity, String entityId, String secondEntityId) throws Exception {
        
        String urlMethod;
        
        if (entityId.length() == 0)
            urlMethod = this.getRequestUrl(methodKey);
        else if (secondEntityId.length() == 0)
            urlMethod = String.format(this.getRequestUrl(methodKey), entityId);
        else
            urlMethod = String.format(this.getRequestUrl(methodKey), entityId, secondEntityId);
        
        RestTool rest = new RestTool(this._root, true);
        T result = rest.request(classOfT, urlMethod, this.getRequestType(methodKey), null, null, entity);
        
        return result;
        
    }
    
    /**
     * Creates the Dto instance.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param methodKey     Relevant method key.
     * @param entity        Dto instance that is going to be sent.
     * @param entityId      Entity identifier.
     * @return              The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto> T createObject(Class<T> classOfT, String methodKey, T entity, String entityId) throws Exception {
        return createObject(classOfT, methodKey, entity, entityId, "");
    }
    
    /**
     * Creates the Dto instance.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param methodKey     Relevant method key.
     * @param entity        Dto instance that is going to be sent.
     * @return              The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto> T createObject(Class<T> classOfT, String methodKey, T entity) throws Exception {
        return createObject(classOfT, methodKey, entity, "");
    }
    
    /**
     * Gets the Dto instance from API.
     * @param <T>               Type on behalf of which the request is being called.
     * @param classOfT          Type on behalf of which the request is being called.
     * @param methodKey         Relevant method key.
     * @param entityId          Entity identifier.
     * @param secondEntityId    Entity identifier for the second entity.
     * @return                  The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto> T getObject(Class<T> classOfT, String methodKey, String entityId, String secondEntityId) throws Exception {
        
        String urlMethod = String.format(this.getRequestUrl(methodKey), entityId, secondEntityId);
        
        RestTool rest = new RestTool(this._root, true);
        T response = rest.request(classOfT, urlMethod, this.getRequestType(methodKey));
        
        return response;
    }
    
    /**
     * Gets the Dto instance from API.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param methodKey     Relevant method key.
     * @param entityId      Entity identifier.
     * @return              The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto> T getObject(Class<T> classOfT, String methodKey, String entityId) throws Exception {
        return getObject(classOfT, methodKey, entityId, "");
    }
    
    /**
     * Gets the array of Dto instances from API.
     * @param <T>                   Type on behalf of which the request is being called.
     * @param classOfT              Type on behalf of which the request is being called.
     * @param methodKey             Relevant method key.
     * @param pagination            Pagination object.
     * @param entityId              Entity identifier.
     * @param additionalUrlParams   Collection of key-value pairs of request parameters.
     * @return                      The array of Dto instances returned from API.
     * @throws Exception
     */
    protected <T extends Dto> List<T> getList(Class<T[]> classOfT, Class<T> classOfTItem, String methodKey, Pagination pagination, String entityId, Map<String, String> additionalUrlParams) throws Exception {
        
        String urlMethod = "";
        
        if (entityId.length() > 0)
            urlMethod = String.format(this.getRequestUrl(methodKey), entityId);
        else
            urlMethod = this.getRequestUrl(methodKey);
        
        if (pagination == null) {
            pagination = new Pagination();
        }
        
        RestTool rest = new RestTool(this._root, true);
        
        return rest.requestList(classOfT, classOfTItem, urlMethod, this.getRequestType(methodKey), null, pagination, additionalUrlParams);
                
    }
    
    /**
     * Gets the array of Dto instances from API.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param methodKey     Relevant method key.
     * @param pagination    Pagination object.
     * @param entityId      Entity identifier.
     * @return              The array of Dto instances returned from API.
     * @throws Exception
     */
    protected <T extends Dto> List<T> getList(Class<T[]> classOfT, Class<T> classOfTItem, String methodKey, Pagination pagination, String entityId) throws Exception {
        return getList(classOfT, classOfTItem, methodKey, pagination, entityId, null);
    }
    
    /**
     * Gets the array of Dto instances from API.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param methodKey     Relevant method key.
     * @param pagination    Pagination object.
     * @return              The array of Dto instances returned from API.
     * @throws Exception
     */
    protected <T extends Dto> List<T> getList(Class<T[]> classOfT, Class<T> classOfTItem, String methodKey, Pagination pagination) throws Exception {
        return getList(classOfT, classOfTItem, methodKey, pagination, "");
    }
    
    /**
     * Saves the Dto instance.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param methodKey     Relevant method key.
     * @param entity        Dto instance that is going to be sent.
     * @return              The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto> T updateObject(Class<T> classOfT, String methodKey, T entity) throws Exception {
        return updateObject(classOfT, methodKey, entity, "");
    }
    
    /**
     * Saves the Dto instance.
     * @param <T>           Type on behalf of which the request is being called.
     * @param classOfT      Type on behalf of which the request is being called.
     * @param methodKey     Relevant method key.
     * @param entity        Dto instance that is going to be sent.
     * @param entityId      Entity identifier.
     * @return              The Dto instance returned from API.
     * @throws Exception
     */
    protected <T extends Dto> T updateObject(Class<T> classOfT, String methodKey, T entity, String entityId) throws Exception {
        
        if (entity instanceof EntityBase) {
            
            String urlMethod;
        
            if (entityId.length() == 0)
                urlMethod = String.format(this.getRequestUrl(methodKey), ((EntityBase)entity).Id);
            else {
                String ggg = this.getRequestUrl(methodKey);
                urlMethod = String.format(this.getRequestUrl(methodKey), entityId, ((EntityBase)entity).Id);
            }
                

            RestTool rest = new RestTool(this._root, true);
            return rest.request(classOfT, urlMethod, this.getRequestType(methodKey), null, null, entity);
        } else {
            return null;
        }
    }
}
