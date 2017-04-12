import karas.peter.domain.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import karas.peter.domain.Transaction.Type;

import static org.junit.Assert.*;

/**
 * Examples of basic stream operations
 */
public class AggregateOperationsTest extends BaseTest {



    @Test
    /**
     * FILTER only toys
     * filter(predicate) where predicate = a function taht returns true or false
     */
    public void filter() throws Exception {
        List<Transaction> list2 = list.stream()
                .filter(o -> o.getType() == Type.TOY).collect(Collectors.toList());
        Assert.assertEquals("[kite, xbox]",printNames(list2));
    }


    @Test
    /**
     * MAP onto a another collection
     */
    public void map(){
        List<String> list2 = list.stream()
                .map(o -> "name:" +o.getName().toString()).collect(Collectors.toList());
        Assert.assertEquals("[name:tomatoe, name:times, name:kite, name:xbox, name:potatoe]",Arrays.toString(list2.toArray()));
    }

    @Test
    /**
     * SORTED Most expensive first
     */
    public void order(){
        List<Transaction> list2 = list.stream()
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        Assert.assertEquals("[xbox, times, tomatoe, potatoe, kite]", printNames(list2));
    }

    /**
     * REDUCE all elements to a concatenated string
     * note that these are sometimes called terminal operations as they dont return a stream, but complete a pipeline
     * of streams.
     * sum, average and count are all reduction functions that come as part of the streams API.
     */
    @Test
    public void reduce(){
       String result = list.stream()
               .map(e->e.getName())
               .reduce((a,b) -> a + ","+ b)
               .get();

        Assert.assertEquals("tomatoe,times,kite,xbox,potatoe",result);
    }

    /**
     * REDUCE : get the maximum value
     */
    @Test
    public void reduceMaxValue(){
        BigDecimal result = list.stream()
                .map(e->e.getValue())
                .reduce(BigDecimal::max)
                .get();

        Assert.assertEquals(48.9,result.doubleValue(),0);
    }

    @Test
    public void forEach(){
        StringBuilder sb = new StringBuilder();
        list.forEach(c -> sb.append(c.getName()));
        Assert.assertEquals("tomatoetimeskitexboxpotatoe",sb.toString());

    }

    /**
     * LIMIT : get only the first toy
     */
    @Test
    public void limit(){
        List<Transaction> list2 = list.stream()
                .filter(o -> o.getType() == Type.TOY)
                .limit(1)
                .collect(Collectors.toList());

        Assert.assertEquals("[kite]",printNames(list2));

    }

    /**
     * Skip the first toy
     */
    @Test
    public void skip(){
        List<Transaction> list2 = list.stream()
                .filter(o -> o.getType() == Type.TOY)
                .skip(1)
                .collect(Collectors.toList());

        Assert.assertEquals("[xbox]",printNames(list2));

    }

    @Test
    public void anyMatch(){
        boolean match = list.stream()
                .anyMatch(o -> o.getName().contains("x"));
        Assert.assertEquals(true,match);
    }

    @Test
    public void noneMatch(){
        boolean match = list.stream()
                .noneMatch(o -> o.getName().contains("x"));
        Assert.assertEquals(false,match);
    }

    /**
     * Find any toy that contains the character o
     */
    @Test
    public void findAny(){
       Optional<Transaction> result = list.stream()
               .filter(o -> o.getName().contains("o") && o.getType() == Type.TOY)
               .findAny();
        Assert.assertEquals("xbox",result.get().getName());
    }


    private String printNames(List<Transaction> result){
        return Arrays.toString(result.stream().map(o -> o.getName()).toArray(String[]::new));
    }

}