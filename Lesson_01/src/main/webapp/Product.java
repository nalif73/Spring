package src.main.webapp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    protected int id;
    protected String title;
    protected int cost;
}