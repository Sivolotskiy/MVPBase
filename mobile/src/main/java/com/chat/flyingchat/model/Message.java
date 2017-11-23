package com.chat.flyingchat.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message implements Serializable{

    private String id;

    private String name;

    private String text;

    private String time;
}
