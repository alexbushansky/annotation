package example.service;


import annotation.Autowired;
import annotation.Component;

@Component
public class PinkServiceImpl implements MixedColorService,ColorService {

    @Autowired
     private ColorService red;
    @Autowired
     private ColorService blue;
    @Override
    public void mix() {
        System.out.println(String.format("pink = %s + %s", red.toString(), blue.toString()));
    }

    @Override
    public String toString() {
        return "pink";
    }

    @Override
    public void define() {
        mix();
    }
}
