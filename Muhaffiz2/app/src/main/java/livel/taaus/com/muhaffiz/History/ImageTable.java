package livel.taaus.com.muhaffiz.History;

public class ImageTable {

    String name;
    String url;
    String email;

    public ImageTable(String name, String url, String email) {
        this.name = name;
        this.url = url;
        this.email=email;
    }

    public ImageTable() {
    }

    public String getName() {
        return name;
    }

    public void setEmail2(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }
      public String getEmail(){
        return email;
      }
    public void setUrl(String url) {
        this.url = url;
    }
}
