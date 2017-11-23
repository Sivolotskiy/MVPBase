package com.chat.flyingchat.net.responce;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(prefix = "m")
public class Response {

    @SerializedName("success")
    private boolean mSuccess;
    @SerializedName("errors")
    private List<Error> mErrors;

    @Data
    @Accessors(prefix = "m")
    public class Error {

        @SerializedName("code")
        private String mCode;
        @SerializedName("message")
        private String mMessage;
    }
}