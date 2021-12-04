package com.kanwar.micro.limitservices.configration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-services")
public class limitConfigration {
  private int minimun;
  private int maximun;
public int getMinimun() {
	return minimun;
}
public void setMinimun(int minmun) {
	this.minimun = minmun;
}
public int getMaximun() {
	return maximun;
}
public void setMaximun(int maxmun) {
	this.maximun = maxmun;
}

}
