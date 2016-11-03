package org.polyjdbc.core.dialect;

/**
 *
 * @author Adam Dubiel
 */
public class DB2DialectTypes extends DefaultDialectTypes {

    @Override
    public String character() {
        return "VARCHAR(1)";
    }

    @Override
    public String text() {
        return "CLOB";
    }

    @Override
    public String bool() {
        return "SMALLINT(1)";
    }

    @Override
    public String bigint(int integerPrecision) {
        return "BIGINT";
    }

    @Override
    public String integer(int integerPrecision) {
        return "INTEGER";
    }

    @Override
    public String string(int characters) {
        return "VARCHAR(" + characters + ")";
    }

    @Override
    public String number(int integerPrecision, int decimalPrecision) {
        return "DECIMAL(" + integerPrecision + "," + decimalPrecision + ")";
    }

    @Override
    public String floatType() {
        return "FLOAT";
    }
}
