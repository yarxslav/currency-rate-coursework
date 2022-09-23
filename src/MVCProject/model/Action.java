package MVCProject.model;

import javax.servlet.http.HttpServletRequest;

public interface Action {

    String process(HttpServletRequest request);

}
