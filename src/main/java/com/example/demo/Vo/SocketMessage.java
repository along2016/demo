package com.example.demo.Vo;

public class SocketMessage {
    public String message;
    public String date;
    private static final Student student = new Student("wangjiliang", 32);

    public static void main(String[] args) {
        final Student st = SocketMessage.student;
        st.setAge(33);
        System.out.println(student.getAge());
    }
}
