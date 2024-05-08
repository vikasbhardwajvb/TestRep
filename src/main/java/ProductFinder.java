import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductFinder {
    @Data
    @AllArgsConstructor
    class AverageData {
        Double totalValue;
        int count;
    }

    private HttpClient client;
    private JsonParser jsonParser;

    public ProductAverage findAverageProductPrice(final ProductInput input) throws Exception {
        String resp = client.makeGETRequest("https://dummyjson.interviews.klue.io/products/categories/"+input.getCategory());
        System.out.println(resp);
        CategoryResponse categoryResponse = jsonParser.parseJsonToList(resp, CategoryResponse.class);

        List<Product> productList = categoryResponse.getData();

        Map<String, AverageData> brandWiseAverage = new HashMap<>();

        for(Product p : productList) {
            AverageData averageData = brandWiseAverage.getOrDefault(p.getBrand(), new AverageData(0.0,0));
            averageData.setCount(averageData.getCount()+1);
            averageData.setTotalValue(averageData.getTotalValue() + p.getPrice());
            brandWiseAverage.put(p.getBrand(), averageData);
        }

        Map<String, Double> responseMap = brandWiseAverage.
                entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e-> e.getValue().totalValue/e.getValue().count));
        return new ProductAverage(responseMap);
    }
}
