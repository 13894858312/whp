package com.back.whp.util;

import java.io.Serializable;

/**
 * 用户令牌
 */
public class Token implements Serializable {

    private String signature;
    private long timestamp;

    public Token(String signature, long timestamp) {
        if (signature == null) {
            throw new IllegalArgumentException("signature can not be null");
        }
        this.signature = signature;
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public int hashCode() {
        return signature.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Token && ((Token) obj).signature.equals(this.signature);
    }

}
