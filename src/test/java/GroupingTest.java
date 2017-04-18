import karas.peter.domain.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by peter on 4/12/17.
 */
public class GroupingTest extends BaseTest{

    @Test
    public void countByType(){
       Map<Transaction.Type,Long> result = list.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getType,
                        Collectors.counting()
                ));
        Assert.assertEquals(new Long(2),result.get(Transaction.Type.GROCERY));
        Assert.assertEquals(new Long(2),result.get(Transaction.Type.TOY));
        Assert.assertEquals(new Long(1),result.get(Transaction.Type.NEWSPAPER));
    }




}
