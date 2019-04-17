package example.service;

import annotation.Autowired;
import annotation.Component;

@Component
public class SecondServiceImpl implements Service {
    @Autowired
    ServiceImpl service;

}
