package TestDaily;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {
    @Test
    public void testPatter(){
        Pattern p  = Pattern.compile(".+拨打了10086热线（工号：(.*?)），请您点击链接.+");
        String c = "尊敬的客户，您于10月10日拨打了10086热线（工号：），请您点击链接：https://eva.customer.10086.cn/hfx/******* （评价即可参与抽奖）对本次通话进行评价感谢您的支持！如需退订短信评价，请回复TD【中国移动】";
        Matcher m = p.matcher(c);
        System.out.println(m.matches());
        System.out.println(m.groupCount());
        System.out.println(m.group(1));
    }
}
