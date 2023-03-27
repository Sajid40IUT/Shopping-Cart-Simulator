package bean;

import java.io.Serializable;

public class productBean implements Serializable {
    private String  processor;
    private String name;
    private int ram;
    private Double price;


    public productBean() {
    }


    public productBean(String  processor, String name, int ram, Double price) {
        super();
        this.processor = processor;
        this.name = name;
        this.ram = ram;
        this.price = price;
    }

    public String getProcessor() {
        return processor;
    }

    public String getName() {
        return name;
    }

    public int getRam() {
        return ram;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "processor='" + processor + '\'' +
                ", name='" + name + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }
}
