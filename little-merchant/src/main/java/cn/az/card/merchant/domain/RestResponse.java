package cn.az.card.merchant.domain;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * The rest response.
 *
 * @author az
 * @date 2019/9/15
 */
public class RestResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = 6749600779320205323L;

    private RestResponse() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static RestResponse init() {
        return new RestResponse();
    }

    /**
     * Ok rest response.
     *
     * @return the rest response
     */
    public RestResponse ok() {
        return this.code(HttpStatus.OK).message(HttpStatus.OK.getReasonPhrase());
    }

    /**
     * Code rest response.
     *
     * @param code errCode
     * @return the rest response
     */
    public RestResponse code(HttpStatus code) {
        return this.put("code", code.value());
    }

    /**
     * Code object.
     *
     * @return the object
     */
    public Object code() {
        return this.getOrDefault("code", "no code for you");
    }

    /**
     * message object.
     *
     * @param message the message
     * @return the object
     */
    public RestResponse message(String message) {
        return this.put("message", message);
    }

    /**
     * message object.
     *
     * @return the object
     */
    public Object message() {
        return this.getOrDefault("message", "no message for you");
    }

    /**
     * message object.
     *
     * @param data the data
     * @return the object
     */
    public RestResponse data(Object data) {
        return this.put("data", data);
    }

    /**
     * message object.
     *
     * @return the object
     */
    public Object data() {
        return this.getOrDefault("data", "no data for you");
    }

    @Override
    public RestResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
