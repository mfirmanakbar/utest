package com.firman.utest.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class JsonPathTest {

    /**
     * Documentation:
     * https://github.com/json-path/JsonPath
     *
     * */
    @Test
    public void learning() {
        String response = "[{\"id\":1001,\"name\":\"Item1\",\"quantity\":10},{\"id\":1002,\"name\":\"Item2\",\"quantity\":20}]";

        DocumentContext context = JsonPath.parse(response);

        int length = context.read("$.length()");
        Assertions.assertThat(length).isEqualTo(2);

        List<Integer> ids = context.read("$..id");
        Assertions.assertThat(ids).containsExactly(1001, 1002);

        System.out.println("\nPART-1");
        System.out.println(context.read("$.[1]").toString());

        System.out.println("\nPART-2");
        System.out.println(context.read("$.[0:1]").toString());

        System.out.println("\nPART-3");
        System.out.println(context.read("$.[?(@.name=='Item2')]").toString());

        System.out.println("\nPART-4");
        System.out.println(context.read("$.[?(@.quantity==20)]").toString());

    }

}
