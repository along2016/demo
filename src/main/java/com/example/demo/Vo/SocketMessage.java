package com.example.demo.Vo;


import com.netflix.zuul.context.RequestContext;

public class SocketMessage {
    public String message;
    public String date;
    private static final Student student = new Student("wangjiliang", 32);

    public static void main(String[] args) {
        final Student st = SocketMessage.student;
        st.setAge(33);
        System.out.println(student.getAge());
        RequestContext ctx = RequestContext.getCurrentContext();

//        RibbonRoutingFilter
//        StringBuilder
//        AbstractNameValueGatewayFilterFactory
//        HttpHeaders
//        HttpStatus
//        Method
    }
}
