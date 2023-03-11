package hello.core.web;

import hello.core.common.MyLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLog myLog;
//    private final ObjectProvider<MyLog> myLogProvider; provider 사용

    public void logic(String id) {

//        MyLog myLog = myLogProvider.getObject();
        myLog.log("service id = " + id);

    }
}
