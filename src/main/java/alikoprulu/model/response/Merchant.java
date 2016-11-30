package alikoprulu.model.response;

/**
 * Created by Ali on 30.11.2016.
 */
public class Merchant {

    private Integer id;

    private String name;

    public Merchant(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
