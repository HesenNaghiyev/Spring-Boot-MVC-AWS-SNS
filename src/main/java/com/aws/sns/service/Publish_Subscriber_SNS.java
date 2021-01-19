package com.aws.sns.service;


import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Publish_Subscriber_SNS {

    @Autowired
    AmazonSNSClient amazonSNSClient;

    String TOPIC = "arn:aws:sns:us-east-1:666171896107:AWSTESTINGSNS";


    public String addSubscriberToTopic(String email){
        SubscribeRequest  request = new SubscribeRequest(TOPIC, "email", email);
        amazonSNSClient.subscribe(request);
        return String.format("Confirmation request has sent to following email --> %s",email);
    }

    public String pushMessageToSNSTopic(String subject, String message){
        PublishRequest publishRequest = new PublishRequest(TOPIC,message,subject);
        amazonSNSClient.publish(publishRequest);
        return "Pushed The Message Successfully ";
    }

}
