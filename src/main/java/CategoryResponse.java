import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
public class CategoryResponse {

    private List<Product> data;
}
