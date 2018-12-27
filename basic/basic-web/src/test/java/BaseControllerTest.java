import com.sl.basic.web.controller.BaseController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class BaseControllerTest {
    @Test
    public void testBasePage() throws Exception {
        BaseController baseController = new BaseController();
        //Assert.assertEquals("home",baseController.home());
        //搭建mockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(baseController).build();
        //对"/base/index"执行GET请求 预期得到home视图
        mockMvc.perform(MockMvcRequestBuilders.get("/base/index")).andExpect(MockMvcResultMatchers.view().name("home"));
    }
}
