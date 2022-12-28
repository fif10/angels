package com.duduv.angels.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * angels : Created by Philippe on 27-12-22
 */
@Component
@ConfigurationProperties(prefix = "angels")
@Data
public class AngelConfig {

   private List<Game> games;
   private String  from;
   private String  secretKeeperEmail;
   private String  secretKeeperName;
   private String  secretKeeperMailSubject;
   private String  sendMailOnlyTo;



}
