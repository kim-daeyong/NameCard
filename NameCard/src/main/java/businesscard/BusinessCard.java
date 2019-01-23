package businesscard;

public class BusinessCard {

    private int id;
    private String name;
    private String company;
    private String phone;


    public BusinessCard() {
    }

    public BusinessCard(int id, String name, String company, String phone) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "BusinessCard{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", phone=" + phone +
                '}';
    }
}


