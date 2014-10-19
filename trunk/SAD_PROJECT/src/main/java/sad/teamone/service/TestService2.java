package sad.teamone.service;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Service;
import sad.teamone.dao.TestDAO;

/**
 * Created by Tuyen on 10/19/2014.
 */
@Service
public class TestService2 implements TestService {

    @Autowired
    private TestDAO testDAO;

    @Override
    public String getMessage() {
        String msg = testDAO.sayHello();
        return msg  + " - Test Service 22222";
    }
}
