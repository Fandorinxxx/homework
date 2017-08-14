//package ru.alternation.Trash.Youtube.CSC.testing.demo3;
//
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.fest.assertions.api.Assertions.*;
//
///**
// <dependency>
// <groupId>org.easytesting</groupId>
// <artifactId>fest-assert-core</artifactId>
// <version>2.0M10</version>
// <scope>test</scope>
// </dependency>
// AssertJ - улучшенная версия FestAssert
// */
//
//public class HashMapTest {
//
//    @Test
//    public void default_constructor_should_create_empty_map() {
//        Map<String, String> map = new HashMap<String, String>();
//
//        assertThat(map).isEmpty();
//        assertThat(map).hasSize(0);
//        assertThat(map).doesNotContainKey("x");
//
//        assertThat(map.entrySet().iterator().hasNext()).isFalse();
//    }
//
//
//    @Test
//    public void collection_constructor_should_copy_all_content() {
//        Map<String, String> originalMap = new HashMap<String, String>();
//        originalMap.put("a", "b");
//        originalMap.put("c", "d");
//
//        Map<String, String> copiedMap = new HashMap<String, String>(originalMap);
//
//        assertThat(copiedMap)
//                .describedAs("copied map")
//                .hasSize(2)
//                .isEqualTo(originalMap)
//                .isNotSameAs(originalMap);
//
//        originalMap.put("e", "f");
//
//        assertThat(copiedMap)
//                .hasSize(2)
//                .doesNotContain(entry("e", "f"))
//                .isNotEqualTo(originalMap);
//    }
//}
