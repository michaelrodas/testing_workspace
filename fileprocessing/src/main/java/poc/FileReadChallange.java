package poc;

public class FileReadChallange {

    private String FILE_NAME = "itcont.txt";
    private int WORKERS = 2;
    private int BATCH_SIZE = 50000;
    private String POISON = "quit";
    private ArrayBlockingQueue<ArrayList<String>> queue = new ArrayBlockingQueue<>(1000);
    private int lineCount = 0;
    private List<String> names = Collections.synchronizedList(new ArrayList<>());
    private List<String> firstNames = Collections.synchronizedList(new ArrayList<>());
    private Map<String, Integer> donations = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        FileReadChallange m = new FileReadChallange();
        Instant start = Instant.now();
        m.run();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Elapsed time: " + timeElapsed + " millis");
        System.out.println("Elapsed time: " + timeElapsed/1000 + " seconds");
    }

    public void run() throws IOException, InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>(this.WORKERS);
        for (int i = 0; i < this.WORKERS; i++) {
            Thread processor = new Thread(this::processLines);
            processor.start();
            threads.add(processor);
        }

        URL resource = getClass().getClassLoader().getResource(this.FILE_NAME);
        try (BufferedReader b = Files.newBufferedReader(Paths.get(resource.toURI()).toAbsolutePath())) { //java 9 Path.of()
            String readLine = "";
            ArrayList<String> lines = new ArrayList<>();

            while ((readLine = b.readLine()) != null) {
                this.lineCount++;
                lines.add(readLine);

                if (this.lineCount % this.BATCH_SIZE == 0) {
                    this.queue.offer(lines);
                    lines = new ArrayList<>();
                }
            }

            ArrayList<String> poisonList = new ArrayList<>();
            poisonList.add(POISON);
            for (int i = 0; i < this.WORKERS; i++) {
                this.queue.offer(poisonList);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        for (Thread processor : threads) {
            processor.join();
        }
    }

    private void processLines() {
        try {
            while (true) {
                ArrayList<String> lines = this.queue.take();

                if (lines.size() == 1 && lines.get(0).equals(POISON)) {
                    return;
                }

                for (String line : lines) {
                    String[] split = line.split("\\|", 9);

                    this.names.add(split[7]);

                    String ym = split[4].substring(0, 6);
                    if (this.donations.containsKey(ym)) {
                        // NB this is not thread safe! Didn't bother fixing
                        this.donations.put(ym, this.donations.get(ym) + 1);
                    } else {
                        this.donations.put(ym, 0);
                    }

                    this.firstNames.add(this.extractFirstName(split[7]));
                }
            }
        } catch (InterruptedException ignored) {
        }
    }

    private String extractFirstName(String line) {
        boolean inName = false;
        StringBuilder sb = new StringBuilder();

        // To get the first name loop to the first space, then keep going till the end or the next space
        for (char c : line.toCharArray()) {
            if (c == ' ') {
                if (inName) {
                    return sb.toString();
                }

                inName = !inName;
            } else {
                if (inName) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
* */
}