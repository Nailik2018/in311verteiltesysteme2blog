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

    private boolean isValid = false;

    public Blog() {
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
        isValid = false;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return this.content;
    }

    public boolean getIsValid(){
        return isValid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setIsValid(boolean isValid){
        this.isValid = isValid;
    }
}