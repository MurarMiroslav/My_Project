package mm.behavioral.templateMethod;

public class Main {

    public static void main(String[] args) {
        PerformanceTestTemplate testTemplate = new RandomListSortingPerformanceTest();
        testTemplate.run();

        testTemplate = new StringBuilderAppendPerformanceTest();
        testTemplate.run();
    }
}
