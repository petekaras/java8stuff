import karas.peter.domain.Transaction;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 4/12/17.
 */
public abstract class BaseTest {
    protected List<Transaction> list = new ArrayList();
    @Before
    public void setUp(){
        list.add(new Transaction("tomatoe",new BigDecimal("20.0"), Transaction.Type.GROCERY));
        list.add(new Transaction("times",new BigDecimal("10.5"), Transaction.Type.NEWSPAPER));
        list.add(new Transaction("kite",new BigDecimal("48.9"), Transaction.Type.TOY));
        list.add(new Transaction("xbox",new BigDecimal("10.0"), Transaction.Type.TOY));
        list.add(new Transaction("potatoe",new BigDecimal("31.5"), Transaction.Type.GROCERY));
    }
}
