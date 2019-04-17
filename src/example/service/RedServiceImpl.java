package example.service;

import annotation.Component;


@Component
public class RedServiceImpl implements ColorService {

    public RedServiceImpl() {
    }

    @Override
    public String toString() {
        return "red";
    }


}
