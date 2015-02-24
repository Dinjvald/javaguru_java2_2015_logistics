package lv.javaguru.java2.servlet.mvc;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;

/**
 * Created by andre on 17.02.2015.
 */
@Component
@URL(value="/cargoReg")
public class CargoRegController implements MVCController {


    @Override
    public MVCModel processRequest(HttpServletRequest request,
                                   HttpServletResponse response) {


        List<User> userList = new ArrayList<User>();
        UserDAOImpl userDAO = new UserDAOImpl();

        try {
            userList = userDAO.getAll();
        } catch (DBException e) {
            System.out.println("Exception while getting user listo CargoRegController");
            e.printStackTrace();
        }


        MVCModel model = new MVCModel("/jsp/cargoreg.jsp", userList);
        return model;

    }
}
