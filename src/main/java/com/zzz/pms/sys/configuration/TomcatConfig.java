package com.zzz.pms.sys.configuration;

import org.apache.catalina.valves.RemoteAddrValve;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addEngineValves(getRemoteAddrValve());
        return tomcat;
    }

    private RemoteAddrValve getRemoteAddrValve() {
        RemoteAddrValve rs = new RemoteAddrValve();
        rs.setAllow("192.168.*.*");
        return rs;
    }
}
