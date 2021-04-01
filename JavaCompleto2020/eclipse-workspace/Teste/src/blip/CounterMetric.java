package blip;

import java.util.Map;

public interface CounterMetric {

    void incrementCounter(String metricName);

    Integer getCounterValue(String metricName);

    Map<String, Integer> getCountersValue();
}
