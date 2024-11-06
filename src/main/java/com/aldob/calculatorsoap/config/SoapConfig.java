package com.aldob.calculatorsoap.config;

import com.aldob.calculatorsoap.client.SoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.aldob.wsdl");
        return marshaller;
    }

    @Bean
    public SoapClient getSoapClient(Jaxb2Marshaller marshaller){
        SoapClient soapClient = new SoapClient();
        soapClient.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);

        return soapClient;
    }
}