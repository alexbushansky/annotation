package example.service;

public interface ColorService {
    default void define() {
        System.out.println(this.toString());
    }
}
