package com.hg.sb.act.endpoint;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomEndpoint implements Endpoint<List<String>> {

    // 访问URL为这个值
    public String getId() {
        return "customEndpoint";
    }
 
    public boolean isEnabled() {
        return true;
    }
 
    public boolean isSensitive() {
        return true;
    }
 
    public List<String> invoke() {
        // Custom logic to build the output
        List<String> messages = new ArrayList<String>();
        messages.add("This is message 1");
        messages.add("This is message 2");
        return messages;
    }
}