package tech.diggle.apps.limasmart.realtime;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.*;

//@Component
public class RealtimePoller {
    //    @EventListener(ContextRefreshedEvent.class)
//    @PostConstruct
    public void startPolls() {
        TimerTask task = new TimerTask() {
            public void run() {
                RestTemplate restTemplate = new RestTemplate();
                URI endpoint = URI.create("https://agrisev.com/api/aos");
                List<Realtime> realtimeData = new ArrayList<>();
                try {
                    Data data = restTemplate.getForObject(endpoint, Data.class);
                    System.out.println("\n\n This" + data);

                    List<Realtime> realtimeList = data.getData();
                    if (realtimeList != null && realtimeList.size() > 1) {
                        Collections.sort(realtimeList, new SortByDate());
                        Realtime value1 = realtimeList.get(0);
                        List<Realtime> values = new ArrayList<>();
                        values.add(value1);
                        for (int i = 1; i < realtimeList.size(); i++) {
                            Long difference = value1.getCreatedAt().getTime() - realtimeList.get(i).getCreatedAt().getTime();
                            if (difference < 60000) {
                                values.add(realtimeList.get(i));
                            } else {

                                Realtime average = values.get(0);
                                int itr = 0;
                                while (itr < values.size()) {
                                    average.add(values.get(0));
                                    itr++;
                                }
                                average.average(values.size());
                                System.out.println(average);

                                values.removeAll(values);
                                value1 = realtimeList.get(i);
                                values.add(value1);
                            }

                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        };
        Timer timer = new Timer("Timer");

        long delay = 60 * 1000L;
        long period = 5000L;
        timer.scheduleAtFixedRate(task, delay, period);
    }

}

class SortByDate implements Comparator<Realtime> {

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     * <p>
     * In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.<p>
     * <p>
     * The implementor must ensure that <tt>sgn(compare(x, y)) ==
     * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>compare(x, y)</tt> must throw an exception if and only
     * if <tt>compare(y, x)</tt> throws an exception.)<p>
     * <p>
     * The implementor must also ensure that the relation is transitive:
     * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
     * <tt>compare(x, z)&gt;0</tt>.<p>
     * <p>
     * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
     * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
     * <tt>z</tt>.<p>
     * <p>
     * It is generally the case, but <i>not</i> strictly required that
     * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
     * any comparator that violates this condition should clearly indicate
     * this fact.  The recommended language is "Note: this comparator
     * imposes orderings that are inconsistent with equals."
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override
    public int compare(Realtime o1, Realtime o2) {
        return o1.getCreatedAt().compareTo(o2.getCreatedAt());
    }
}