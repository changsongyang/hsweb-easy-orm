package org.hswebframework.ezorm.rdb.executor;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqlTemplateParserTest {


    @Test
    public void testParse() {

        SqlRequest request = SqlTemplateParser.parse("select * from user where name = #{name}", (__) -> "1234");

        assertNotNull(request);
        assertEquals(request.getSql(),"select * from user where name = ?");
        assertArrayEquals(request.getParameters(),new Object[]{"1234"} );

        assertTrue(request instanceof SimpleSqlRequest);

        assertEquals(((SimpleSqlRequest) request).toNativeSql(),"select * from user where name = '1234'");


    }
}