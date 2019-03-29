import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainTest {
    @Test
    public void tempTest() {
        Map<String,String> lhm=new LinkedHashMap<>();
        for(int i=0;i<100;++i){
            lhm.put("abc"+i,"abc"+i);
        }
        Map<String,String> hm=new HashMap<>();
        for(int i=0;i<100;++i){
            hm.put("abc"+i,"abc"+i);
        }
        for(Map.Entry<String,String> s:hm.entrySet()){
            System.out.println(s.getValue());
        }
        System.out.println("===========================================");
        lhm.forEach((s, s2) -> System.out.println(s2));

    }
}
