import java.util.TreeSet;

public class BrandManagement {
    private TreeSet<Brand> brandSet;

    public BrandManagement() {
        this.brandSet = new TreeSet<>();
        initializeBrands();
    }

    public void initializeBrands() {
        brandSet.add(new Brand(1, "Samsung "));
        brandSet.add(new Brand(2, "Lenovo  "));
        brandSet.add(new Brand(3, "Apple   "));
        brandSet.add(new Brand(4, "Huawei  "));
        brandSet.add(new Brand(5, "Casper  "));
        brandSet.add(new Brand(6, "Asus    "));
        brandSet.add(new Brand(7, "Hp      "));
        brandSet.add(new Brand(8, "Xiaomi  "));
        brandSet.add(new Brand(9, "Monster "));
        brandSet.add(new Brand(10, "Nokia  "));
    }

    public void addBrand(Brand brand) {
        brandSet.add(brand);
    }

    public TreeSet<Brand> getBrands() {
        return brandSet;
    }


}
