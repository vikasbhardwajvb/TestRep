import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Test {
    public static void main(String[] args) throws Exception {
        ProductFinder productFinder = new ProductFinder(new HttpClient(), new JsonParser());
        ProductInput productInput = ProductInput.builder().category("smartphones").build();
        System.out.println(productFinder.findAverageProductPrice(productInput).getBrandAverage());
    }
}