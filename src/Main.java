import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        String resp = client.makeGETRequest("https://jsonplaceholder.typicode.com/posts/1");
        System.out.println(resp);
    }
}