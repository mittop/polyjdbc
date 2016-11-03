package org.polyjdbc.core.dialect;

import org.polyjdbc.core.query.Query;

public class DB2DialectQueries implements DialectQueries {
    @Override
    public void limit(Query query, Limit limit, boolean isOrdered) {

        if (limit.isEmpty()){
            return;
        }

        if (limit.getOffset() == 0){
            query.wrap("SELECT a.*, rownumber() over() AS rownum FROM (", ") a WHERE rownum <= " + limit.getLimit());
        } else {
            int lowRownum = limit.getOffset() + 1;
            int highRownum = limit.getOffset() + limit.getLimit();
            query.wrap(
            "select b.* from (SELECT a.*, rownumber() over() AS rownum r__ FROM (",
            ") a WHERE rownum <= "+highRownum+" ) b where b.r__ >= "+lowRownum);
        }
    }
}
