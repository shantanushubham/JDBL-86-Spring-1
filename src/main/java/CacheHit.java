import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheHit {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java CurlExecutor <url> <nThreads> <xTimes>");
            return;
        }

        String url = args[0];
        int nThreads = Integer.parseInt(args[1]);
        int xTimes = Integer.parseInt(args[2]);

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < xTimes; i++) {
            executor.submit(new CurlTask(url));
        }

        executor.shutdown();
        System.out.println("Submitted " + xTimes + " tasks with " + nThreads + " threads.");
    }
}

class CurlTask implements  Runnable {

    private final String url;

    public CurlTask(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println(Thread.currentThread().getName() +
                    " -> GET " + url + " | Response Code: " + responseCode);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                // Print only first 100 chars for brevity
                System.out.println(Thread.currentThread().getName() +
                        " -> Response snippet: " + response.substring(0, Math.min(100, response.length())));
            }        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
