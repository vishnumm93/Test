package vishnu.in.test;

/**
 * Created by vishn on 5/20/2017.
 */


public class Songs {
    private String title, time, description,url;

    public Songs() {
    }


    public Songs(String title, String time, String description, String url) {
        this.title = title;
        this.time = time;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}