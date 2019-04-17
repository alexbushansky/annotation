package example.service;

import annotation.Component;


@Component
public class BlueServiceImpl implements ColorService {


    @Override
    public String toString() {
        return "blue";
    }
}
