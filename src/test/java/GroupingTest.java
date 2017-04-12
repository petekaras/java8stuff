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
        Assert.assertEquals("[{NEWSPAPER=1, GROCERY=2, TOY=2}]",Arrays.asList(result).toString());
    }




}
