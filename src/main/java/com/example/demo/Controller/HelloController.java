package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    /**  服务注册 */
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(){
        return "Hello World!";
    }

    @RequestMapping("/registered")
    public String getRegistered(){
        List<ServiceInstance> list = discoveryClient.getInstances("STORES");
//        System.out.println(discoveryClient.getLocalServiceInstance());
        System.out.println("discoveryClient.getServices().size() = " + discoveryClient.getServices().size());

        for( String s :  discoveryClient.getServices()){
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
            for(ServiceInstance si : serviceInstances){
                System.out.println("services:" + s + ":getHost()=" + si.getHost());
                System.out.println("services:" + s + ":getPort()=" + si.getPort());
                System.out.println("services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("services:" + s + ":getUri()=" + si.getUri());
                System.out.println("services:" + s + ":getMetadata()=" + si.getMetadata());
            }

        }

        System.out.println(list.size());
        if (list != null && list.size() > 0 ) {
            System.out.println( list.get(0).getUri()  );
        }
        return null;
    }

}
