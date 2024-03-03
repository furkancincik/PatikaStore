import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class Brand implements Comparable<Brand>{
    private int id;
    private String name;


    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Brand other) {
        return this.name.compareTo(other.getName());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}