package karas.peter.domain;

import org.joda.time.DateTime;
import java.math.BigDecimal;

/**
 * Created by peter on 4/5/17.
 */
public class Transaction {
    public static enum Type {
        GROCERY,TOY,NEWSPAPER
    }
    private BigDecimal value;
    private DateTime date;
    private Type type;
    private String name;

    public Transaction(String name, BigDecimal value, Type type) {
        this.value = value;
        this.type = type;
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
