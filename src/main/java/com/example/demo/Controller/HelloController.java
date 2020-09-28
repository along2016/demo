package com.example.demo.Controller;

import com.example.demo.service.DateServiceFeignClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HelloController {

    /**  服务注册 */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate template;

    @Autowired
    private DateServiceFeignClientInterface dateServiceFeignClientInterface;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(){
        return template.getForObject("http://spring-cloud-provider/getUserInfo", String.class);
    }

    @GetMapping("/date")
    public String getDate() {
        return dateServiceFeignClientInterface.userInfo();
    }

    @GetMapping(value = "/getStudentInfo")
    public String getStudentInfo(){
        return "小明同学！";
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
