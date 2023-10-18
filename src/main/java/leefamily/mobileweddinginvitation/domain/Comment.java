package leefamily.mobileweddinginvitation.domain;

public class Comment {

    public Comment(String name, String content, String date, String password){
        this.name = name;
        this.password = password;
        this.content = content;
        this.date = date;
    }
    private String name;
    private  String content;
    private String date;
    private  String password;
    private Long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
