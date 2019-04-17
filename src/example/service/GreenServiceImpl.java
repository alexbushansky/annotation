package example.service;

import annotation.Component;

@Component
public class GreenServiceImpl implements ColorService {
    @Override
    public String toString() {
        return "green";
    }
}
