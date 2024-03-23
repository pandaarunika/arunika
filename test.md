import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Data> dataList = Arrays.asList(
                new Data("sor1", 100, 50, "reason1:10|reason2:20|reason3:30"),
                new Data("sor1", 150, 70, "reason2:15|reason3:25"),
                new Data("sor2", 200, 80, "reason1:20|reason3:40"),
                new Data("sor2", 120, 60, "reason2:10|reason3:20|reason4:30"),
                new Data("sor3", 300, 90, null)
        );

        Map<String, Result> result = dataList.stream()
                .collect(Collectors.groupingBy(Data::getSor,
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                            Map<String, Integer> reasonsCount = new HashMap<>();
                            int sourceCountSum = 0;
                            int sourceCbCountSum = 0;

                            for (Data data : list) {
                                if (data.getReasons() != null) {
                                    String[] reasonPairs = data.getReasons().split("\\|");
                                    for (String pair : reasonPairs) {
                                        String[] parts = pair.split(":");
                                        String key = parts[0];
                                        int value = Integer.parseInt(parts[1]);
                                        reasonsCount.put(key, reasonsCount.getOrDefault(key, 0) + value);
                                    }
                                }
                                sourceCountSum += data.getSourceCount();
                                sourceCbCountSum += data.getSourceCbCount();
                            }

                            return new Result(reasonsCount, sourceCountSum, sourceCbCountSum);
                        })));

        result.forEach((sor, res) -> {
            System.out.println("SOR: " + sor);
            System.out.println("Reasons:");
            res.getReasons().forEach((reason, sum) -> System.out.println("  " + reason + ": " + sum));
            System.out.println("SourceCount Sum: " + res.getSourceCountSum());
            System.out.println("SourceCbCount Sum: " + res.getSourceCbCountSum());
            System.out.println();
        });
    }

    static class Data {
        private String sor;
        private int sourceCount;
        private int sourceCbCount;
        private String reasons;

        public Data(String sor, int sourceCount, int sourceCbCount, String reasons) {
            this.sor = sor;
            this.sourceCount = sourceCount;
            this.sourceCbCount = sourceCbCount;
            this.reasons = reasons;
        }

        public String getSor() {
            return sor;
        }

        public int getSourceCount() {
            return sourceCount;
        }

        public int getSourceCbCount() {
            return sourceCbCount;
        }

        public String getReasons() {
            return reasons;
        }
    }

    static class Result {
        private Map<String, Integer> reasons;
        private int sourceCountSum;
        private int sourceCbCountSum;

        public Result(Map<String, Integer> reasons, int sourceCountSum, int sourceCbCountSum) {
            this.reasons = reasons;
            this.sourceCountSum = sourceCountSum;
            this.sourceCbCountSum = sourceCbCountSum;
        }

        public Map<String, Integer> getReasons() {
            return reasons;
        }

        public int getSourceCountSum() {
            return sourceCountSum;
        }

        public int getSourceCbCountSum() {
            return sourceCbCountSum;
        }
    }
}
