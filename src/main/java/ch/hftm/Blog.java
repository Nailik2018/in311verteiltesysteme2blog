package ch.hftm;
import jakarta.json.bind.annotation.JsonbProperty;

public class Blog {
    @JsonbProperty("title")
    private String title;

    @JsonbProperty("content")
    private String content;

    public Blog() {
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

}
