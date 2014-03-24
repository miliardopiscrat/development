/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsn.jax.ws.server;

import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.Addressing;

/**
 *
 * @author mmigdal
 */
@WebService(serviceName = "MigiWebService")
//@Addressing(required = false, enabled = true)
public class MigiWebService {

    /**
     *
     * This is a sample web service operation
     */
    @Resource
    private WebServiceContext context;

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {

        try {

            MessageContext msgctx = context.getMessageContext();

            //System.out.println("MessageContext: " + msgctx.toString());

            HttpServletRequest req = (HttpServletRequest) msgctx
                    .get(MessageContext.SERVLET_REQUEST);


            //System.out.println("HttpServletRequest: " + req.toString());

            Enumeration<String> emums = req.getAttributeNames();
            while (emums.hasMoreElements()) {
                String attributeNameFromReq = emums.nextElement();

                System.out.println("AttributeNameFromReq: " + attributeNameFromReq);
            }

            Map<String, String[]> parametersMap = req.getParameterMap();
            System.out.println("parametersMap:" + parametersMap);

            Enumeration<String> servletContextAttributeNames = req.getServletContext().getAttributeNames();

            while (servletContextAttributeNames.hasMoreElements()) {
                String servletContextAttributeName = servletContextAttributeNames.nextElement();

                System.out.println("servletContextAttributeName: " + servletContextAttributeName);

            }






            try {
                System.out.println("Attempt to get certificates");
                X509Certificate[] certs = (X509Certificate[]) req.getAttribute("javax.servlet.request.X509Certificate");
                System.out.println("Attempt to get certificates done");
                if (certs != null && certs.length > 0) {
                    for (X509Certificate cert : certs) {
                        System.out.println("Cert: " + cert);

                    }
                } else {
                    System.out.println("No certificates");
                }
            } catch (Exception e) {
                System.out.println("Erorr coccured :" + e);
            }


            Object obj = req.getAttribute("javax.servlet.request.cipher_suite");

            System.out.println("XXX2 : " + obj);


            String cipherSuite = (String) req.getAttribute("javax.servlet.request.cipher_suite");

            if (cipherSuite != null) {
                
                 System.out.println("cipherSuite is not null: " );
                X509Certificate certChain[] = (X509Certificate[]) req.getAttribute("javax.servlet.request.X509Certificate");
                if (certChain != null) {
                    for (int i = 0; i < certChain.length; i++) {
                        System.out.println("Client Certificate [" + i + "] = "
                                + certChain[i].toString());
                    }
                }else{
                
                System.out.println("certChain is null");
                }
            }
            else{
                 System.out.println("cipherSuite is nul: " );
            }
    


            return "Hello " + txt + " !";

        } catch (Exception e) {
            System.out.println("erorr" + e);
        }

        return "Error occured";
    }
}
