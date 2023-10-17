package leefamily.mobileweddinginvitation.domain;

public class Comment {
//    아...비밀번호를 추가해서 나중에 적합성을 검사해야해...그리고 service나 controller쪽에 유효성검사도..!
    private String name;
    private  String content;
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
