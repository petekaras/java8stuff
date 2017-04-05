import karas.peter.domain.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import karas.peter.domain.Transaction.Type;

import static org.junit.Assert.*;

/**
 * Examples of basic stream operations
 */
public class AggregateOperationsTest {
    List<Transaction> list = new ArrayList();
    @Before
    public void setUp(){
        list.add(new Transaction("tomatoe",new BigDecimal("20.0"),Type.GROCERY));
        list.add(new Transaction("times",new BigDecimal("10.5"),Type.NEWSPAPER));
        list.add(new Transaction("kite",new BigDecimal("20.0"),Type.TOY));
        list.add(new Transaction("xbox",new BigDecimal("10.0"),Type.TOY));
        list.add(new Transaction("potatoe",new BigDecimal("31.5"),Type.GROCERY));
    }

    @Test
    /**
     * Filter only toys
     */
    public void filter() throws Exception {
        long count = list.stream()
                .filter(o -> o.getType() == Type.NEWSPAPER)
                .count();

        Assert.assertEquals(1,count);
    }

    @Test
    /**
     * Map onto a another collection
     */
    public void map(){
        String[] list2 = list.stream()
                .map(o -> "name:" +o.getName().toString())
                .toArray(String[]::new);
        Assert.assertEquals("[name:tomatoe, name:times, name:kite, name:xbox, name:potatoe]", Arrays.toString(list2));
    }

    @Test
    /**
     * Most expensive first
     */
    public void order(){
        List<Transaction> list2 = list.stream()
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        Assert.assertEquals("[xbox, times, tomatoe, kite, potatoe]", Arrays.toString(list2.stream().map(o -> o.getName()).toArray(String[]::new)));
    }

}