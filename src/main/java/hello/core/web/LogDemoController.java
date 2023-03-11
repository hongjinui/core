package hello.core.web;

import hello.core.common.MyLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLog myLog;

//    private final ObjectProvider<MyLog> myLogProvider; provider 사용

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {

        String requestURI = request.getRequestURL().toString();

//        MyLog myLog = myLogProvider.getObject();
        myLog.setRequestURL(requestURI);

        Thread.sleep(1000);

        myLog.log("controller test");
        logDemoService.logic("testId");

        return "OK";

    }
}
