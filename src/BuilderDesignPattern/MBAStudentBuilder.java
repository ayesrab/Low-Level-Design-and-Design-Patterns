package BuilderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects() {
        List<String> subs = new ArrayList<>();
        subs.add("Commerce");
        subs.add("Economics");
        subs.add("Business Management");
        this.subjects = subs;
        return this;
    }
}
