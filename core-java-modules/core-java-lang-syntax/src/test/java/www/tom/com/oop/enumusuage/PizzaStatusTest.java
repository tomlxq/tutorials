package www.tom.com.oop.enumusuage;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class PizzaStatusTest {

    @Test
    public void test(){
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        System.out.println(JSON.toJSONString(pz));
    }
}
