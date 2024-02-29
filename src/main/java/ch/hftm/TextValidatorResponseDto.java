package ch.hftm;

public class TextValidatorResponseDto {

    private long sourceId;
    private String text;
    private boolean valid;

//    public TextValidatorResponseDto(String text, boolean isValid) {
//        this.text = text;
//        this.isValid = isValid;
//    }

    public TextValidatorResponseDto() {
    }

    public TextValidatorResponseDto(String text, long sourceId) {
        this.text = text;
        this.sourceId = sourceId;
    }

    public long getId() {
        return sourceId;
    }

    public void setId(long id) {
        this.sourceId = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
