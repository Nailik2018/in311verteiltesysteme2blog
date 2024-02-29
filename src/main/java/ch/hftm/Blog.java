package ch.hftm;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Blog {

    @Id
    @GeneratedValue
    @JsonbTransient
    private long id;

    private String title;

    private String content;

    private boolean valid = false;

    public Blog() {
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
        this.valid = false;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return this.content;
    }

    public boolean getValid(){
        return valid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setValid(boolean valid){
        this.valid = valid;
    }
}